public class Pair {

    public int vertex;
    public int weight;
    public int parentWeight;

    public Pair(int vertex, int weight, int parentWeight) {
        this.weight = weight;
        this.vertex = vertex;
        this.parentWeight = parentWeight;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("To -> " + (vertex + 1) + " with " + weight);

        return output.toString();
    }
}