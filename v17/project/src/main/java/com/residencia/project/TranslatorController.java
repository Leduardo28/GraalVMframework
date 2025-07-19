package com.residencia.project;

import com.traductor.Translator; // Asegúrate de que esta importación esté presente
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {

    // Clase interna para mapear la solicitud JSON entrante
    static class TranslationRequest {
        private String code;
        private String language;
        private String className; // <-- Nuevo campo para el nombre de la clase

        // Getters y Setters (Necesarios para que Spring pueda mapear el JSON)
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getClassName() { // <-- Getter para className
            return className;
        }

        public void setClassName(String className) { // <-- Setter para className
            this.className = className;
        }
    }

    @PostMapping("/translate")
    public ResponseEntity<String> translateCode(@RequestBody TranslationRequest request) {
        // Llama al método de traducción, pasando el código, el lenguaje y el nombre de la clase
        String translatedCode = Translator.translate(request.getCode(), request.getLanguage(), request.getClassName());

        // Devuelve la respuesta HTTP con el código traducido
        return ResponseEntity.ok(translatedCode);
    }
}