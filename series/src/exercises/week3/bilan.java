package exercises.week3;

import java.util.Scanner;

public class bilan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sur combien de mois le bilan doit-il être fait ? n = ");
        int n = scanner.nextInt();
        int lowest=0;
        int highest=0;
        int total=0;
        int a;
        boolean init=false;

        for(int i = 1; i <= n; ++i){

            System.out.print("Montant du mois "+i+" : ");
            a = scanner.nextInt();

            if(!init){
                lowest=a;
                init = true;
            }

            if(a>highest){
                highest=a;
            }

            if(a<lowest){
                lowest=a;
            }

            total += a;
        }

        System.out.println("La somme mensuelle moyenne reçue est de "+total/n+" francs");
        System.out.println("Le montant mensuel minimal reçu a été de "+lowest+" francs");
        System.out.println("Le montant mensuel maximal reçu a été de "+highest+" francs");
    }
}
