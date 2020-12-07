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
            return source[endIndex - currentIndex - 1];
        }
    }
}
