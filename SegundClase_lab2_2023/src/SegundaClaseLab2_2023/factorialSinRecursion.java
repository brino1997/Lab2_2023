package SegundaClaseLab2_2023;

public class factorialSinRecursion {
    public static int calcularFactorial(int n) {
        int result = 1;
        int aux = n;
        while(aux>0){
            result = result * aux;
            aux--;
        }
        return result;
    }

    public static void main(String[] args) {
        int numero = 0;
        int factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}
