import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!, aburriendome en una clase de java");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese primer valor: ");
        Integer num1 = scanner.nextInt();
        System.out.print("Por favor, ingrese segundo valor: ");
        Integer num2 = scanner.nextInt();
        System.out.print("Por favor, ingrese tercer valor: ");
        Integer num3 = scanner.nextInt();
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2 > num3) {
            int temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        System.out.println("Números ordenados: " + num1 + ", " + num2 + ", " + num3);



    }
}