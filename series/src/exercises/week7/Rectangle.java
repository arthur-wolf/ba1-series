package exercises.week7;

/* Dans ce programme, les 2 rectangles sont encapsulés dans un objet
 * de type Terrain qui s'occupe de calculer et d'afficher la surface
 * totale. Le mot-clé private a été utilisé le plus possible dans
 * toutes les classes. La classe Rectangle met aussi à disposition des
 * méthodes get et set pour ses variables (il s'agit d'un service que
 * le programmeur de la classe peut offrir à ses utilisateurs s'il le
 * juge utile).
 */

class Surfaces {

    public static void main(String[] args) {
        Terrain t = new Terrain(1.0, 2.0, 3.0 ,4.0, 5.0, 6.0,
                7.0, 8.0);
        t.afficherSurfaceTotale();
    }

}

class Terrain {

    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;
    private Cercle c1;
    private Cercle c2;

    public Terrain(double l1, double h1,
                   double l2, double h2,
                   double l3, double h3,
                   double rayon1,
                   double rayon2) {
        r1 = new Rectangle(l1, h1);
        r2 = new Rectangle(l2, h2);
        r3 = new Rectangle(l3, h3);
        c1 = new Cercle(rayon1);
        c2 = new Cercle(rayon2);
    }

    private double calculerSurfaceTotale() {
        return r1.calculerSurface() + r2.calculerSurface() + r3.calculerSurface()
                + c1.calculerSurface() + c2.calculerSurface();
    }

    public void afficherSurfaceTotale() {
        double surfaceTotale = calculerSurfaceTotale();
        System.out.println("La surface totale est : " + surfaceTotale);
    }
}

class Rectangle {

    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public double calculerSurface() {
        return largeur*hauteur;
    }
}

class Cercle {

    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    public double calculerSurface() {
        return Math.PI * Math.pow(rayon, 2);
    }
}
