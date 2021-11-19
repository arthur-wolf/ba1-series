package exercises.week9;

class ToStringEq {
    public static void main(String[] args) {
        System.out.println("Test 1 :");
        Rectangle rect = new Rectangle(12.5, 4.0);
        System.out.println(rect);
        System.out.println();

        System.out.println("Test 2: ");
        // le type de rect1 est RectangleColore
        // l'objet contenu dans rect1 est de type RectangleColore
        RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
        System.out.println(rect1);
        System.out.println();

        System.out.println("Test 3 :");

        // le type de rect2 est Rectangle
        // l'objet contenu dans rect2 est de type RectangleColore
        Rectangle  rect2 = new RectangleColore(25.0/2, 8.0/2, new String("rouge"));
        System.out.println(rect2);

        System.out.println (rect1.equals(rect2)); // 1.
        System.out.println (rect2.equals(rect1)); // 2.
        System.out.println(rect1.equals(null));   // 3.
        System.out.println (rect.equals(rect1));  // 4.
        System.out.println (rect1.equals(rect));  // 5.
    }
}

class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length){
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString(){
        return "Rectangle : " + "\n"
                + " largeur = " + width + "\n"
                + " longueur = " + length;
    }

    public boolean equals(Rectangle object){
        if (object == null){
            return false;
        } else if (this.getClass() != object.getClass()){
            return false;
        } else {
            return (this.length == object.length && this.width == object.width);
        }
    }
}

class RectangleColore extends Rectangle {
    private String color;

    public RectangleColore(double width, double length, String color){
        super(width, length);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        return super.toString() + "\n"
                + " couleur = " + color;
    }

    public boolean equals(RectangleColore object){
        if (object == null){
            return false;
        } else if (this.getClass() != object.getClass()){
            return false;
        } else {
            return (this.getLength() == object.getLength() && this.getWidth() == object.getWidth());
        }
    }
}
