import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class OurArrayList<Type> implements OurList<Type> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Type[] source;

    public OurArrayList() {
        source = (Type[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(Type element) {
        if (size == source.length)
            increaseCapacity();

//        source[size++] = element;
        source[size] = element;
        size++;
    }

    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Type[] newSource = (Type[]) new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public Type get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return source[index];
    }

    @Override
    public void set(int index, Type value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }

    @Override
    public Type removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Type res = source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        source[--size] = null;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        source = (Type[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean remove(Type obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    removeById(i);
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i])) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Type obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null)
                    return true;
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i]))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Type> forwardIterator() {
        Iterator<Type> iterator = new ForwardIterator(this);
        return iterator;
    }

    @Override
    public Iterator<Type> backwardIterator() {
        Iterator<Type> iterator = new BackwardIterator(this);
        return iterator;
    }

    @Override
    public void sort(Comparator<Type> comparator) {
        Type[] copy = (Type[]) new Object[size];

        int i = 0;
        for (Type elt : this) {
            copy[i++] = elt;
        }
        this.clear();
        //insertionSort(copy, comparator);
        Arrays.sort(copy,comparator);
        for (Type elt : copy) {
            this.addLast(elt);
        }
    }
    public Type max(Comparator<Type> comparator) {
        if (size == 0)
            return null;

        Iterator<Type> it = new ForwardIterator<>(this);
        Type max = it.next();
        Type temp;
        while (it.hasNext()) {
            temp = it.next();
            max = comparator.compare(max, temp) > 0 ? max : temp;
        }
        return max;
    }

    public Type min(Comparator<Type> comparator) {
        if (size == 0)
            return null;

        Iterator<Type> it = new ForwardIterator<>(this);
        Type min = it.next();
        Type temp;
        while (it.hasNext()) {
            temp = it.next();
            min = comparator.compare(min, temp) < 0 ? min : temp;
        }
        return min;
    }

    @Override
    public Iterator<Type> iterator() {
        return forwardIterator();
    }

    private static class ForwardIterator<Type> implements Iterator<Type> {
        Type[] source;
        int currentIndex;
        int endIndex;

        public ForwardIterator(OurArrayList<Type> list) {
            this.source = list.source;
            endIndex = list.size();
        }

        @Override
        public boolean hasNext() {
            return currentIndex < endIndex;

        }

        @Override
        public Type next() {
            if (currentIndex >= endIndex)
                throw new IndexOutOfBoundsException();
            return source[currentIndex++];
        }
    }

    private static class BackwardIterator<Type> implements Iterator<Type> {
        Type[] source;
        int currentIndex;
        int endIndex;

        public BackwardIterator(OurArrayList<Type> list) {
            this.source = list.source;
            endIndex = list.size;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < endIndex;
        }

        @Override
        public Type next() {
            return source[endIndex - 1 - currentIndex++];
        }
    }
}
