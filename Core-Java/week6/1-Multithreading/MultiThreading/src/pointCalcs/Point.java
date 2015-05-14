package pointCalcs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p) {
        return Math.sqrt((double) ((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y)));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.x).append(this.y).toHashCode();
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