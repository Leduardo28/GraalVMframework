package com.residencia.project;

import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatorController {

    @GetMapping("/translate")
    public String translate(
        @RequestParam String code,   // Código fuente que se desea traducir
        @RequestParam String type,   // Tipo de traducción: "direct" o "polyglot"
        @RequestParam String lp      // Lenguaje de destino: "js", "python", "c"
    ) {
        // Imprimir en consola los datos recibidos
        System.out.println("=== Petición de Traducción ===");
        System.out.println("Código fuente: " + code);
        System.out.println("Tipo de traducción: " + type);
        System.out.println("Lenguaje de destino: " + lp);
        System.out.println("==============================");

        // Aquí irá la lógica de traducción (por ahora, solo simulamos una respuesta)
        return "Traducción de tipo " + type + " a " + lp + ":\n\n" + code;
    }
}
