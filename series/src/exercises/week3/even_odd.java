package exercises.week3;

import java.util.Scanner;

public class even_odd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre entier : ");
        int n = scanner.nextInt();

        if (n==0){
            System.out.println("Le nombre est zéro (et il est pair)");
        }
        else if(n>0){
            if(n%2==0){
                System.out.println("Le nombre est pair et positif");
            }
            else{
                System.out.println("Le nombre est impair et positif");
            }
        }
        else{
            if(n%2==0){
                System.out.println("Le nombre est pair et négatif");
            }
            else{
                System.out.println("Le nombre est impair et négatif");
            }
        }
    }
}
