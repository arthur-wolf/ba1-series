package exercises.week8;

class GestionVehicules {
    // Pour repréeenter l'année courante:
    // Il est aussi bien sur possible d'utiliser la classe Date
    // pour récupérer cette information automatiquement.
    private static int ANNEE_ACTUELLE = 2020;

    public static void main(String[] args) {
        Voiture[] garage = new Voiture[3];
        Avion[] hangar = new Avion[2];

        garage[0] = new Voiture("Peugeot", 2005, 147325.79, 2.5, 5, 180.0, 12000);
        garage[1] = new Voiture("Porsche", 1999, 250000.00, 6.5, 2, 280.0, 81320);
        garage[2] = new Voiture("Fiat", 2001, 7327.30, 1.6, 3, 65.0, 3000);

        hangar[0] = new Avion("Cessna", 1982, 1230673.90, "HELICES", 250);
        hangar[1] = new Avion("Nain Connu", 1993, 4321098.00, "REACTION", 1300);

        for (int i = 0; i < garage.length; i++) {
            garage[i].calculePrix(ANNEE_ACTUELLE);
            garage[i].affiche();
        }

        for (int i = 0; i < hangar.length; i++) {
            hangar[i].calculePrix(ANNEE_ACTUELLE);
            hangar[i].affiche();
        }
    }
}

class Vehicule {
    private String brand;
    private int buyDate;
    private double buyPrice;
    private double actualPrice;

    public Vehicule(String brand, int buyDate, double buyPrice){
        this.brand = brand;
        this.buyDate = buyDate;
        this.buyPrice = buyPrice;
        actualPrice = buyPrice;
    }

    public void calculePrix(int anneeActuelle) {
        double decote = (anneeActuelle - buyDate) * 0.01;
        actualPrice = Math.max(0, (1.0 - decote) * buyPrice);
    }

    public void affiche() {
        System.out.println("Brand : " + brand + "\n" +
                "Date of buy : " + buyDate + "\n" +
                "Buy price : " + buyPrice + "\n" +
                "Actual Price : " + actualPrice +  "\n");
    }

    public int getDateAchat(){
        return buyDate;
    }
    public String getMarque(){
        return brand;
    }
    public double getPrixAchat(){
        return buyPrice;
    }
    public void setPrixCourant(double prix){
        actualPrice = prix;
    }
}

class Voiture extends Vehicule {
    private double cylinder;
    private int nbDoor;
    private double power;
    private double km;

    public Voiture(String brand, int buyDate, double buyPrice, double cylinder, int nbDoor, double power, double km) {
        super(brand, buyDate, buyPrice);
        this.cylinder = cylinder;
        this.nbDoor = nbDoor;
        this.power = power;
        this.km = km;
    }

    public void calculePrix(int anneeActuelle) {
        double decote = (anneeActuelle - getDateAchat()) * .02;
        // On force le type en int de manière à arrondir le résultat
        // On verra dans quelques semaines une manière plus élégante de faire
        // ce genre de choses...
        decote += 0.05 * (int)(km / 10000);
        if (getMarque().equals("Fiat") || getMarque().equals("Renault")) {
            decote += 0.1;
        } else if (getMarque().equals("Ferrari") || getMarque().equals("Porsche")) {
            decote -= 0.2;
        }
        setPrixCourant(Math.max(0.0, (1.0 - decote) * getPrixAchat()));
    }

    public void affiche() {
        System.out.println("--------- Voiture --------");
        super.affiche();
        System.out.println("Cylinder : " + cylinder + "\n" +
                "Number of doors : " + nbDoor + "\n" +
                "Power : " + power + "\n" +
                "Distance traveled : " + km + "\n");
    }
}

class Avion extends Vehicule {
    private String motortype;
    private int flyTime;

    public Avion(String brand, int buyDate, double buyPrice, String motortype, int flyTime) {
        super(brand, buyDate, buyPrice);
        this.motortype = motortype;
        this.flyTime = flyTime;
    }

    public void calculePrix(int anneActuelle) {
        double decote;
        if (motortype == "HELICES") {
            decote = 0.1 * flyTime / 100.0;
        } else {
            decote = 0.1 * flyTime / 1000.0;
        }

        setPrixCourant(Math.max(0.0, (1.0 - decote) * getPrixAchat()));
    }

    public void affiche() {
        System.out.println("--------- Avion --------");
        super.affiche();
        System.out.println("Motor type : " + motortype + "\n" +
                "Time flown : " + flyTime +  "\n");
    }
}