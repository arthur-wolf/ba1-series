package exercises.week4;

import java.util.Scanner;

public class Napoleon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        String namesList = "Napoleon Bonaparte Bill Gates Claudia Schiffer Martina Hingis";

        System.out.print("Entrez un prénom : ");
        String name = scanner.next(); // stocke le prénom dont on cherche le nom associé

        String[] splittedNames = namesList.split(" ");

        for(int i=0; i<splittedNames.length; ++i){
            if(name.equals(splittedNames[i])){
                System.out.println("Le nom de "+ name +" est : "+ splittedNames[i+1]);
                found = true;
            }
        }

        if(!found){
            System.out.println("Inconnu au bataillon !");
        }
    }
}
