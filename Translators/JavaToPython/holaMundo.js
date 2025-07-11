#!/bin/bash

# Archivo de entrada .java
input_file="$1"

# Verificar si el archivo fue especificado
if [ -z "$input_file" ]; then
  echo "Uso: ./javatojs.sh archivo.java"
  exit 1
fi

# Archivo de salida .js
output_file="${input_file%.java}.js"

# Convertir el contenido línea por línea
sed -e 's/System\.out\.println/console.log/g' \
    -e 's/public class /\/\/ class /g' \
    -e 's/public static void main(String\[\] args)//g' \
    -e 's/String /let /g' \
    -e 's/int /let /g' \
    -e 's/double /let /g' \
    -e 's/boolean /let /g' \
    -e 's/;$/;/g' \
    -e 's/{/ {/g' \
    "$input_file" > "$output_file"

echo "Archivo traducido: $output_file"
