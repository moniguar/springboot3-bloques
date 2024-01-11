package com.moniguar.boot3.controllers;

import org.springframework.web.bind.annotation.*;

import com.moniguar.boot3.BloquesABC;

@RestController
@RequestMapping("/bloques")
public class PruebaController {


    @GetMapping
    public String getAll() {
        /* Me permite  */
        String resultado="";
        BloquesABC casos = new com.moniguar.boot3.BloquesABC();
        resultado = casos.casosDePrueba();
        return resultado;
    }

    @PostMapping
    public String puedoObtenerPalabra(@RequestBody String test) {

       
        try {
            /* uso la función bloques */
            boolean resultado = BloquesABC.puedoObtenerPalabra(test);

            return "Palabra ingresada " + test +":" +resultado +"\n";

            // Resto del código
        } catch (Exception e) {
            return "Error "+e.getMessage();
        }
    }

}
