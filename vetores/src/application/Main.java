package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o valor: ");
        int n = sc.nextInt();

        Double[] vect = new Double[n];

        for (int i = 0;i < n; i++){
            vect[i] = sc.nextDouble();
        }

        double soma = 0.0;
        for (int i = 0;i < n; i++){
           soma += vect[i];
        }

        double media = soma / n;

        System.out.printf("Media de tamanho %.2f%n", + media);

        sc.close();
    }
}
