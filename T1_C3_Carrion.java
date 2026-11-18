import java.util.Locale;
import java.util.Scanner;

public class T1_C3_Carrion {

    // los tres metodos se llaman igual (volumen) pero cada uno recibe distintos datos

    // cubo: solo necesita el lado
    static double volumen(double lado) {
        return lado * lado * lado;
    }

    // cilindro: recibe radio y altura
    static double volumen(double radio, double altura) {
        return Math.PI * radio * radio * altura;
    }

    // prisma rectangular: recibe largo, ancho y alto
    static double volumen(double largo, double ancho, double alto) {
        return largo * ancho * alto;
    }

    // pido un numero y lo repito si es 0 o negativo
    static double leerPositivo(Scanner sc, String nombre) {
        double valor;
        do {
            System.out.print("Ingrese " + nombre + ": ");
            valor = sc.nextDouble();
            if (valor <= 0) {
                System.out.println("Debe ser mayor que 0");
            }
        } while (valor <= 0);
        return valor;
    }

    // solo imprime las opciones del menu
    static void mostrarMenu() {
        System.out.println();
        System.out.println("===== VOLUMENES =====");
        System.out.println("1. Cubo");
        System.out.println("2. Cilindro");
        System.out.println("3. Prisma rectangular");
        System.out.println("4. Salir");
        System.out.print("Elija una opcion: ");
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int opcion;

        // el menu se repite hasta que elijan la opcion 4
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    double lado = leerPositivo(sc, "el lado");
                    System.out.printf("Volumen del cubo: %.2f%n", volumen(lado));
                    break;
                case 2:
                    double radio = leerPositivo(sc, "el radio");
                    double altura = leerPositivo(sc, "la altura");
                    System.out.printf("Volumen del cilindro: %.2f%n", volumen(radio, altura));
                    break;
                case 3:
                    double largo = leerPositivo(sc, "el largo");
                    double ancho = leerPositivo(sc, "el ancho");
                    double alto = leerPositivo(sc, "el alto");
                    System.out.printf("Volumen del prisma: %.2f%n", volumen(largo, ancho, alto));
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 4);

        sc.close();
    }
}