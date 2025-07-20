package com.traductor;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Translator {

    // Método principal para traducir código Java a un lenguaje de destino
    // Ahora incluye 'className' para una traducción más específica
    public static String translate(String code, String language, String className) {
        String translatedCode = "// Traducción no soportada o error\n";
        String fileExtension = "";

        switch (language.toLowerCase()) {
            case "python":
                translatedCode = JavaToPython.translate(code, className);
                fileExtension = ".py";
                break;
            case "javascript": // Mantiene "javascript"
            case "js":         // ¡AGREGADO ESTE CASO para aceptar "js"!
                translatedCode = JavaToJS.translate(code, className);
                fileExtension = ".js";
                break;
            case "c":
                translatedCode = JavaToC.translate(code, className);
                fileExtension = ".c";
                break;
            default:
                translatedCode = "// Lenguaje de destino no soportado: " + language + "\n" + code;
                break;
        }

        // Si la traducción fue exitosa y se definió una extensión
        if (!fileExtension.isEmpty() && !"// Traducción no soportada o error\n".equals(translatedCode)) {
            // Define la ruta donde se guardarán los archivos traducidos
            Path outputPath = Paths.get("target", "classes", "com", "traductor");

            try {
                // Crear el directorio si no existe
                Files.createDirectories(outputPath);

                // Construir el nombre del archivo. Usamos className para el nombre del archivo.
                String fileName = (className != null && !className.isEmpty()) ? className : "translated_output";
                Path filePath = outputPath.resolve(fileName + fileExtension);

                // Escribir el código traducido en el archivo
                try (FileWriter writer = new FileWriter(filePath.toFile())) {
                    writer.write(translatedCode);
                    System.out.println("Archivo traducido guardado en: " + filePath.toAbsolutePath());
                }
            } catch (IOException e) {
                System.err.println("Error al guardar el archivo traducido: " + e.getMessage());
            }
        }

        return translatedCode;
    }
}