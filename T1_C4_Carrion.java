import java.util.Scanner;

public class T1_C4_Carrion {

    // voy quitando el ultimo digito dividiendo para 10 y cuento cuantas veces lo hago
    static int contarDigitos(int n) {
        int cuenta = 0;
        if (n == 0) {
            return 1;
        }
        while (n > 0) {
            n = n / 10;
            cuenta++;
        }
        return cuenta;
    }

    // como no se puede usar Math.pow, multiplico la base por si misma las veces que diga el exponente
    static int potencia(int b, int e) {
        int resultado = 1;
        for (int i = 0; i < e; i++) {
            resultado = resultado * b;
        }
        return resultado;
    }

    // saco cada digito del numero, lo elevo a la cantidad de digitos y lo voy sumando
    // si al final la suma da el mismo numero, entonces es Armstrong
    static boolean esArmstrong(int n) {
        int digitos = contarDigitos(n);
        int suma = 0;
        int temp = n;
        while (temp > 0) {
            // con el residuo para 10 saco el ultimo digito
            int d = temp % 10;
            suma = suma + potencia(d, digitos);
            temp = temp / 10;
        }
        return suma == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un entero positivo: ");
        int n = sc.nextInt();
        if (esArmstrong(n)) {
            System.out.println(n + " es un numero de Armstrong");
        } else {
            System.out.println(n + " NO es un numero de Armstrong");
        }
        sc.close();
    }
}