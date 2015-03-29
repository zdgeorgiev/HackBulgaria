package carProject;

public class Audi extends Car {
    private int mileAge;

    public void SetMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    public int GetMileAge() {
        return this.mileAge;
    }

    public Audi(int mileAge) {
        super("Audi");
        this.SetMileAge(mileAge);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString());
        output.append(", Mile age - " + this.mileAge);

        return output.toString();
    }
}