package exercises.week9;

class Surfaces2 {
    public static void main(String[] args) {

        Terrain1 t = new Terrain1();

        t.ajouterForme(new Rectangle1(100, 100));
        t.ajouterForme(new Cercle(50));

        t.afficherSurfaceTotale();
    }
}

class Terrain1 {
    private Forme[] tab;
    private int nbrFormes = 0;

    public Terrain1(){
        tab = new Forme[8];
    }

    public boolean ajouterForme(Forme forme){
        if (nbrFormes < tab.length){
            tab[nbrFormes] = forme;
            nbrFormes ++;
            return true;
        } else {
            return  false;
        }
    }

    public void afficherSurfaceTotale(){
        double total = 0;
        for (int i = 0; i < tab.length; ++i){
            total += tab[i].calculerSurface();
        }
        System.out.println("La surface totale est de : " + total);
    }
}

abstract class Forme {
    public abstract double calculerSurface();
}

class Cercle extends Forme {
    private double radius;

    public Cercle(double radius){
        this.radius = radius;
    }

    public double calculerSurface(){
        return (Math.PI * Math.pow(radius, 2));
    }
}

class Rectangle1 extends Forme {
    private double length;
    private double width;

    public Rectangle1(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double calculerSurface(){
        return (width * length);
    }
}


