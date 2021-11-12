package exercises.week7;

import java.util.Scanner;

class Geometrie {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Triangle t = new Triangle(lireCoordonnes(), lireCoordonnes(), lireCoordonnes());
        System.out.println("Perimeter is : " + t.computePerimeter());
        if (t.isIsocele()){
            System.out.println("The triangle is isocele");
        }
    }

    static Point lireCoordonnes(){
        double x;
        double y;
        System.out.println("Constructing a new point :");
        System.out.print("Pleaser enter x : ");
        x = scanner.nextDouble();
        System.out.print("Please enter y : ");
        y = scanner.nextDouble();
        return (new Point(x,y));
    }
}

class Triangle {
    private Point p1, p2, p3;
    private double len1, len2, len3;

    public Triangle(Point point1, Point point2, Point point3) {
        p1 = point1;
        p2 = point2;
        p3 = point3;

        // l1 = 1~2, l2 = 2~3, l3 = 3~1
        len1 = p1.computeDistance(p2);
        len2 = p2.computeDistance(p3);
        len3 = p3.computeDistance(p1);
    }

    public double computePerimeter(){
        return (len1 + len2 + len3);
    }

    public boolean isIsocele(){
        return ((len1 == len2) || (len2 == len3) || (len3 == len1));
    }

}

class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double computeDistance(Point p){
        double x1 = this.x;
        double y1 = this.y;

        double x2 = p.getX();
        double y2 = p.getY();

        double xdiff = x1 - x2;
        double ydiff = y1 - y2;

        return Math.sqrt(Math.pow(xdiff, 2) + Math.pow(ydiff, 2));
    }
}
