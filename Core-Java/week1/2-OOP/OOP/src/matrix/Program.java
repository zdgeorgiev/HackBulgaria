package matrix;

public class Program {
    public static void main(String[] args) {
        Matrix m = new Matrix(5, 5);

        System.out.println(m);

        m.operate(new Threshold());

        System.out.println(m);

        m.operate(new GaussianBlur());

        System.out.println(m);
    }
}