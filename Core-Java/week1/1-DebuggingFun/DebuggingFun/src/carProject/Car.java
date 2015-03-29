package carProject;

public abstract class Car {
    String name;

    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return this.name;
    }

    public Car(String name) {
        this.SetName(name);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("Name - " + this.name);

        return output.toString();
    }
}