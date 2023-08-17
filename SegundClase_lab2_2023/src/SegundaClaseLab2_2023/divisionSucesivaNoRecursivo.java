package SegundaClaseLab2_2023;

public class divisionSucesivaNoRecursivo {
    public static void main(String[] args) {
        int dividendo = 25;
        int divisor = 8;

        int cociente = divisionSucesiva(dividendo, divisor);
        System.out.println("Cociente: " + cociente);
    }
    public static int divisionSucesiva(int dividendo, int divisor) {
        int aux = dividendo;
        int result=0;
        while (aux>=0){
            result++;
            aux= aux - divisor;
        }
            result--;

        return result;
    }
}