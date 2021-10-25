package exercises.week4;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Veuillez entrer la chaine à tester : ");
        String inputStr = scanner.nextLine().toLowerCase(); // Convertit la string entrée en minuscules

        String cleanedStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if (Character.isLetter(c)) {
                cleanedStr += c;
            }
        }

        int left = 0;
        int right = cleanedStr.length() - 1;
        boolean palindrome = true;

        while ((left < right) && palindrome) {
            palindrome = cleanedStr.charAt(left) == cleanedStr.charAt(right);
            left++;
            right--;
        }

        if (palindrome) {
            System.out.println("\"" + inputStr + "\"" + " est bien un palindrome !");
        } else {
            System.out.print("\"" + inputStr + "\"" + " n'est pas un palindrome !");
        }

    }
}