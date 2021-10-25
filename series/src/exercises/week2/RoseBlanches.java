package exercises.week2;

import java.util.Scanner;

public class RoseBlanches {
    public static void main(String[] args){
        Scanner karine = new Scanner(System.in);
            System.out.print("Combien avez-vous reçu d'argent ? ");
            int x = karine.nextInt();
            int livres = 3*x/4 ;
            int resteLivres = x % 4 ;
            int rubriques = x - livres - resteLivres ;
            int budgetCafe = rubriques/3 ;
            int budgetFlash = rubriques/3 ;
            int budgetMetro = rubriques/3 ;
            int resteRubriques = rubriques % 3 ;
            int nbCafe = budgetCafe/2 ;
            int resteCafe = budgetCafe % 2 ;
            int nbFlash = budgetFlash/4 ;
            int resteFlash = budgetFlash % 4 ;
            int nbMetro = budgetMetro/3 ;
            int resteMetro = budgetMetro % 3 ;
            int resteT = resteLivres + resteRubriques + resteCafe + resteFlash + resteMetro ;

            System.out.println("Avec cette somme d'argent,") ;
            System.out.println("vous dépensez " + livres + " Frs sur vos livres et fournitures." );
            System.out.println("puis, vous pouvez acheter :") ;
            System.out.println(nbCafe + " cafés");
            System.out.println(nbFlash + " numéros du Flash Informatique");
            System.out.println(nbMetro + " billets de métro");
            System.out.println("et il vous restera " + resteT + " Frs pour acheter des fleurs.") ;
    }
}