package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        method1();

        System.out.println("Fim do programa");
    }

    public static void method1() {
        System.out.println("**** METHOD1 START ****");
        method2();
        System.out.println("**** METHOD1 END ****");
    }

    public static void method2() {

        Scanner sc = new Scanner(System.in);

        //O try é o código que você quer rodar e o catch é o tipo do erro com a mensagem para mostrar.

        try {
            System.out.println("**** METHOD2 START ****");
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Posição invalida");
        }
        catch (InputMismatchException e){
            System.out.println("Você digitou uma letra ao invés do número");
        }

        sc.close();
        System.out.println("**** METHOD2 END ****");

    }
}
