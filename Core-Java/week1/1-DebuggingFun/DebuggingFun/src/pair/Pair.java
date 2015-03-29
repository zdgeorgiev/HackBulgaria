package pair;

public final class Pair extends Object {
    private Object first;
    private Object second;

    public Pair(Object first, Object second) {
        this.setFirst(first);
        this.setSecond(second);
    }

    private void setFirst(Object first) {
        if (first != null)
            this.first = first;
    }

    private void setSecond(Object second) {
        if (second != null)
            this.second = second;
    }

    public Object getFirst() {
        return this.first;
    }

    public Object getSeond() {
        return this.second;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("[\n");
        output.append("\tFirst - " + first.toString() + "\n");
        output.append("\tSecond - " + second.toString() + "\n");
        output.append("]");

        return output.toString();
    }

    @Override
    public boolean equals(Object arg) {
        Pair other = (Pair) arg;

        if (other != null) {
            if ((this.first.equals(other.first) && (this.second.equals(other.second))))
                return true;
        }

        return false;
    }
}