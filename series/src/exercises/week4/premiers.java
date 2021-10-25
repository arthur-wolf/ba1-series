package exercises.week4;

import java.util.ArrayList;

public class premiers {
    public static void main(String[] args) {
        ArrayList<Integer> tab = new ArrayList<>();

        for(int n = 2; n <= 100; n++){
            boolean premier = true;
            if(n%2==0){ // si le nombre n est pair
                if (n!=2){ // si ce n'est pas 2, il n'est pas premier
                    premier = false;
                }
            } else { // Le nombre i est impair
                double max = Math.sqrt(n); // On définit la racine carrée de n
                for(int i= 3;i<=max; i+=2){ // pour les nombres impairs <= sqrt(n)
                    if (n % i == 0) { // si i divise n
                        premier = false;
                        break;
                    }
                }
            }
            if(premier){
                tab.add(n);
            }
        }

        System.out.println("Les nombres premiers compris entre 2 et 100 sont :");
        for (int i=0; i<tab.size(); i++){
            System.out.println(tab.get(i));
        }
    }
}
