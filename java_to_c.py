import javalang
import os
import sys

def traducir_expr(expr):
    if isinstance(expr, javalang.tree.Literal):
        return expr.value
    elif isinstance(expr, javalang.tree.BinaryOperation):
        izquierda = traducir_expr(expr.operandl)
        derecha = traducir_expr(expr.operandr)
        return f"{izquierda} {expr.operator} {derecha}"
    elif isinstance(expr, javalang.tree.MemberReference):
        return expr.member
    elif isinstance(expr, javalang.tree.MethodInvocation):
        if expr.qualifier == "System.out" and expr.member == "println":
            args = ', '.join([traducir_expr(arg) for arg in expr.arguments])
            return f'printf({args});'
        else:
            args = ', '.join([traducir_expr(arg) for arg in expr.arguments])
            return f"{expr.member}({args});"
    elif isinstance(expr, javalang.tree.Cast):
        return traducir_expr(expr.expression)
    else:
        return str(expr)

def traducir_sentencia(stmt, nivel=1):
    indent = '    ' * nivel
    resultado = []

    if isinstance(stmt, javalang.tree.StatementExpression):
        expr = traducir_expr(stmt.expression)
        resultado.append(f"{indent}{expr}")
    
    elif isinstance(stmt, javalang.tree.LocalVariableDeclaration):
        tipo = stmt.type.name.lower()
        tipo_c = "int" if tipo == "int" else "float" if tipo == "float" else "char*"
        for declarator in stmt.declarators:
            nombre = declarator.name
            valor = traducir_expr(declarator.initializer)
            resultado.append(f"{indent}{tipo_c} {nombre} = {valor};")
    
    elif isinstance(stmt, javalang.tree.IfStatement):
        condicion = traducir_expr(stmt.condition)
        resultado.append(f"{indent}if ({condicion}) {{")
        resultado.extend(traducir_bloque(stmt.then_statement, nivel + 1))
        resultado.append(f"{indent}}}")
        if stmt.else_statement:
            resultado.append(f"{indent}else {{")
            resultado.extend(traducir_bloque(stmt.else_statement, nivel + 1))
            resultado.append(f"{indent}}}")

    else:
        resultado.append(f"{indent}// No soportado: {stmt}")
    
    return resultado

def traducir_bloque(bloque, nivel=1):
    resultado = []
    if bloque is None:
        return resultado

    if isinstance(bloque, list):
        for stmt in bloque:
            resultado.extend(traducir_sentencia(stmt, nivel))
    elif hasattr(bloque, 'statements'):
        for stmt in bloque.statements:
            resultado.extend(traducir_sentencia(stmt, nivel))
    else:
        resultado.extend(traducir_sentencia(bloque, nivel))

    return resultado

def traducir_clase_y_metodos(tree):
    resultado = ["#include <stdio.h>", ""]
    for tipo in tree.types:
        if isinstance(tipo, javalang.tree.ClassDeclaration):
            for miembro in tipo.body:
                if isinstance(miembro, javalang.tree.MethodDeclaration):
                    nombre_metodo = "main" if miembro.name == "main" else miembro.name
                    resultado.append(f"int {nombre_metodo}() {{")
                    resultado.extend(traducir_bloque(miembro.body, nivel=1))
                    resultado.append("    return 0;")
                    resultado.append("}")
    return resultado

def traducir_archivo_java_a_c(ruta_archivo_java):
    with open(ruta_archivo_java, 'r') as f:
        codigo_java = f.read()

    print("📥 Código Java original:\n")
    print(codigo_java)
    print("\n📤 Código traducido a C:\n")

    tree = javalang.parse.parse(codigo_java)
    resultado = traducir_clase_y_metodos(tree)
    return '\n'.join(resultado)

def guardar_como_c(nombre_entrada, codigo_c):
    nombre_salida = os.path.splitext(nombre_entrada)[0] + ".c"
    with open(nombre_salida, "w") as f:
        f.write(codigo_c)
    print(f"✅ Código traducido guardado en: {nombre_salida}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python3 java_to_c.py archivo.java")
        sys.exit(1)

    archivo_java = sys.argv[1]
    codigo_c = traducir_archivo_java_a_c(archivo_java)
    print(codigo_c)
    guardar_como_c(archivo_java, codigo_c)
