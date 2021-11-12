package exercises.week7;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Supermarche {

    public static void main(String[] args) {
        // Les articles vendus dans le supermarché
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);

        // Les caddies du supermarchÃ©
        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();

        // Les caisses du supermarché
        // le premier argument est le numéro de la caisse
        // le second argument est le montant initial de la caisse.
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);

        // les clients font leurs achats
        // le second argument de la méthode remplir
        // correspond à  une quantité

        // remplissage du 1er caddie
        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);

        // remplissage du 2eme caddie
        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);

        // remplissage du 3eme caddie
        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);

        // Les clients passent à  la caisse
        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);

        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}

class Article {
    private String name;
    private double price;
    private boolean hasDiscount;

    public Article(String inputName, double inputPrice, boolean inputHasDiscount) {
        name = inputName;
        price = inputPrice;
        hasDiscount = inputHasDiscount;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean getHasDiscount() {
        return hasDiscount;
    }
}

class Achat {
    private Article article;
    private int amount;

    public Achat(Article inputArticle, int inputAmount) {
        article = inputArticle;
        amount = inputAmount;
    }

    public double getPrice() {
        double rabais = 1.0;
        if (article.getHasDiscount()){
            rabais = 0.5;
        }
        return amount  * article.getPrice() * rabais;
    }

    public void affiche() {
        String name = article.getName();
        double unitPrice = article.getPrice();
        double totalPrice = getPrice();
        String rabais = "";
        if (article.getHasDiscount()){
            rabais = "(1/2 price)";
        }
        System.out.println(name + " : " + unitPrice + " x " + amount + " = " + totalPrice + " CHF " + rabais);
    }
}

class Caisse {
    private int nbCaisse;
    private double amountScanned;

    public Caisse(int nbCaisse, double amountScanned){
        this.nbCaisse = nbCaisse;
        this.amountScanned = amountScanned;
    }

    public void totalCaisse(){
        System.out.println("La caisse numéro "+ nbCaisse +" a encaissé "+ Math.round(amountScanned)+ " CHF aujourd'hui");
    }

    public void scanner(Caddie caddie) {
        System.out.println("=====================================");
        Date currentDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
        System.out.println(formatDate.format(currentDate));
        System.out.println("Caisse numéro " + nbCaisse);
        System.out.println();

        int nbAchat = caddie.getNbAchat();
        double totalAmount = 0.0;

        for (int i = 0; i < nbAchat; i++){
            Achat achat = caddie.getAchat(i);
            double price = achat.getPrice();
            achat.affiche();
            totalAmount += price;
            amountScanned +=  price;
        }

        System.out.println();
        System.out.println("Amount to pay : " + totalAmount + " CHF");
        System.out.println("=====================================");
    }
}

class Caddie {
    private ArrayList<Achat> listeAchats;

    public Caddie() {
        this.listeAchats = new ArrayList<Achat>();
    }

    public void remplir(Article article, int amount){
        Achat achat = new Achat(article, amount);
        listeAchats.add(achat);
    }

    public Achat getAchat(int index){
        return listeAchats.get(index);
    }

    public int getNbAchat(){
        return listeAchats.size();
    }
}
