package exercises.week3;

import java.util.Scanner;

public class combipermu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quelle est le valeur de n ? : ");
        int n = scanner.nextInt();
        System.out.print("Quelle est la valeur de k ? : ");
        int k = scanner.nextInt();
        int n_fact = 1;
        int k_fact = 1;
        int nk_fact = 1;

        for(int i=1; i<=n;i++){
            n_fact *= i;
        }
        for(int j=1; j<=k;j++){
            k_fact *= j;
        }
        for(int l=1; l<=(n-k);l++){
            nk_fact *= l;
        }

        int permu = n_fact / nk_fact;
        int combi = n_fact / (k_fact * nk_fact);

        System.out.println("Nombre de combinaisons : "+ combi);
        System.out.println("Nombre de permutations : "+ permu);

    }
}
