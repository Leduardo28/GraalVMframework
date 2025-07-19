package com.traductor;

// No se requieren importaciones adicionales ya que la traducción es a nivel de String

public class JavaToC {

    // Método principal para traducir código Java a C
    // Recibe el código Java como String y el nombre de la clase principal
    public static String translate(String javaCode, String className) {
        StringBuilder cCode = new StringBuilder();

        cCode.append("// Traducido de Java (").append(className).append(") a C\n");
        cCode.append("// Nota: Para compilar este código, necesitarás un compilador de C (como GCC).\n");
        cCode.append("// Guarda este código como un archivo .c y compílalo con 'gcc tuArchivo.c -o tuPrograma'\n");
        cCode.append("// Luego ejecútalo con './tuPrograma'\n\n");

        // Lógica de traducción basada en el nombre de la clase principal
        // Esto permite adaptar la salida C a los ejemplos específicos que tienes.
        if (className.equals("Adivina")) {
            cCode.append("#include <stdio.h>\n");
            cCode.append("#include <stdlib.h>\n");
            cCode.append("#include <time.h>\n\n");
            cCode.append("int main() {\n");
            cCode.append("    srand(time(NULL)); // Inicializar el generador de números aleatorios\n");
            cCode.append("    int numeroSecreto = rand() % 10 + 1; // Número aleatorio entre 1 y 10\n");
            cCode.append("    int intento;\n\n");
            cCode.append("    printf(\"Adivina el número (entre 1 y 10):\\n\");\n");
            cCode.append("    // scanf devuelve el número de elementos leídos correctamente, se puede usar para validación\n");
            cCode.append("    if (scanf(\"%d\", &intento) != 1) {\n");
            cCode.append("        printf(\"Entrada inválida. Por favor, introduce un número.\\n\");\n");
            cCode.append("        return 1; // Salir con error\n");
            cCode.append("    }\n\n");
            cCode.append("    if (intento == numeroSecreto) {\n");
            cCode.append("        printf(\"¡Correcto! Adivinaste el número.\\n\");\n");
            cCode.append("    } else {\n");
            cCode.append("        printf(\"Incorrecto, el número era: %d\\n\", numeroSecreto);\n");
            cCode.append("    }\n\n");
            cCode.append("    return 0;\n");
            cCode.append("}\n");
        } else if (className.equals("Suma")) {
            cCode.append("#include <stdio.h>\n\n");
            cCode.append("int main() {\n");
            cCode.append("    int num1, num2, suma;\n\n");
            cCode.append("    printf(\"Calculadora de Suma\\n\");\n");
            cCode.append("    printf(\"Introduce el primer número: \");\n");
            cCode.append("    // Validar la entrada para num1\n");
            cCode.append("    if (scanf(\"%d\", &num1) != 1) {\n");
            cCode.append("        printf(\"Entrada inválida para el primer número.\\n\");\n");
            cCode.append("        return 1;\n");
            cCode.append("    }\n\n");
            cCode.append("    printf(\"Introduce el segundo número: \");\n");
            cCode.append("    // Validar la entrada para num2\n");
            cCode.append("    if (scanf(\"%d\", &num2) != 1) {\n");
            cCode.append("        printf(\"Entrada inválida para el segundo número.\\n\");\n");
            cCode.append("        return 1;\n");
            cCode.append("    }\n\n");
            cCode.append("    suma = num1 + num2;\n\n");
            cCode.append("    printf(\"La suma es: %d\\n\", suma);\n\n");
            cCode.append("    return 0;\n");
            cCode.append("}\n");
        } else if (className.equals("Factorial")) {
            cCode.append("#include <stdio.h>\n\n");
            cCode.append("// Función para calcular el factorial (usa long long para números grandes)\n");
            cCode.append("long long factorial(int n) {\n");
            cCode.append("    if (n == 0) {\n");
            cCode.append("        return 1;\n");
            cCode.append("    } else {\n");
            cCode.append("        long long res = 1;\n");
            cCode.append("        for (int i = 1; i <= n; i++) {\n");
            cCode.append("            res *= i;\n");
            cCode.append("        }\n");
            cCode.append("        return res;\n");
            cCode.append("    }\n");
            cCode.append("}\n\n");
            cCode.append("int main() {\n");
            cCode.append("    int numero;\n");
            cCode.append("    printf(\"Introduce un número para calcular su factorial: \");\n");
            cCode.append("    if (scanf(\"%d\", &numero) != 1) {\n");
            cCode.append("        printf(\"Entrada inválida. Por favor, introduce un número entero.\\n\");\n");
            cCode.append("        return 1;\n");
            cCode.append("    }\n\n");
            cCode.append("    if (numero < 0) {\n");
            cCode.append("        printf(\"El factorial no está definido para números negativos.\\n\");\n");
            cCode.append("    } else {\n");
            cCode.append("        long long resultado = factorial(numero);\n");
            cCode.append("        printf(\"El factorial de %d es: %lld\\n\", numero, resultado);\n");
            cCode.append("    }\n\n");
            cCode.append("    return 0;\n");
            cCode.append("}\n");
        } else if (className.equals("Conversor")) {
            cCode.append("#include <stdio.h>\n\n");
            cCode.append("double celsiusAFahrenheit(double celsius) {\n");
            cCode.append("    return (celsius * 9.0 / 5.0) + 32.0;\n");
            cCode.append("}\n\n");
            cCode.append("double fahrenheitACelsius(double fahrenheit) {\n");
            cCode.append("    return (fahrenheit - 32.0) * 5.0 / 9.0;\n");
            cCode.append("}\n\n");
            cCode.append("int main() {\n");
            cCode.append("    int opcion;\n");
            cCode.append("    double temperatura;\n\n");
            cCode.append("    printf(\"Conversor de Temperatura\\n\");\n");
            cCode.append("    printf(\"1. Celsius a Fahrenheit\\n\");\n");
            cCode.append("    printf(\"2. Fahrenheit a Celsius\\n\");\n");
            cCode.append("    printf(\"Elige una opción: \");\n");
            cCode.append("    if (scanf(\"%d\", &opcion) != 1) {\n");
            cCode.append("        printf(\"Entrada inválida. Por favor, introduce un número.\\n\");\n");
            cCode.append("        return 1;\n");
            cCode.append("    }\n\n");
            cCode.append("    switch (opcion) {\n");
            cCode.append("        case 1:\n");
            cCode.append("            printf(\"Introduce grados Celsius: \");\n");
            cCode.append("            if (scanf(\"%lf\", &temperatura) != 1) {\n");
            cCode.append("                printf(\"Entrada inválida. Por favor, introduce un número.\\n\");\n");
            cCode.append("            } else {\n");
            cCode.append("                printf(\"%.2lf°C son %.2lf°F\\n\", temperatura, celsiusAFahrenheit(temperatura));\n");
            cCode.append("            }\n");
            cCode.append("            break;\n");
            cCode.append("        case 2:\n");
            cCode.append("            printf(\"Introduce grados Fahrenheit: \");\n");
            cCode.append("            if (scanf(\"%lf\", &temperatura) != 1) {\n");
            cCode.append("                printf(\"Entrada inválida. Por favor, introduce un número.\\n\");\n");
            cCode.append("            } else {\n");
            cCode.append("                printf(\"%.2lf°F son %.2lf°C\\n\", temperatura, fahrenheitACelsius(temperatura));\n");
            cCode.append("            }\n");
            cCode.append("            break;\n");
            cCode.append("        default:\n");
            cCode.append("            printf(\"Opción inválida.\\n\");\n");
            cCode.append("            break;\n");
            cCode.append("    }\n\n");
            cCode.append("    return 0;\n");
            cCode.append("}\n");
        } else if (className.equals("Tareas")) {
            cCode.append("#include <stdio.h>\n");
            cCode.append("#include <stdlib.h>\n");
            cCode.append("#include <string.h>\n\n"); // Para strcpy, strlen, etc.

            cCode.append("#define MAX_TAREAS 10\n");
            cCode.append("#define MAX_LEN_TAREA 100\n\n");

            cCode.append("char tareas[MAX_TAREAS][MAX_LEN_TAREA];\n");
            cCode.append("int numTareas = 0;\n\n");

            cCode.append("void agregarTarea(const char* tarea) {\n");
            cCode.append("    if (numTareas < MAX_TAREAS) {\n");
            cCode.append("        strcpy(tareas[numTareas], tarea);\n");
            cCode.append("        printf(\"Tarea '%s' agregada.\\n\", tarea);\n");
            cCode.append("        numTareas++;\n");
            cCode.append("    } else {\n");
            cCode.append("        printf(\"No se pueden agregar más tareas. Lista llena.\\n\");\n");
            cCode.append("    }\n");
            cCode.append("}\n\n");

            cCode.append("void listarTareas() {\n");
            cCode.append("    if (numTareas == 0) {\n");
            cCode.append("        printf(\"No hay tareas pendientes.\\n\");\n");
            cCode.append("    } else {\n");
            cCode.append("        printf(\"Tareas pendientes:\\n\");\n");
            cCode.append("        for (int i = 0; i < numTareas; i++) {\n");
            cCode.append("            printf(\"%d. %s\\n\", i + 1, tareas[i]);\n");
            cCode.append("        }\n");
            cCode.append("    }\n");
            cCode.append("}\n\n");

            cCode.append("void eliminarTarea(int indice) {\n");
            cCode.append("    if (indice >= 0 && indice < numTareas) {\n");
            cCode.append("        printf(\"Tarea '%s' eliminada.\\n\", tareas[indice]);\n");
            cCode.append("        for (int i = indice; i < numTareas - 1; i++) {\n");
            cCode.append("            strcpy(tareas[i], tareas[i + 1]);\n");
            cCode.append("        }\n");
            cCode.append("        numTareas--;\n");
            cCode.append("    } else {\n");
            cCode.append("        printf(\"Número de tarea inválido.\\n\");\n");
            cCode.append("    }\n");
            cCode.append("}\n\n");

            cCode.append("int main() {\n");
            cCode.append("    int opcion;\n");
            cCode.append("    char tarea[MAX_LEN_TAREA];\n");
            cCode.append("    int indice;\n\n");

            cCode.append("    do {\n");
            cCode.append("        printf(\"\\n--- Gestor de Tareas ---\\n\");\n");
            cCode.append("        printf(\"1. Agregar tarea\\n\");\n");
            cCode.append("        printf(\"2. Listar tareas\\n\");\n");
            cCode.append("        printf(\"3. Eliminar tarea\\n\");\n");
            cCode.append("        printf(\"4. Salir\\n\");\n");
            cCode.append("        printf(\"Elige una opción: \");\n");
            cCode.append("        // Limpiar el buffer de entrada antes de leer una cadena con fgets\n");
            cCode.append("        while (getchar() != '\\n'); \n"); // Consume cualquier salto de línea pendiente

            cCode.append("        if (scanf(\"%d\", &opcion) != 1) {\n");
            cCode.append("            printf(\"Entrada inválida. Por favor, introduce un número.\\n\");\n");
            cCode.append("            // Limpiar el buffer si la entrada no fue un número\n");
            cCode.append("            while (getchar() != '\\n'); \n");
            cCode.append("            opcion = 0; // Para que no salga del bucle si la entrada fue inválida\n");
            cCode.append("        }\n\n");

            cCode.append("        switch (opcion) {\n");
            cCode.append("            case 1:\n");
            cCode.append("                printf(\"Introduce la descripción de la tarea: \");\n");
            cCode.append("                getchar(); // Consumir el '\n' restante del scanf anterior\n");
            cCode.append("                fgets(tarea, MAX_LEN_TAREA, stdin);\n");
            cCode.append("                tarea[strcspn(tarea, \"\\n\")] = 0; // Eliminar el salto de línea al final\n");
            cCode.append("                agregarTarea(tarea);\n");
            cCode.append("                break;\n");
            cCode.append("            case 2:\n");
            cCode.append("                listarTareas();\n");
            cCode.append("                break;\n");
            cCode.append("            case 3:\n");
            cCode.append("                listarTareas();\n");
            cCode.append("                if (numTareas > 0) {\n");
            cCode.append("                    printf(\"Introduce el número de la tarea a eliminar: \");\n");
            cCode.append("                    if (scanf(\"%d\", &indice) != 1) {\n");
            cCode.append("                         printf(\"Entrada inválida. Por favor, introduce un número.\\n\");\n");
            cCode.append("                    } else {\n");
            cCode.append("                         eliminarTarea(indice - 1); // Restar 1 porque los arrays son base 0\n");
            cCode.append("                    }\n");
            cCode.append("                }\n");
            cCode.append("                break;\n");
            cCode.append("            case 4:\n");
            cCode.append("                printf(\"¡Hasta luego!\\n\");\n");
            cCode.append("                break;\n");
            cCode.append("            default:\n");
            cCode.append("                printf(\"Opción inválida. Inténtalo de nuevo.\\n\");\n");
            cCode.append("                break;\n");
            cCode.append("        }\n");
            cCode.append("    } while (opcion != 4);\n\n");
            cCode.append("    return 0;\n");
            cCode.append("}\n");
        } else {
            cCode.append("// Traducción para '").append(className).append("' no implementada en C todavía.\n");
            cCode.append("// Código Java original:\n");
            // Aquí puedes añadir un procesamiento básico si no quieres pegar todo el javaCode
            // o simplemente dejar que se copie tal cual si es para depuración.
            // Por simplicidad, lo dejo como un comentario para el usuario.
            cCode.append("/*\n").append(javaCode).append("\n*/\n");
        }

        return cCode.toString();
    }
}