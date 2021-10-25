package exercises.week5;

class Benford {

    public static void main(String[] args) {
        int[] frequencies = new int[9];
        double[] numbers = new double[25];

        //  TEST 1.1
        System.out.println("Test 1.1 : ");
        fillWithSquare(numbers);
        print(numbers);
        System.out.println();
        // FIN TEST 1.1

        //TEST 1.2
        System.out.println("Test 1.2 : ");
        System.out.println(extractMaxDigit(0));
        System.out.println(extractMaxDigit(632));
        System.out.println(extractMaxDigit(-221));
        System.out.println(extractMaxDigit(-554.15));
        System.out.println(extractMaxDigit(0.00421));
        System.out.println();
        // FIN TEST 1.2

        //  TEST 1.3
        System.out.println("Test 1.3 : ");
        analyze(numbers, frequencies);
        print(frequencies);
        System.out.println();
        // FIN TEST 1.3

        //* TEST 1.4
        System.out.println("Test 1.4 : ");
        testBenford(frequencies, numbers.length);
        // FIN TEST 1.4
    }

    static void fillWithSquare(double[] numbers){
        for(int i=0; i<numbers.length; i++){
            numbers[i] = ((i+1)*(i+1))/100.0;
        }
    }

    static int extractMaxDigit(double number){
        boolean ok = false;
        if(number < 0){
            number *= -1; // si number est négatif on le transforme en positif
        }
        if(number==0) return 0;
        while (!ok){ // Tant que number est pas entre 1 et 9
            if(number >=10){
                number /= 10; // si number >= 10 on le ramène en dessous
            }else if(number <1) {
                number *= 10; // si number < 1 on le ramène au dessus
            }else{
                ok=true; // on sort de la boucle si number est dans les bornes
            }
        }
        return (int)number; // on transtype notre double en int
    }


    static void analyze(double[] numbers, int[] occurences){
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++) {
                if (i + 1 == extractMaxDigit(numbers[j])) {
                    occurences[i]++;
                }
            }
        }
    }

    static void testBenford(int[] occurence, int numlen){
        System.out.println("Pourcentage effectif / Predictions de la loi Benford : ");
        for(int i = 0; i < 9; i++){
            double bf = Math.log10(1 + (1/(i*1.0 + 1)));
            double ratio = (occurence[i]*1.0/numlen)*100;
            System.out.print(i+1 +" : "+ ratio + "% || Benford : ");
            System.out.println(bf*100+" %");
        }
    }

    /* METHODES UTILTAIRES FOURNIES*/

    // affichage  d'un tableau d'entiers
    public static void print(int[] tab) {
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    // affichage  d'un tableau de doubles
    public static void print(double[] tab) {
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }
}

