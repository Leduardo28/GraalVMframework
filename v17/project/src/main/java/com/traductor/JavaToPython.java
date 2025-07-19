package com.traductor;

// ... otros imports si los hay

public class JavaToPython {
    // MODIFICA ESTO:
    // public static String translate(String javaCode) { // ANTES
    public static String translate(String javaCode, String className) { // AHORA

        StringBuilder pythonCode = new StringBuilder();

        // --- Código de traducción específico para Python ---
        // Aquí deberías tener tu lógica para traducir Java a Python
        // Usar 'className' para cosas como el nombre del archivo o para adaptar la traducción

        if (className.equals("Adivina")) {
            // Lógica específica para Adivina a Python
            pythonCode.append("# Traducido de Java (Adivina) a Python\n");
            pythonCode.append("import random\n\n");
            pythonCode.append("numero_secreto = random.randint(1, 10)\n\n");
            pythonCode.append("print(\"Adivina el número (entre 1 y 10):\")\n\n");
            pythonCode.append("try:\n");
            pythonCode.append("    intento = int(input(\"Introduce tu intento: \"))\n\n");
            pythonCode.append("    if intento == numero_secreto:\n");
            pythonCode.append("        print(\"¡Correcto! Adivinaste el número.\")\n");
            pythonCode.append("    else:\n");
            pythonCode.append("        print(f\"Incorrecto, el número era: {numero_secreto}\")\n");
            pythonCode.append("except ValueError:\n");
            pythonCode.append("    print(\"Entrada inválida. Por favor, introduce un número.\")\n");
        } else if (className.equals("Suma")) {
            // Lógica para Suma a Python
            pythonCode.append("# Traducido de Java (Suma) a Python\n");
            pythonCode.append("try:\n");
            pythonCode.append("    num1 = int(input(\"Introduce el primer número: \"))\n");
            pythonCode.append("    num2 = int(input(\"Introduce el segundo número: \"))\n\n");
            pythonCode.append("    suma = num1 + num2\n\n");
            pythonCode.append("    print(f\"La suma es: {suma}\")\n");
            pythonCode.append("except ValueError:\n");
            pythonCode.append("    print(\"Entrada inválida. Por favor, introduce números enteros.\")\n");
        } else if (className.equals("Factorial")) {
            // Lógica para Factorial a Python
            pythonCode.append("# Traducido de Java (Factorial) a Python\n");
            pythonCode.append("def factorial(n):\n");
            pythonCode.append("    if n == 0:\n");
            pythonCode.append("        return 1\n");
            pythonCode.append("    else:\n");
            pythonCode.append("        res = 1\n");
            pythonCode.append("        for i in range(1, n + 1):\n");
            pythonCode.append("            res *= i\n");
            pythonCode.append("        return res\n\n");
            pythonCode.append("try:\n");
            pythonCode.append("    numero = int(input(\"Introduce un número para calcular su factorial: \"))\n");
            pythonCode.append("    if numero < 0:\n");
            pythonCode.append("        print(\"El factorial no está definido para números negativos.\")\n");
            pythonCode.append("    else:\n");
            pythonCode.append("        resultado = factorial(numero)\n");
            pythonCode.append("        print(f\"El factorial de {numero} es: {resultado}\")\n");
            pythonCode.append("except ValueError:\n");
            pythonCode.append("    print(\"Entrada inválida. Por favor, introduce un número entero.\")\n");
        } else if (className.equals("Conversor")) {
            // Lógica para Conversor a Python
            pythonCode.append("# Traducido de Java (Conversor) a Python\n");
            pythonCode.append("def celsius_a_fahrenheit(celsius):\n");
            pythonCode.append("    return (celsius * 9/5) + 32\n\n");
            pythonCode.append("def fahrenheit_a_celsius(fahrenheit):\n");
            pythonCode.append("    return (fahrenheit - 32) * 5/9\n\n");
            pythonCode.append("print(\"Conversor de Temperatura\")\n");
            pythonCode.append("print(\"1. Celsius a Fahrenheit\")\n");
            pythonCode.append("print(\"2. Fahrenheit a Celsius\")\n\n");
            pythonCode.append("try:\n");
            pythonCode.append("    opcion = int(input(\"Elige una opción: \"))\n");
            pythonCode.append("    if opcion == 1:\n");
            pythonCode.append("        celsius = float(input(\"Introduce grados Celsius: \"))\n");
            pythonCode.append("        fahrenheit = celsius_a_fahrenheit(celsius)\n");
            pythonCode.append("        print(f\"{celsius}°C son {fahrenheit}°F\")\n");
            pythonCode.append("    elif opcion == 2:\n");
            pythonCode.append("        fahrenheit = float(input(\"Introduce grados Fahrenheit: \"))\n");
            pythonCode.append("        celsius = fahrenheit_a_celsius(fahrenheit)\n");
            pythonCode.append("        print(f\"{fahrenheit}°F son {celsius}°C\")\n");
            pythonCode.append("    else:\n");
            pythonCode.append("        print(\"Opción inválida.\")\n");
            pythonCode.append("except ValueError:\n");
            pythonCode.append("    print(\"Entrada inválida. Por favor, introduce un número.\")\n");
        } else if (className.equals("Tareas")) {
            // Lógica para Tareas a Python
            pythonCode.append("# Traducido de Java (Tareas) a Python\n");
            pythonCode.append("tareas = []\n\n");
            pythonCode.append("def agregar_tarea(tarea):\n");
            pythonCode.append("    tareas.append(tarea)\n");
            pythonCode.append("    print(f\"Tarea '{tarea}' agregada.\")\n\n");
            pythonCode.append("def listar_tareas():\n");
            pythonCode.append("    if not tareas:\n");
            pythonCode.append("        print(\"No hay tareas pendientes.\")\n");
            pythonCode.append("    else:\n");
            pythonCode.append("        print(\"Tareas pendientes:\")\n");
            pythonCode.append("        for i, tarea in enumerate(tareas):\n");
            pythonCode.append("            print(f\"{i + 1}. {tarea}\")\n\n");
            pythonCode.append("def eliminar_tarea(indice):\n");
            pythonCode.append("    if 0 <= indice < len(tareas):\n");
            pythonCode.append("        tarea_eliminada = tareas.pop(indice)\n");
            pythonCode.append("        print(f\"Tarea '{tarea_eliminada}' eliminada.\")\n");
            pythonCode.append("    else:\n");
            pythonCode.append("        print(\"Número de tarea inválido.\")\n\n");
            pythonCode.append("while True:\n");
            pythonCode.append("    print(\"\\n--- Gestor de Tareas ---\")\n");
            pythonCode.append("    print(\"1. Agregar tarea\")\n");
            pythonCode.append("    print(\"2. Listar tareas\")\n");
            pythonCode.append("    print(\"3. Eliminar tarea\")\n");
            pythonCode.append("    print(\"4. Salir\")\n\n");
            pythonCode.append("    try:\n");
            pythonCode.append("        opcion = int(input(\"Elige una opción: \"))\n");
            pythonCode.append("        if opcion == 1:\n");
            pythonCode.append("            tarea = input(\"Introduce la descripción de la tarea: \")\n");
            pythonCode.append("            agregar_tarea(tarea)\n");
            pythonCode.append("        elif opcion == 2:\n");
            pythonCode.append("            listar_tareas()\n");
            pythonCode.append("        elif opcion == 3:\n");
            pythonCode.append("            listar_tareas()\n");
            pythonCode.append("            if tareas:\n");
            pythonCode.append("                indice = int(input(\"Introduce el número de la tarea a eliminar: \")) - 1\n");
            pythonCode.append("                eliminar_tarea(indice)\n");
            pythonCode.append("        elif opcion == 4:\n");
            pythonCode.append("            print(\"¡Hasta luego!\")\n");
            pythonCode.append("            break\n");
            pythonCode.append("        else:\n");
            pythonCode.append("            print(\"Opción inválida. Inténtalo de nuevo.\")\n");
            pythonCode.append("    except ValueError:\n");
            pythonCode.append("        print(\"Entrada inválida. Por favor, introduce un número.\")\n");

        } else {
            pythonCode.append("// Traducción para '" + className + "' no implementada en Python todavía.\n");
            pythonCode.append("// Código Java original:\n");
            pythonCode.append(javaCode);
        }

        return pythonCode.toString();
    }
}
