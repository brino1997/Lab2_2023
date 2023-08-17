package SegundaClaseLab2_2023;

public class factorialRecursivo {
    public static int calcularFactorial(int n, int result) {

        int aux = n;
        while(aux>0){
            result = result * aux;
            aux--;
        }
        return result;
    }

    public static int calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        int result = 1;
        int factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " con recursion es: " + factorial);
        int factorial2 = calcularFactorial(numero, result);
        System.out.println("El factorial de " + numero + " sin recursion es: " + factorial2);
    }
}
