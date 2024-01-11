package com.moniguar.boot3;

import java.util.HashSet;
import java.util.Set;


/********** class BloquesABC
 * Permite validar si las cadenas dadas pertenecen a los bloques
 */
public class BloquesABC {

     // Colección de bloques
     private static final String[] bloques = {
        "BO", "XK", "DQ", "CP", "NA", "GT", "RE", "TG", "QD", "FS",
        "HU", "VI", "AT", "OB", "ER", "FS", "LY", "PC", "ZM", "JW"
    };

    /** Esta función permite saber si se obtiene o no la palabra */
    public static boolean puedoObtenerPalabra(String palabra) {
        
        palabra = palabra.toUpperCase(); // Convertir la palabra a mayúsculas
        Set<Character> bloquesUsados = new HashSet<>();

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            boolean bloqueEncontrado = false;

            // Buscar el bloque que contiene la letra
            for (String bloque : bloques) {
                char lado1 = bloque.charAt(0);
                char lado2 = bloque.charAt(1);

                if (!bloquesUsados.contains(lado1) && (letra == lado1 || letra == lado2)) {
                    bloquesUsados.add(lado1);
                    bloqueEncontrado = true;
                    break;
                } else if (!bloquesUsados.contains(lado2) && (letra == lado2 || letra == lado1)) {
                    bloquesUsados.add(lado2);
                    bloqueEncontrado = true;
                    break;
                }
            }

            if (!bloqueEncontrado) {
                // Si no se encuentra un bloque con la letra, no se puede obtener la palabra
                return false;
            }
        }

        // Si se llega hasta aquí, significa que se pueden usar todos los bloques para formar la palabra
        return true;
    }

    /* Permite enviar varios casos de prueba para testear la función */
    public String casosDePrueba(){


        // Pruebas
        String resultado = "--- CASOS DE PRUEBA ---\n";
        boolean caso;
        
        caso = puedoObtenerPalabra("a");
        resultado += "1. a        : "+String.valueOf(caso) +"\n";

        caso = puedoObtenerPalabra("LIBRO");
        resultado += "2. LIBRO    : "+String.valueOf(caso) +"\n";

        caso = puedoObtenerPalabra("BOZO");
        resultado += "3. BOZO     : "+String.valueOf(caso) +"\n";

        caso = puedoObtenerPalabra("TRAJE");
        resultado += "4. TRAJE    : "+String.valueOf(caso) +"\n";
        //System.out.println(puedoObtenerPalabra("ARLEQUIN"));   // True

        caso = puedoObtenerPalabra("COMUN");
        resultado += "5. COMUN    : "+String.valueOf(caso) +"\n";
        //System.out.println(puedoObtenerPalabra("ARLEQUIN"));   // True

        caso = puedoObtenerPalabra("CAMPANA");
        resultado += "6. CAMPANA  : "+String.valueOf(caso) +"\n";
        //System.out.println(puedoObtenerPalabra("ARLEQUIN"));   // True

        caso = puedoObtenerPalabra("dorito");
        resultado += "7. dorito   : "+String.valueOf(caso) +"\n";

        caso = puedoObtenerPalabra("ArleQUIn");
        resultado += "8. ArleQUIn : "+String.valueOf(caso) +"\n";

        return resultado;
    }

}
