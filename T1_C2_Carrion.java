import java.util.Locale;
import java.util.Scanner;

public class T1_C2_Carrion {

    // pido una nota y la repito mientras no este entre 0 y 20
    static double leerNota(Scanner sc, String nombre) {
        double nota;
        do {
            System.out.print("Ingrese " + nombre + " (0-20): ");
            nota = sc.nextDouble();
            if (nota < 0 || nota > 20) {
                System.out.println("La nota debe estar entre 0 y 20");
            }
        } while (nota < 0 || nota > 20);
        return nota;
    }

    // suma las tres notas y las divide para 3
    static double promedio(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    // dice si aprobo, va a supletorio o reprobo segun la nota
    static String estado(double nota) {
        if (nota >= 14) {
            return "Aprobado";
        } else if (nota >= 9) {
            return "Supletorio";
        } else {
            return "Reprobado";
        }
    }

    // para aprobar el promedio entre la nota y el supletorio tiene que ser 14,
    // entonces el supletorio debe sumar 28 con la nota (14 x 2) y por eso hago 28 - nota
    static double necesitaEnSupletorio(double nota) {
        if (nota >= 9 && nota < 14) {
            return 28 - nota;
        }
        // si no le toca supletorio devuelvo -1
        return -1;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double n1 = leerNota(sc, "la nota 1");
        double n2 = leerNota(sc, "la nota 2");
        double n3 = leerNota(sc, "la nota 3");

        double prom = promedio(n1, n2, n3);
        System.out.printf("Promedio: %.2f%n", prom);
        System.out.println("Estado: " + estado(prom));

        // solo muestro la nota del supletorio si le toca supletorio
        double minimo = necesitaEnSupletorio(prom);
        if (minimo != -1) {
            System.out.printf("Nota minima en el supletorio para aprobar: %.2f%n", minimo);
        }
        sc.close();
    }
}