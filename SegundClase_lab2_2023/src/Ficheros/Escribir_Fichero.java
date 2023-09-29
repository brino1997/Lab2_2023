package Ficheros;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {public static void main(String[] args) {


    Escribiendo x = new Escribiendo();
    x.escribir();

}
}

class Escribiendo {

    public void escribir() {

        String frase = "Texto prueba";

        try {
            FileWriter escritura = new FileWriter("Nuevo.txt");

            for(int i = 0; i < frase.length(); i++) {

                escritura.write(frase.charAt(i));

            }

            escritura.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

