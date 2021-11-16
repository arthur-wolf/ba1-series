package exercises.week8;

import java.util.ArrayList;

// PROGRAMME PRINCIPAL (A NE PAS MODIFIER)
class Poste {

    public static void  main(String args[]) {
        //Création d'une boite-aux-lettres
        // 30  est la capacité maximale de la boite aux lettres
        Boite boite = new Boite();

        //Creation de divers courriers/colis..
        Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
        Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

        Pub pub1 = new Pub(1500, true, "Les Moilles  13A, 1913 Saillon");
        Pub pub2 = new Pub(3000, false, ""); // invalide

        Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
        Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);


        System.out.println("Le montant total d'affranchissement est de " +
                boite.affranchir());
        //boite.afficher();

        //System.out.println("La boite contient " + boite.courriersInvalides()
        //        + " courriers invalides");
    }
}

class Boite {
    private ArrayList<Courier> boite;

    public Boite() {
        boite = new ArrayList<Courier>();
    }

    public void ajouterCourrier(Courier courier){
        boite.add(courier);
    }

    public double affranchir(){
        double total = 0;
        for (Courier courier : boite) {
            if (courier.isValid()) {
                double prix = 0.0;
                int poids = courier.getPoids() / 1000;
                if (courier instanceof Lettre) { // Case Lettre
                    if (((Lettre) courier).getFormat().equals("A4")) {
                        prix = 2.50 + 1.0 * poids;
                    } else if (((Lettre) courier).getFormat().equals("A3")) {
                        prix = 3.50 + 1.0 * poids;
                    }
                } else if (courier instanceof Pub) { // Case Pub
                    prix = 5.0 * poids;
                } else if (courier instanceof Colis) { // Case Colis
                    prix = 0.25 * ((Colis) courier).getVolume() + poids * 1.0;
                }
                if (courier.getExpedition()) { // Expedition express --> doublé
                    prix *= 2;
                }
                total += prix;
            }
        }
        return total;
    }
}

class Courier {
    private int poids;
    private boolean expedition; // true si express
    private String destination;
    private boolean valid;

    public Courier(int poids, boolean expedition, String destination){
        this.poids = poids;
        this.expedition = expedition;
        this.destination = destination;
    }

    public boolean getExpedition(){
        return expedition;
    }

    public int getPoids() {
        return poids;
    }

    public boolean isValid(){
        return this.destination.length() > 0;
    }
}

 class Lettre extends Courier {
    private String format;

    public Lettre(int poids, boolean expedition, String destination, String format){
        super(poids, expedition, destination);
        this.format = format;
    }

     public String getFormat() {
         return format;
     }
 }

 class Colis extends Courier {
    private int volume;

    public Colis(int poids, boolean expedition, String destination, int volume){
        super(poids, expedition, destination);
        this.volume = volume;
    }

     public int getVolume() {
         return volume;
     }

     public boolean isValid() {
         return (super.isValid() && getVolume() > 50);
     }
 }

 class Pub extends Courier {

    public Pub(int poids, boolean expedition, String destination){
        super(poids, expedition, destination);
    }
 }
