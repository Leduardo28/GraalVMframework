package com.residencia.project;

import java.io.InputStreamReader;
import java.io.Reader;

import org.graalvm.polyglot.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traductor.PythonResourses;

@RestController
public class PythonController {

    @GetMapping("/run-python")
    public String runPython() {
        try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
            Value result = context.eval("python", "x = 5 + 3\nx");
            return "Resultado desde Python: " + result.toString();
        }
    }

    @GetMapping("/run-python-script")
    public String runPythonScript(String name) {
        try (Context context = Context.newBuilder()
                                    .allowAllAccess(true)
                                    .allowNativeAccess(true)
                                    .allowPolyglotAccess(PolyglotAccess.ALL)
                                    .allowHostAccess(HostAccess.ALL)
                                    .allowIO(true)
                                    .build()) {
            // Lee y ejecuta el script en python, en este caso es "hello.py"
            Reader stream = new InputStreamReader(PythonController.class.getResourceAsStream("../../pyscripts/hello.py"));
            Source source = Source.newBuilder("python", stream, "../../pyscripts/hello.py").build();
            context.eval(source);

            // Llama a la función definida en el script "message"
            Value function = context.getPolyglotBindings().getMember("message");

            //Ejecuta la funcion "message" pasandole el parametro "name"
            Value result = function.execute(name);
            return result.asString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}