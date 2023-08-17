package recursivoyNoRecursivo;

public class DivisionConResta {
    //metodo recursivo
    public static int divisionSucesiva(int dividendo, int divisor){
        if (dividendo < divisor) {
            return 0; // Caso base: el dividendo es menor que el divisor
        } else {
            return 1 + divisionSucesiva(dividendo - divisor, divisor); //caso recursivo,
        }
    }
    //metodo sin recursividad
    public static int divisionSucesiva(int dividendo, int divisor, int result) {
        while (dividendo>=0){
           dividendo = dividendo - divisor;// realizo las restas hasta que sea menor a cero
           result++;
       }
        result--;
        return result;
    }

    public static void main(String[] args) {
        //declaracion de variables y valores
        int dividendo = 47;
        int divisor = 3;
        int resultado = 0;
        //llamada a los metodos y muestra por pantalla
        int cociente = divisionSucesiva(dividendo, divisor);
        System.out.println("Cociente con recursion: " + cociente);

        int cociente2 = divisionSucesiva(dividendo, divisor, resultado);
        System.out.println("Cociente sin recursion: " + cociente2);
    }
}
