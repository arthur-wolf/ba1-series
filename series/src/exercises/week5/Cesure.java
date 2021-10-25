package exercises.week5;

import java.util.Scanner;

class Cesure {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            String[] phrase = lirePhrase();
            for (int i = 0; i < phrase.length; i++) {
            cesure(phrase[i]);
            }
    }


    static String[] lirePhrase() {
        System.out.print("Combien de mots votre phrase contiendra-t-elle ? : ");
        int nbr = scanner.nextInt();
        String[] mots = new String[nbr];
        for(int i = 0; i<nbr; i++){
            System.out.println("Quel est le mot "+ (i+1) +" ? : ");
            mots[i] = scanner.next();
        }
        return mots;
    }

    static boolean voyelle(char c) {
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
        }
    return false;
    }

    static boolean queVoyelles(String s) {
        int count = 0;
        for(int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(voyelle(c)){
                count ++;
            }
        }
        return count == s.length();
    }

    static void cesure(String mot) {
        int debut = 0;
        for (int i = 1; i < mot.length(); i++) {
            char c1 = mot.charAt(i - 1);
            char c2 = mot.charAt(i);
            if ((voyelle(c1) && !voyelle(c2))) {
                String s1 = mot.substring(debut, i);
                String s2 = mot.substring(i, mot.length());
                if ((s1.length() > 1) && (s2.length() > 1)) {
                    if (!(queVoyelles(s1) || queVoyelles(s2))) {
                        System.out.println(s1 + "-");
                        debut = i;
                    }
                }
            }
        }
        String s1 = mot.substring(debut, mot.length());
        System.out.println(s1);

    }
}
