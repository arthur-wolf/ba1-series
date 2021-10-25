package exercises.week4;

import java.util.Scanner;

public class prod_scalaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        int result=0;
        int nmax = 10;
        int []v1 = new int[nmax];
        int []v2 = new int[nmax];

        do {
            System.out.print("Quelle est la taille n des vecteurs ? : ");
            n = scanner.nextInt();
        }while(n<1 || n>nmax);

        for(int i=0; i<n; ++i){
            System.out.print("Entrez la valeur du coefficient "+i+" de v1 : ");
            v1[i] = scanner.nextInt();
        }
        for(int i=0; i<n; ++i){
            System.out.print("Entrez la valeur du coefficient "+i+" de v2 : ");
            v2[i] = scanner.nextInt();
        }

        for(int i=0;i<=n;++i){
            result+=v1[i]*v2[i];
        }
        System.out.println("Le résultat du produit scalaire est : "+result);
    }
}
