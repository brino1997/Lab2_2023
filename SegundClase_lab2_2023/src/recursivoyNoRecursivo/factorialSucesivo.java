package recursivoyNoRecursivo;

public class factorialSucesivo {
    //metodo recursivo
    public static int calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;   //caso base
        } else {
            return n * calcularFactorial(n - 1); //caso recursivo
        }
    }
    //metodo sin recursion
    public static int calcularFactorial(int n, int result) {
        int aux = n;
        while(aux>0) { // mientras sea mayor a cero entra al bucle
            result = result * aux;  //multiplico cada numero de aux
            aux--;  //decremento variable aux para ir al proximo numero a multiplicar
        }
        return result;
    }

    public static void main(String[] args) {
        //declaracion de variables
        int numero = 5;
        int result = 1;
        //llamada a los metodos y mostrar por pantalla resultado
        int factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);
        int factorial2 = calcularFactorial(numero, result);
        System.out.println("El factorial de " + numero + " es: " + factorial2);
    }
}
