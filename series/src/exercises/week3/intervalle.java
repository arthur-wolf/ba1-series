package exercises.week3;

import java.util.Scanner;

public class intervalle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an integer : x=");
        double x = scanner.nextInt();

        if(x >= 2 && x<3){
            System.out.println("x is contained in I");
        }
        else if(x>0 && x <=1){
            System.out.println("x is contained in I");
        }
        else if(x>=-10 && x<=-2){
            System.out.println("x is contained in I");
        }
        else{
            System.out.println("x is not contained in I");
        }

    }
}
