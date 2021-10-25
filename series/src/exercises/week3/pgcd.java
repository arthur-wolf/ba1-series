package exercises.week3;

import java.util.Scanner;

public class pgcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c; //Variable de permutation

        do {
            System.out.print("Entrez un nombre positif : ");
            a = scanner.nextInt();
            System.out.print("Entrez un nombre positif : ");
            b = scanner.nextInt();
        } while (!(a > 0) && !(b > 0)); //On vérifie qu'on nous donne que des valeurs de a et b positives

        int start_a = a;
        int start_b = b;

        while (!(a == b)) {
            //Algo Euclide
            if (a > b) {
                a = a - b;
            }
            //On swap pour pouvoir appliquer l'algorithme
            else{
                c=b;
                b=a;
                a=c;
            }
        }
        System.out.print("Le pgcd de " + start_a + " et " + start_b + " est : " + a);
    }
}
