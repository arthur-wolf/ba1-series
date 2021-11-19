package exercises.week9;

import java.util.ArrayList;

class Magic {
    public static void main(String[] args) {
        Jeu maMain = new Jeu(10);

        maMain.piocher(new Terrain('b'));
        maMain.piocher(new Creature(6, "Golem", 4, 6));
        maMain.piocher(new Spell(1, "Croissance Gigantesque",
                "La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));

        System.out.println("Là, j'ai en stock :");
        maMain.afficher();
        maMain.play();
    }
}

class Jeu {
    ArrayList<Card> hand;

    public Jeu(int amount) {
        hand = new ArrayList<Card>(10);
    }

    public void piocher(Card card){
        if (hand.size() < 10){ // Si le jeu possède moins de 10 cartes
            hand.add(card);
        }
    }

    public void play(){
        for (Card card : hand){
            if (card != null){
                System.out.println("La carte jouée est : " + card);
                card = null;
                break;
            }
        }
    }

    public void afficher(){
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}

abstract class Card {
    private int cost;

    public Card(int cost) {
        this.cost = cost;
    }

    @Override
    abstract public String toString();
}

class Terrain extends Card{
    private char color;
    private int cost;

    public Terrain (char color){
        super(0);
        this.color = color;

        switch (color){
            case 'B':
                System.out.println("Terrain blanc");
            case 'b':
                System.out.println("Terrain bleu");
            case 'n':
                System.out.println("Terrain noir");
            case 'r':
                System.out.println("Terrain rouge");
            case 'v':
                System.out.println("Terrain vert");
        }
    }

    @Override
    public String toString() {
        String value = "";
        switch (this.color){
            case 'B':
                value = "Terrain blanc";
            case 'b':
                value = "Terrain bleu";
            case 'n':
                value = "Terrain noir";
            case 'r':
                value = "Terrain rouge";
            case 'v':
                value = "Terrain vert";
            default:
                value = "Terrain";
        }
        return value;
    }
}

class Creature extends Card{
    private String name;
    private int dmgPoints;
    private int hp;

    public Creature(int cost, String name, int dmgPoints, int hp){
        super(cost);
        this.name = name;
        this.dmgPoints = dmgPoints;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Creature " + name + " " + dmgPoints + "/" + hp;
    }
}

class Spell extends Card {
    private String name;
    private String description;

    public Spell(int cost, String name, String description){
        super(cost);
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Un sortilège " + name;
    }
}
