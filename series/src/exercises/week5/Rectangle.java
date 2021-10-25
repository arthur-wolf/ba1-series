package exercises.week5;

import java.util.Scanner;

public class Rectangle {
    final private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double largeur = lireDonnee("largeur");
        double hauteur = lireDonnee("hauteur");

        boolean donneesOk = testerDonnees(largeur, hauteur);

        if(donneesOk){
            calculer(largeur, hauteur);
        } else {
            afficherErreur();
        }
    }

    static void calculer(double l, double h){
        System.out.print("Surface ('s'/'S') ou périmètre ('p'/'P') : ");
        char c = scanner.next().charAt(0);
        switch(c){
            case 'p':
            case 'P':
                System.out.println("Le périmètre du rectangle est : " + 2*h+2*l);
                break;
            case 's':
            case 'S':
                System.out.println("La surface du rectangle est : " + h*l);
                break;
        }

    }

    static double lireDonnee(String s){
        System.out.print("veuillez entrer la " + s + " du rectangle :");
        return scanner.nextDouble();
    }

    static  boolean testerDonnees(double l, double h){
        if (l<0 || h<0){
            return false;
        }else{
            return true;
        }
    }

    static void afficherErreur(){
        System.out.println("Erreur : vous avez introduit une largeur/hauteur négative !");
    }
}
