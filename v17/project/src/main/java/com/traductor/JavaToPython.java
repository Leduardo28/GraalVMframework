package com.traductor;

// ... otros imports si los hay

public class JavaToPython {
    // MODIFICA ESTO:
    // public static String translate(String javaCode) { // ANTES
    public static String translate(String javaCode) { // AHORA
        StringBuilder py = new StringBuilder();
        String[] lineas = javaCode.split("\\R");
        int indent = 0;

        for (String linea : lineas) {
            String l = linea.trim();

            // Comentario
            if (l.startsWith("//")) {
                py.append("    ".repeat(indent)).append("# ").append(l.substring(2)).append("\n");
                continue;
            }

            // Clase
            if (l.matches("public class \\w+")) {
                String className = l.split(" ")[2];
                py.append("class ").append(className).append(":\n");
                indent++;
                continue;
            }

            // Método main
            if (l.contains("public static void main")) {
                py.append("    ".repeat(indent)).append("def main():\n");
                indent++;
                continue;
            }

            // System.out.println / print
            if (l.contains("System.out.println")) {
                String inner = l.substring(l.indexOf("(") + 1, l.lastIndexOf(")")).replace(";", "");
                py.append("    ".repeat(indent)).append("print(").append(inner).append(")\n");
                continue;
            }

            // System.out.print (sin salto)
            if (l.contains("System.out.print")) {
                String inner = l.substring(l.indexOf("(") + 1, l.lastIndexOf(")")).replace(";", "");
                py.append("    ".repeat(indent)).append("print(").append(inner).append(", end='')\n");
                continue;
            }

            // Scanner (omitimos declaración)
            if (l.contains("Scanner") && l.contains("=")) continue;

            // Entrada con scanner.next*
            if (l.contains("scanner.next")) {
                String nombre = l.split("=")[0].replaceAll("(int|double|String)", "").trim();
                String tipo = l.contains("nextInt") ? "int" : (l.contains("nextDouble") ? "float" : "str");
                py.append("    ".repeat(indent)).append(nombre)
                   .append(" = ").append(tipo).append("(input())\n");
                continue;
            }

            // if
            if (l.startsWith("if")) {
                String cond = l.replace("if", "").replace("(", "").replace(")", "").replace("{", "").trim();
                py.append("    ".repeat(indent)).append("if ").append(cond).append(":\n");
                indent++;
                continue;
            }

            // else
            if (l.startsWith("else")) {
                py.append("    ".repeat(indent - 1)).append("else:\n");
                indent++;
                continue;
            }

            // while
            if (l.startsWith("while")) {
                String cond = l.replace("while", "").replace("(", "").replace(")", "").replace("{", "").trim();
                py.append("    ".repeat(indent)).append("while ").append(cond).append(":\n");
                indent++;
                continue;
            }

            // for (no traducido aún)
            if (l.startsWith("for")) {
                py.append("    ".repeat(indent)).append("# ").append(l).append("  # for loop no traducido\n");
                continue;
            }

            // return
            if (l.startsWith("return")) {
                py.append("    ".repeat(indent)).append(l).append("\n");
                continue;
            }

            // cierre de bloque
            if (l.equals("}")) {
                indent = Math.max(0, indent - 1);
                continue;
            }

            // declaración con tipo
            if (l.matches("(int|double|String)\\s+\\w+\\s*=.*;")) {
                String clean = l.replaceAll("(int|double|String)\\s+", "").replace(";", "");
                py.append("    ".repeat(indent)).append(clean).append("\n");
                continue;
            }

            // declaración simple (e.g. String[] tareas = ...)
            if (l.matches("(String|int|double)\\[\\]\\s+\\w+\\s*=.*;")) {
                String clean = l.replaceAll("(String|int|double)\\[\\]\\s+", "").replace(";", "");
                py.append("    ".repeat(indent)).append(clean).append("\n");
                continue;
            }

            // cualquier otra línea
            if (!l.isEmpty()) {
                py.append("    ".repeat(indent)).append("# ").append(l).append("\n");
            }
        }

        return py.toString();
    }
}
