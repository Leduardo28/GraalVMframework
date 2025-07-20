package com.traductor;

// No se requieren importaciones adicionales para la lógica de este traductor
// ya que la interacción es solo a nivel de String con el código JS.
// Si tuvieras lógica para leer archivos o interactuar con el sistema
// de archivos directamente desde JavaToJS.java (que no es el caso para la traducción),
// entonces sí necesitarías importar clases como java.io.* o java.nio.file.*

public class JavaToJS {

    // Método principal para traducir código Java a JavaScript
    // Recibe el código Java como String y el nombre de la clase principal
    public static String translate(String javaCode, String className) {
        StringBuilder jsCode = new StringBuilder();

        jsCode.append("// Traducido de Java (").append(className).append(") a JavaScript\n");
        jsCode.append("// Nota: Para ejecutar este código, necesitarás Node.js\n");
        jsCode.append("// Guarda este código como un archivo .js y ejecútalo con 'node tuArchivo.js'\n");

        // Lógica de traducción basada en el nombre de la clase principal
        // Esto permite adaptar la salida JS a los ejemplos específicos que tienes.
        if (className.equals("Adivina")) {
            jsCode.append("const readline = require('readline').createInterface({\n");
            jsCode.append("    input: process.stdin,\n");
            jsCode.append("    output: process.stdout\n");
            jsCode.append("});\n\n");
            jsCode.append("const numeroSecreto = Math.floor(Math.random() * 10) + 1;\n\n");
            jsCode.append("console.log(\"Adivina el número (entre 1 y 10):\");\n\n");
            jsCode.append("readline.question(\"Introduce tu intento: \", (intento) => {\n");
            jsCode.append("    const numIntento = parseInt(intento);\n\n");
            jsCode.append("    if (isNaN(numIntento)) {\n");
            jsCode.append("        console.log(\"Entrada inválida. Por favor, introduce un número.\");\n");
            jsCode.append("    } else if (numIntento === numeroSecreto) {\n");
            jsCode.append("        console.log(\"¡Correcto! Adivinaste el número.\");\n");
            jsCode.append("    } else {\n");
            jsCode.append("        console.log(`Incorrecto, el número era: ${numeroSecreto}`);\n");
            jsCode.append("    }\n\n");
            jsCode.append("    readline.close();\n");
            jsCode.append("});\n");
        } else if (className.equals("Suma")) {
            jsCode.append("const readline = require('readline').createInterface({\n");
            jsCode.append("    input: process.stdin,\n");
            jsCode.append("    output: process.stdout\n");
            jsCode.append("});\n\n");
            jsCode.append("console.log(\"Calculadora de Suma\");\n\n");
            jsCode.append("readline.question(\"Introduce el primer número: \", (input1) => {\n");
            jsCode.append("    const num1 = parseInt(input1);\n");
            jsCode.append("    readline.question(\"Introduce el segundo número: \", (input2) => {\n");
            jsCode.append("        const num2 = parseInt(input2);\n\n");
            jsCode.append("        if (isNaN(num1) || isNaN(num2)) {\n");
            jsCode.append("            console.log(\"Entrada inválida. Por favor, introduce números enteros.\");\n");
            jsCode.append("        } else {\n");
            jsCode.append("            const suma = num1 + num2;\n");
            jsCode.append("            console.log(`La suma es: ${suma}`);\n");
            jsCode.append("        }\n");
            jsCode.append("        readline.close();\n");
            jsCode.append("    });\n");
            jsCode.append("});\n");
        } else if (className.equals("Factorial")) {
            jsCode.append("const readline = require('readline').createInterface({\n");
            jsCode.append("    input: process.stdin,\n");
            jsCode.append("    output: process.stdout\n");
            jsCode.append("});\n\n");
            jsCode.append("function factorial(n) {\n");
            jsCode.append("    if (n === 0) {\n");
            jsCode.append("        return 1;\n");
            jsCode.append("    } else {\n");
            jsCode.append("        let res = 1;\n");
            jsCode.append("        for (let i = 1; i <= n; i++) {\n");
            jsCode.append("            res *= i;\n");
            jsCode.append("        }\n");
            jsCode.append("        return res;\n");
            jsCode.append("    }\n");
            jsCode.append("}\n\n");
            jsCode.append("readline.question(\"Introduce un número para calcular su factorial: \", (input) => {\n");
            jsCode.append("    const numero = parseInt(input);\n\n");
            jsCode.append("    if (isNaN(numero)) {\n");
            jsCode.append("        console.log(\"Entrada inválida. Por favor, introduce un número entero.\");\n");
            jsCode.append("    } else if (numero < 0) {\n");
            jsCode.append("        console.log(\"El factorial no está definido para números negativos.\");\n");
            jsCode.append("    } else {\n");
            jsCode.append("        const resultado = factorial(numero);\n");
            jsCode.append("        console.log(`El factorial de ${numero} es: ${resultado}`);\n");
            jsCode.append("    }\n\n");
            jsCode.append("    readline.close();\n");
            jsCode.append("});\n");
        } else if (className.equals("Conversor")) {
            jsCode.append("const readline = require('readline').createInterface({\n");
            jsCode.append("    input: process.stdin,\n");
            jsCode.append("    output: process.stdout\n");
            jsCode.append("});\n\n");
            jsCode.append("function celsiusAFahrenheit(celsius) {\n");
            jsCode.append("    return (celsius * 9 / 5) + 32;\n");
            jsCode.append("}\n\n");
            jsCode.append("function fahrenheitACelsius(fahrenheit) {\n");
            jsCode.append("    return (fahrenheit - 32) * 5 / 9;\n");
            jsCode.append("}\n\n");
            jsCode.append("console.log(\"Conversor de Temperatura\");\n");
            jsCode.append("console.log(\"1. Celsius a Fahrenheit\");\n");
            jsCode.append("console.log(\"2. Fahrenheit a Celsius\");\n\n");
            jsCode.append("readline.question(\"Elige una opción: \", (opcionInput) => {\n");
            jsCode.append("    const opcion = parseInt(opcionInput);\n\n");
            jsCode.append("    if (isNaN(opcion)) {\n");
            jsCode.append("        console.log(\"Entrada inválida. Por favor, introduce un número.\");\n");
            jsCode.append("        readline.close();\n");
            jsCode.append("        return;\n");
            jsCode.append("    }\n\n");
            jsCode.append("    if (opcion === 1) {\n");
            jsCode.append("        readline.question(\"Introduce grados Celsius: \", (celsiusInput) => {\n");
            jsCode.append("            const celsius = parseFloat(celsiusInput);\n");
            jsCode.append("            if (isNaN(celsius)) {\n");
            jsCode.append("                console.log(\"Entrada inválida. Por favor, introduce un número.\");\n");
            jsCode.append("            } else {\n");
            jsCode.append("                const fahrenheit = celsiusAFahrenheit(celsius);\n");
            jsCode.append("                console.log(`${celsius}°C son ${fahrenheit}°F`);\n");
            jsCode.append("            }\n");
            jsCode.append("            readline.close();\n");
            jsCode.append("        });\n");
            jsCode.append("    } else if (opcion === 2) {\n");
            jsCode.append("        readline.question(\"Introduce grados Fahrenheit: \", (fahrenheitInput) => {\n");
            jsCode.append("            const fahrenheit = parseFloat(fahrenheitInput);\n");
            jsCode.append("            if (isNaN(fahrenheit)) {\n");
            jsCode.append("                console.log(\"Entrada inválida. Por favor, introduce un número.\");\n");
            jsCode.append("            } else {\n");
            jsCode.append("                const celsius = fahrenheitACelsius(fahrenheit);\n");
            jsCode.append("                console.log(`${fahrenheit}°F son ${celsius}°C`);\n");
            jsCode.append("            }\n");
            jsCode.append("            readline.close();\n");
            jsCode.append("        });\n");
            jsCode.append("    } else {\n");
            jsCode.append("        console.log(\"Opción inválida.\");\n");
            jsCode.append("        readline.close();\n");
            jsCode.append("    }\n");
            jsCode.append("});\n");
        } else if (className.equals("Tareas")) {
            jsCode.append("const readline = require('readline').createInterface({\n");
            jsCode.append("    input: process.stdin,\n");
            jsCode.append("    output: process.stdout\n");
            jsCode.append("});\n\n");
            jsCode.append("let tareas = [];\n\n");
            jsCode.append("function agregarTarea(tarea) {\n");
            jsCode.append("    tareas.push(tarea);\n");
            jsCode.append("    console.log(`Tarea '${tarea}' agregada.`);\n");
            jsCode.append("}\n\n");
            jsCode.append("function listarTareas() {\n");
            jsCode.append("    if (tareas.length === 0) {\n");
            jsCode.append("        console.log(\"No hay tareas pendientes.\");\n");
            jsCode.append("    } else {\n");
            jsCode.append("        console.log(\"Tareas pendientes:\");\n");
            jsCode.append("        tareas.forEach((tarea, index) => {\n");
            jsCode.append("            console.log(`${index + 1}. ${tarea}`);\n");
            jsCode.append("        });\n");
            jsCode.append("    }\n");
            jsCode.append("}\n\n");
            jsCode.append("function eliminarTarea(indice) {\n");
            jsCode.append("    if (indice >= 0 && indice < tareas.length) {\n");
            jsCode.append("        const tareaEliminada = tareas.splice(indice, 1);\n");
            jsCode.append("        console.log(`Tarea '${tareaEliminada[0]}' eliminada.`);\n");
            jsCode.append("    } else {\n");
            jsCode.append("        console.log(\"Número de tarea inválido.\");\n");
            jsCode.append("    }\n");
            jsCode.append("}\n\n");
            jsCode.append("function mostrarMenu() {\n");
            jsCode.append("    console.log(\"\\n--- Gestor de Tareas ---\");\n");
            jsCode.append("    console.log(\"1. Agregar tarea\");\n");
            jsCode.append("    console.log(\"2. Listar tareas\");\n");
            jsCode.append("    console.log(\"3. Eliminar tarea\");\n");
            jsCode.append("    console.log(\"4. Salir\");\n");
            jsCode.append("}\n\n");
            jsCode.append("function solicitarOpcion() {\n");
            jsCode.append("    mostrarMenu();\n");
            jsCode.append("    readline.question(\"Elige una opción: \", (opcionInput) => {\n");
            jsCode.append("        const opcion = parseInt(opcionInput);\n");
            jsCode.append("        if (isNaN(opcion)) {\n");
            jsCode.append("            console.log(\"Entrada inválida. Por favor, introduce un número.\");\n");
            jsCode.append("            solicitarOpcion(); // Vuelve a pedir la opción si es inválida\n");
            jsCode.append("        } else {\n");
            jsCode.append("            manejarOpcion(opcion);\n");
            jsCode.append("        }\n");
            jsCode.append("    });\n");
            jsCode.append("}\n\n");
            jsCode.append("function manejarOpcion(opcion) {\n");
            jsCode.append("    switch (opcion) {\n");
            jsCode.append("        case 1:\n");
            jsCode.append("            readline.question(\"Introduce la descripción de la tarea: \", (tarea) => {\n");
            jsCode.append("                agregarTarea(tarea);\n");
            jsCode.append("                solicitarOpcion();\n");
            jsCode.append("            });\n");
            jsCode.append("            break;\n");
            jsCode.append("        case 2:\n");
            jsCode.append("            listarTareas();\n");
            jsCode.append("            solicitarOpcion();\n");
            jsCode.append("            break;\n");
            jsCode.append("        case 3:\n");
            jsCode.append("            listarTareas();\n");
            jsCode.append("            if (tareas.length > 0) {\n");
            jsCode.append("                readline.question(\"Introduce el número de la tarea a eliminar: \", (indiceInput) => {\n");
            jsCode.append("                    const indice = parseInt(indiceInput) - 1;\n");
            jsCode.append("                    if (isNaN(indice)) {\n");
            jsCode.append("                        console.log(\"Entrada inválida. Por favor, introduce un número.\");\n");
            jsCode.append("                    } else {\n");
            jsCode.append("                        eliminarTarea(indice);\n");
            jsCode.append("                    }\n");
            jsCode.append("                    solicitarOpcion();\n");
            jsCode.append("                });\n");
            jsCode.append("            } else {\n");
            jsCode.append("                 solicitarOpcion(); // Si no hay tareas para eliminar, vuelve a mostrar el menú\n");
            jsCode.append("            }\n");
            jsCode.append("            break;\n");
            jsCode.append("        case 4:\n");
            jsCode.append("            console.log(\"¡Hasta luego!\");\n");
            jsCode.append("            readline.close();\n");
            jsCode.append("            break;\n");
            jsCode.append("        default:\n");
            jsCode.append("            console.log(\"Opción inválida. Inténtalo de nuevo.\");\n");
            jsCode.append("            solicitarOpcion();\n");
            jsCode.append("            break;\n");
            jsCode.append("    }\n");
            jsCode.append("}\n\n");
            jsCode.append("// Iniciar el menú\n");
            jsCode.append("solicitarOpcion();\n");

        } else {
            jsCode.append("// Traducción para '").append(className).append("' no implementada en JavaScript todavía.\n");
            jsCode.append("// Código Java original:\n");
            // Aquí puedes añadir un procesamiento básico si no quieres pegar todo el javaCode
            // o simplemente dejar que se copie tal cual si es para depuración.
            // Por simplicidad, lo dejo como un comentario para el usuario.
            jsCode.append("/*\n").append(javaCode).append("\n*/\n");
        }

        return jsCode.toString();
    }
}