package exercises.week4;

import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        aCoder = s.toLowerCase();
        String cleaned = "";
        int diff;

        for (int i=0;i<aCoder.length(); i++){
            char c = aCoder.charAt(i);
            if(Character.isLetter(c) || Character.isWhitespace(c)){
                cleaned += c;
            }
        }
        System.out.println("La chaine nettoyée est : \""+cleaned+"\"");

        for(int i=0; i < cleaned.length(); i++){
            if(i+DECALAGE <=26){
                diff = i + DECALAGE;
            }else{
                diff = i + DECALAGE - 26;
            }
            int index = ALPHABET.indexOf(cleaned.charAt(i)); // index du charactere a la pos. i de cleaned dans alphabet
            chaineCodee = cleaned.replace(ALPHABET.charAt(index), ALPHABET.charAt(index+diff));


        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}
