package exercises.week8;

import java.util.ArrayList;

class Direction {
    public static void main(String[] args) {
        Ecole epfl = new Ecole();
        epfl.addStudent(new RegularStudent("Gaston Peutimide", 2020, "SSC", 6.0));
        epfl.addStudent(new RegularStudent("Yvan Rattrapeur", 2016, "SSC", 2.5));
        epfl.addStudent(new ExchangeStudent("Bjorn Borgue", 2018, "Informatique", "KTH"));
        epfl.addStudent(new Teacher("Mathieu Matheu", 2015, "LMEP", 10000, "Physique"));
        epfl.addStudent(new Secretary("Sophie Scribona", 2005, "LMT", 5000));
        epfl.printStats();
        epfl.printEPFLiens();
    }
}

class Ecole {
    private ArrayList<EPFLiens> gens;

    public Ecole(){
        gens = new ArrayList<EPFLiens>();
    }

    public void addStudent(EPFLiens person){
        if (person != null){
            gens.add(person);
        }
    }

    public void printStats(){
        System.out.println("Among " + gens.size() + " Epfliens, " +
                            EPFLiens.getStudentNumber() + " are students");
        System.out.println();
    }

    public void printEPFLiens(){
        System.out.println("EPFLiens' list : " + "\n");
        for (EPFLiens epfLiens : gens){
            epfLiens.afficher();
        }
    }
}

class EPFLiens {
    private String name;
    private int yearOfArrival;
    private static int studentNumber;

    public EPFLiens (String name, int yearOfArrival){
        this.name = name;
        this.yearOfArrival = yearOfArrival;
    }

    public void afficher(){
        System.out.println("    Nom : " + getName());
        System.out.println("    Année : " + getYear());
    }

    public String getName(){
        return name;
    }

    public int getYear(){
        return yearOfArrival;
    }

    public static int getStudentNumber() {
        return studentNumber;
    }

    protected void increaseStudentNbr(){
        ++studentNumber;
    }
}

class Staff extends EPFLiens {
    private String lab;
    private int salary;

    public Staff (String name, int yearOfArrival, String lab, int salary){
        super(name, yearOfArrival);
        this.lab = lab;
        this.salary = salary;
    }

    public void afficher(){
        System.out.println("Staff : ");
        super.afficher();
        System.out.println("    Lab : " + getLab());
        System.out.println("    Salary : " + getSalary());
        System.out.println();
    }

    public int getSalary(){
        return salary;
    }

    public String getLab(){
        return lab;
    }
}

class Secretary extends Staff {

    public Secretary (String name, int yearOfArrival, String lab, int salary){
        super(name, yearOfArrival, lab, salary);
    }
}

class Teacher extends Staff {
    private String section;

    public Teacher (String name, int yearOfArrival, String lab, int salary, String section){
        super(name, yearOfArrival, lab, salary);
        this.section = section;
    }
}

class Students extends EPFLiens {
    private String section;

    public Students(String name, int yearOfArrival, String section){
        super(name, yearOfArrival);
        this.section = section;
        increaseStudentNbr();
    }

    public String getSection(){
        return section;
    }

    public void afficher(){
        super.afficher();
        System.out.println("    Section : " + getSection());
    }
}

class RegularStudent extends Students {
    private double prope1Grade;

    public RegularStudent(String name, int yearOfArrival, String section, double prope1Grade){
        super(name, yearOfArrival, section);
        this.prope1Grade = prope1Grade;
    }

    public void afficher(){
        System.out.println("Regular Student : ");
        super.afficher();
        System.out.println("    Propé 1 Grade : " + getP1Grade());
        System.out.println();
    }

    public double getP1Grade(){
        return prope1Grade;
    }
}

class ExchangeStudent extends Students {
    private String prevSchool;

    public ExchangeStudent(String name, int yearOfArrival, String section, String prevSchool){
        super(name, yearOfArrival, section);
        this.prevSchool = prevSchool;
    }

    public void afficher(){
        System.out.println("Exchange student : ");
        super.afficher();
        System.out.println("    Previous school : " + getPrevSchool());
        System.out.println();
    }

    public String getPrevSchool(){
        return prevSchool;
    }
}