public class Vertex {

    public int vertexIndex;
    public int weight;
    public int parentIndex;

    public Vertex(int vertexIndex, int weight, int parentIndex) {
        this.weight = weight;
        this.vertexIndex = vertexIndex;
        this.parentIndex = parentIndex;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("To -> " + (vertexIndex + 1) + " with " + weight);

        return output.toString();
    }
}