public class Pair {
    public int vertex;
    public int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Index " + this.vertex + " weight " + this.weight);
        return output.toString();
    }
}