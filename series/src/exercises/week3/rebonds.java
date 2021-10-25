package exercises.week3;

import java.util.Scanner;

public class rebonds {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        final double g = 9.81;
        double H0;
        double eps;
        int nbr;

        double v;
        double v1;
        double h;
        double h1;

        do {
            System.out.print("Quelle est la valeur de départ H0 ?(>=0) : ");
            H0 = scanner.nextDouble();
            System.out.print("Quel est la valeur du coefficient de rebond epsilon ? (0<=eps<1) : ");
            eps = scanner.nextDouble();
            System.out.print("Quelle est la valeur du nombre de rebonds ? (>=0): ");
            nbr = scanner.nextInt();
        }while( !(H0>=0) && !(0<=eps && eps<1) && !(nbr>0) );

        h=H0;

        for(int i=0; i < nbr; ++i){
            v = Math.sqrt(2*h*g);
            v1 = eps*v;
            h1 = (v1*v1)/(2*g);
            h = h1;
            System.out.println("Rebond n°"+ (i+1) + " : h = "+ h);
        }
    }
}
