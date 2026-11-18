import java.util.Locale;
import java.util.Scanner;

public class T1_C1_Carrion {

    // pido el consumo y si ponen un numero negativo lo vuelvo a pedir
    static double leerConsumo(Scanner sc) {
        double m3;
        do {
            System.out.print("Ingrese el consumo en m3: ");
            m3 = sc.nextDouble();
            if (m3 < 0) {
                System.out.println("El consumo no puede ser negativo");
            }
        } while (m3 < 0);
        return m3;
    }

    // calculo cuanto se paga: empiezo con el cargo fijo de 2.50
    static double calcularValor(double m3) {
        double valor = 2.50;
        if (m3 <= 15) {
            // si no pasa de 15 m3 todo se cobra a 0.40
            valor = valor + m3 * 0.40;
        } else {
            // si pasa de 15, los primeros 15 a 0.40 y lo que sobra a 0.75
            valor = valor + 15 * 0.40 + (m3 - 15) * 0.75;
        }
        return valor;
    }

    // solo muestra la planilla en pantalla, no devuelve nada
    static void mostrarPlanilla(double m3, double valor) {
        System.out.println("===== PLANILLA DE AGUA =====");
        System.out.printf("Consumo: %.2f m3%n", m3);
        System.out.printf("Cargo fijo: $%.2f%n", 2.50);
        System.out.printf("Total a pagar: $%.2f%n", valor);
        System.out.println("============================");
    }

    public static void main(String[] args) {
        // esto es para que los decimales salgan con punto y no con coma
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double m3 = leerConsumo(sc);
        double valor = calcularValor(m3);
        mostrarPlanilla(m3, valor);
        sc.close();
    }
}