package exercises.week2;

import java.util.Scanner;

public class polynome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez a (int) : ");
        int a = scanner.nextInt();
        System.out.print("Entrez b (int) : ");
        int b = scanner.nextInt();
        System.out.print("Entrez c (int) : ");
        int c = scanner.nextInt();
        System.out.print("Entrez x (double) : ");
        double x = scanner.nextDouble();

        double ab = a+b;
        double x3 = x*x*x;
        double x2 = x*x;
        double pol = ((ab/2.0)*(x3)) + ((ab*ab)*x2) + a + b + c;
        System.out.println("La valeur du polynôme est : " + pol);
    }
}
