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
        args = ', '.join([traducir_expr(arg) for arg in expr.arguments])
        return f"{expr.member}({args})"
    elif isinstance(expr, javalang.tree.Cast):
        return traducir_expr(expr.expression)
    elif isinstance(expr, javalang.tree.VariableDeclarator):
        return traducir_expr(expr.initializer)
    elif isinstance(expr, javalang.tree.This):
        return "this"
    else:
        return str(expr)

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

def traducir_sentencia(stmt, nivel=1):
    indent = '    ' * nivel
    resultado = []

    if isinstance(stmt, javalang.tree.StatementExpression):
        if isinstance(stmt.expression, javalang.tree.MethodInvocation):
            if stmt.expression.qualifier == 'System.out' and stmt.expression.member == 'println':
                args = ', '.join([traducir_expr(arg) for arg in stmt.expression.arguments])
                resultado.append(f"{indent}console.log({args});")
            else:
                args = ', '.join([traducir_expr(arg) for arg in stmt.expression.arguments])
                resultado.append(f"{indent}{stmt.expression.member}({args});")

    elif isinstance(stmt, javalang.tree.LocalVariableDeclaration):
        for declarator in stmt.declarators:
            nombre = declarator.name
            valor = traducir_expr(declarator.initializer)
            resultado.append(f"{indent}let {nombre} = {valor};")

    elif isinstance(stmt, javalang.tree.ForStatement):
        init = stmt.control.init
        if isinstance(init, javalang.tree.VariableDeclaration):
            declarator = init.declarators[0]
            var = declarator.name
            inicio = traducir_expr(declarator.initializer)
            condition = stmt.control.condition
            fin = traducir_expr(condition.operandr) if isinstance(condition, javalang.tree.BinaryOperation) else 'TODO'
            resultado.append(f"{indent}for (let {var} = {inicio}; {var} < {fin}; {var}++) {{")
            resultado.extend(traducir_bloque(stmt.body, nivel + 1))
            resultado.append(f"{indent}}}")
        else:
            resultado.append(f"{indent}// for-loop no soportado")

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

def traducir_clase_y_metodos(tree):
    resultado = []

    for tipo in tree.types:
        if isinstance(tipo, javalang.tree.ClassDeclaration):
            resultado.append(f"// Clase traducida: {tipo.name}")
            for miembro in tipo.body:
                if isinstance(miembro, javalang.tree.MethodDeclaration):
                    nombre_metodo = miembro.name
                    resultado.append(f"function {nombre_metodo}() {{")
                    resultado.extend(traducir_bloque(miembro.body, nivel=1))
                    resultado.append("}")

    return resultado

def traducir_archivo_java_a_js(ruta_archivo_java):
    with open(ruta_archivo_java, 'r') as f:
        codigo_java = f.read()

    print("📥 Código Java original:\n")
    print(codigo_java)
    print("\n📤 Código traducido a JavaScript:\n")

    tree = javalang.parse.parse(codigo_java)
    resultado = traducir_clase_y_metodos(tree)
    return '\n'.join(resultado)

def guardar_como_js(nombre_entrada, codigo_js):
    nombre_salida = os.path.splitext(nombre_entrada)[0] + ".js"
    with open(nombre_salida, "w") as f:
        f.write(codigo_js)
    print(f"✅ Código traducido guardado en: {nombre_salida}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python3 java_to_javascript.py archivo.java")
        sys.exit(1)

    archivo_java = sys.argv[1]
    codigo_js = traducir_archivo_java_a_js(archivo_java)
    print(codigo_js)
    guardar_como_js(archivo_java, codigo_js)

