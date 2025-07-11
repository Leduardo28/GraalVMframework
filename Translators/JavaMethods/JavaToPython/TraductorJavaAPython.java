import java.io.*;
import java.util.*;

/**
 * 
 * Corregir clase hasta que genere bien el script a Python
 */

public class TraductorJavaAPython {

    public static String traducirLinea(String linea) {
        linea = linea.trim();

        if (linea.startsWith("System.out.println")) {
            String contenido = linea.substring(linea.indexOf("(") + 1, linea.lastIndexOf(")"));
            return "print(" + contenido + ")";
        } else if (linea.matches("int\\s+\\w+\\s*=.*;")) {
            linea = linea.replace("int", "").replace(";", "").trim();
            return linea;
        } else if (linea.matches("String\\s+\\w+\\s*=.*;")) {
            linea = linea.replace("String", "").replace(";", "").trim();
            return linea;
        } else if (linea.startsWith("for")) {
            // Simplificación extrema para bucles como: for (int i = 0; i < 10; i++)
            return "# for loop (traducción no implementada)";
        } else if (linea.startsWith("if")) {
            String condicion = linea.substring(linea.indexOf("(") + 1, linea.lastIndexOf(")"));
            return "if " + condicion + ":";
        } else if (linea.startsWith("else")) {
            return "else:";
        } else if (linea.contains("{") || linea.contains("}")) {
            return null; // ignoramos llaves
        } else if (linea.isEmpty()) {
            return "";
        }

        return "# No traducido: " + linea;
    }

    public static void traducirArchivo(String archivoEntrada) {
        String archivoSalida = archivoEntrada.replace(".java", ".py");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {

            String linea;
            bw.write("# Código traducido desde Java:\n\n");

            while ((linea = br.readLine()) != null) {
                String traduccion = traducirLinea(linea);
                if (traduccion != null) {
                    bw.write(traduccion + "\n");
                }
            }

            System.out.println("✅ Archivo traducido guardado como: " + archivoSalida);

        } catch (IOException e) {
            System.err.println("❌ Error al leer o escribir archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String archivo = "HolaMundo.java"; // Cambia aquí si deseas usar otro archivo
        traducirArchivo(archivo);
    }
}
