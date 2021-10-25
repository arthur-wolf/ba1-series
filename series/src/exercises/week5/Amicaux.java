package exercises.week5;

public class Amicaux {
    public static void main(String[] args) {
        int[] nombres = {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
        System.out.println("Les paires de nombres amicaux sont : ");
        afficherAmicaux(nombres);
    }

    static void afficherAmicaux(int[] nombres){
        for(int i = 0; i < nombres.length; i++){
            for(int j = i+1; j < nombres.length; j++){
                if(amical(nombres[i], nombres[j])){
                    System.out.println(nombres[i] + " " + nombres[j]);
                }
            }
        }
    }

    static boolean amical(int nb1, int nb2){
        int somme = divsum(nb1);
        return (nb1 + nb2 == somme && divsum(nb2)==somme);
    }

    static int divsum(int nbr){         //Méthode qui calcule la somme des diviseurs d'un entier donné en paramètre
        int sum = 0;
        for(int i = 1; i <= nbr; i++){
            if(nbr % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
