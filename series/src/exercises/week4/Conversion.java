package exercises.week4;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input;
        do {
            System.out.print("Veuillez entrer la lettre à convertir : ");
            input = scanner.next().charAt(0);
        }while(!Character.isLetter(input));

        int unicode = input;
        int output;
        if (65 <= unicode && unicode <= 90){
            output = unicode + 32;
        } else if (97 <= unicode && unicode <= 122){
            output = unicode - 32;
        }else{
            output = -1;
        }

        if (output!=-1){
            System.out.println("Inputed char was : "+ input);
            System.out.println("Outputed char is : "+ (char)output);
        }else{
            System.out.println("Inputted character can not be converted.");
        }
    }
}
