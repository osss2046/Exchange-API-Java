
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1. USD a CLP");
            System.out.println("2. BRL a USD");
            System.out.println("3. EUR a CLP");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            if (option == 4) {
                break;
            }

            System.out.print("Ingrese el valor a convertir: ");
            double amount = scanner.nextDouble();

            try {
                double result = 0;
                switch (option) {
                    case 1:
                        result = ConversorDeMoneda.convert("USD", "CLP", amount);
                        break;
                    case 2:
                        result = ConversorDeMoneda.convert("BRL", "USD", amount);
                        break;
                    case 3:
                        result = ConversorDeMoneda.convert("EUR", "CLP", amount);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        continue;
                }
                System.out.println("El resultado es: " + result);
            } catch (Exception e) {
                System.out.println("Error al convertir: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
