package immutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class ImmutableList<T> extends ArrayList<T> {
    private final Collection collection;

    public ImmutableList(Collection<? extends T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(T e) {
        throw new InvalidOperationImmutable("Cant add element because object is immutable.");
    }

    @Override
    public void add(int index, T element) {
        throw new InvalidOperationImmutable("Cant add element because object is immutable.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new InvalidOperationImmutable("Cant add element because object is immutable.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new InvalidOperationImmutable("Cant add element because object is immutable.");
    }

    @Override
    public void clear() {
        throw new InvalidOperationImmutable("Cant claer the object because its immutable.");
    }

    @Override
    public T remove(int index) {
        throw new InvalidOperationImmutable("Cant remove element because object is immutable.");
    }

    @Override
    public boolean remove(Object o) {
        throw new InvalidOperationImmutable("Cant remove element because object is immutable.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new InvalidOperationImmutable("Cant replace element because object is immutable.");
    }

    @Override
    public boolean removeIf(Predicate<? super T> arg0) {
        throw new InvalidOperationImmutable("Cant remove element because object is immutable.");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new InvalidOperationImmutable("Cant remove element because object is immutable.");
    }

    @Override
    public void replaceAll(UnaryOperator<T> arg0) {
        throw new InvalidOperationImmutable("Cant replace element because object is immutable.");
    }

    @Override
    public T set(int index, T element) {
        throw new InvalidOperationImmutable("Cant set element because object is immutable.");
    }
}
