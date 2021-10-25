package exercises.week5;

import java.util.Scanner;

public class Fibonacci {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez le numéro du terme de la fibosuite que vous voulez calculer : ");
        int n = scanner.nextInt();
        // System.out.println("F(" + n + ") = "+ fibor(n));
        for(int i=0; i < 10; i++){
            System.out.println(fibor(i));
        }
    }

    static int fibor(int n){
        switch(n){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return (fibor(n-1) + fibor(n-2));
        }
    }
}
