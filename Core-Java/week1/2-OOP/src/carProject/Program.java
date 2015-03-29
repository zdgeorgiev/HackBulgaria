package carProject;

public class Program {

    public static void main(String[] args) {
        Car bwm = new BMW();
        Car audi = new Audi(20);

        System.out.println(bwm);
        System.out.println(audi);
    }
}