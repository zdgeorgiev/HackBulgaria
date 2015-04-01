package boundedQueue;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BoundedQueue<T> implements Queue<T> {
    private Integer limit;
    private AbstractQueue<T> data;

    public BoundedQueue(Integer limit) {
        this.data = new PriorityQueue<T>();
        this.setLimit(limit);
    }

    public boolean addAll(Collection<? extends T> arg0) {
        if (arg0 == null) {
            return false;
        }
        
        for (T item : arg0) {
            this.data.add(item);
        }

        return true;
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

        return this.data.retainAll(arg0);
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

    public boolean add(T arg0) {
        if (arg0 == null) {
            return false;
        }

        if (this.data.size() == this.limit) {
            // Copy every element except the first one
            AbstractQueue<T> cpy = new PriorityQueue<T>();
            Iterator<T> cpyIt = this.data.iterator();
            // Skip the first one
            cpyIt.next();
            while (cpyIt.hasNext()) {
                cpy.add((T) cpyIt.next());
            }

            this.data.clear();
            this.data.addAll(cpy);
        }

        return this.data.add(arg0);
    }

    public T element() {
        return this.data.element();
    }

    public boolean offer(T arg0) {
        if (arg0 == null) {
            return false;
        }

        if (this.data.size() == this.limit) {
            // Copy every element except the first one
            AbstractQueue<T> cpy = new PriorityQueue<T>();
            Iterator<T> cpyIt = this.data.iterator();
            // Skip the first one
            cpyIt.next();
            while (cpyIt.hasNext()) {
                cpy.add((T) cpyIt.next());
            }

            this.data.clear();
            this.data.addAll(cpy);
        }

        return this.data.offer(arg0);
    }

    public T peek() {
        return this.data.peek();
    }

    public T poll() {
        return this.data.poll();
    }

    public T remove() {
        return this.data.remove();
    }

    public Integer getLimit() {
        return this.limit;
    }

    private void setLimit(Integer limit) {
        if (limit < 0) {
            return;
        }

        this.limit = limit;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("[ ");

        Iterator<T> cpyIt = this.data.iterator();
        cpyIt.hasNext();

        while (cpyIt.hasNext()) {
            output.append((T) cpyIt.next() + " ");
        }

        output.append("]");

        return output.toString();
    }
}