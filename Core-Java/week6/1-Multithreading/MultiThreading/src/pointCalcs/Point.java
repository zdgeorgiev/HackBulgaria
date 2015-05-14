package pointCalcs;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Point {
    public Integer x;
    public Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p) {
        return Math.sqrt((double) ((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y)));
    }

    @Override
    public int hashCode() {
        // 1) Take a prime hash e.g. 5, 7, 17 or 31 (prime number as hash,
        // results in distinct hashcode for distinct object)
        // 2) Take another prime as multiplier different than hash is good.

        int hash = 7;

        hash += 5 * this.x.hashCode();
        hash += 5 * this.y.hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        if (obj == this)
            return true;

        Point other = (Point) obj;
        return new EqualsBuilder().append(this.x, other.x).append(this.y, other.y).isEquals();
    }
}
