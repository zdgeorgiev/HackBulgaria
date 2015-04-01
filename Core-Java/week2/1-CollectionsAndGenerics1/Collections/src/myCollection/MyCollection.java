package myCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<T> implements Collection<T> {
    private ArrayList<T> data;

    public MyCollection() {
        this.data = new ArrayList<T>();
    }

    public boolean add(T arg0) {
        if (arg0 == null) {
            return false;
        }

        if (this.data.contains(arg0)) {
            return false;
        }

        return this.data.add(arg0);
    }

    public boolean addAll(Collection<? extends T> arg0) {
        if (arg0 == null) {
            return false;
        }

        return this.data.addAll(arg0);
    }

    public void clear() {
        this.data.clear();
    }

    public boolean contains(Object arg0) {
        if (arg0 == null) {
            return false;
        }

        return this.data.contains(arg0);
    }

    public boolean containsAll(Collection<?> arg0) {
        if (arg0 == null) {
            return false;
        }

        return this.data.containsAll(arg0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    public boolean remove(Object arg0) {
        if (arg0 == null) {
            return false;
        }

        return this.data.remove(arg0);
    }

    public boolean removeAll(Collection<?> arg0) {
        if (arg0 == null) {
            return false;
        }

        return this.data.removeAll(arg0);
    }

    public boolean retainAll(Collection<?> arg0) {
        if (arg0 == null) {
            return false;
        }

        return this.data.removeAll(arg0);
    }

    public int size() {
        return this.data.size();
    }

    public Object[] toArray() {
        return this.data.toArray();
    }

    public <T> T[] toArray(T[] arg0) {
        if (arg0 == null) {
            return null;
        }

        return this.data.toArray(arg0);
    }
}