package exercises.week4;

import java.util.Scanner;

public class pascal{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How big should the triangle be ? n = ");
        int n = scanner.nextInt();

        int[][]triangle = new int[n][]; // On crée un tableau de dimension 2, dim 1 = n lignes, dim 2 = variable
        triangle[0]=new int[1]; // On instancie l'index 0 a un tableau (colonnes) de taille 1
        triangle[0][0] = 1; // on instancie la premiere ligne

        for(int row=1; row<n; row++){
            triangle[row] = new int[triangle[row-1].length +1];
            for(int col=0; col<=row; col++){
                if(col==row || col==0){
                    triangle[row][col]=1;
                }else{
                    triangle[row][col]=triangle[row-1][col-1] + triangle[row-1][col];
                }
            }
        }
        for(int row=0;row<n;row++){
            for(int col=0;col<=row; col++){
                System.out.print(triangle[row][col]+" ");
            }
            System.out.println();
        }
    }
}
