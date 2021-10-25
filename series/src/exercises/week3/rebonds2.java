package exercises.week3;

import java.util.Scanner;

public class rebonds2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final double g = 9.81;
        double H0;
        double eps;
        double h_fin;

        double v;
        double v1;
        double h;
        double h1;

        int n = 0;

        do {
            System.out.print("Quelle est la valeur de départ H0 ?(>=0) : ");
            H0 = scanner.nextDouble();
            System.out.print("Quel est la valeur du coefficient de rebond epsilon ? (0<=eps<1) : ");
            eps = scanner.nextDouble();
            System.out.print("Quelle est la valeur de la hauteur finale souhaitée ? (>=0): ");
            h_fin = scanner.nextInt();
        }while((H0 <= 0) || (0 >= eps || eps > 1) || (0 > h_fin));

        h=H0;

        do {
            v = Math.sqrt(2*h*g);
            v1 = eps*v;
            h1 = (v1*v1)/(2*g);
            h = h1;
            n++;
        }while (h1>=h_fin);

        System.out.println("La valeur du nombre de rebonds est de : "+n);
    }
}
