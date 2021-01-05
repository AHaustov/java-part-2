import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class OurLimitedArrayDeque<T> implements OurDeque<T> {

    private int firstEltID;
    private int size;
    private Object[] source;
    private int capacity;

    public OurLimitedArrayDeque(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.capacity = source.length;
    }

    @Override
    public void addFirst(Object elt) {
        if (size == capacity)
            throw new DequeOverflowException();
        firstEltID = (--firstEltID + capacity) % capacity;
        size++;
        source[firstEltID] = elt;
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new EmptyDequeException();
        return (T) source[firstEltID];
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new EmptyDequeException();

        T res = (T) source[firstEltID];
        source[firstEltID] = null;
        firstEltID = (firstEltID + 1) % capacity;
        size--;
        return res;
    }

    @Override
    public void addLast(Object elt) {
        if (size == capacity)
            throw new DequeOverflowException();
        int index = (firstEltID + size++) % capacity;
        source[index] = elt;
    }

    @Override
    public T getLast() {
        if (size == 0)
            throw new EmptyDequeException();
        int lastIndex = (firstEltID + size - 1) % capacity;
        return (T) source[lastIndex];
    }

    @Override
    public T removeLast() {
        if (size == 0)
            throw new EmptyDequeException();
        int index = (firstEltID + --size) % capacity;
        T res = (T) source[index];
        source[index] = null;
        return res;
    }

    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = removeFirst();
        }
        for (int i = 0; i < res.length; i++) {
            addLast(res[i]);
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ForwardIterator<T>(this);
    }

    private static class ForwardIterator<T> implements Iterator<T> {
        T[] source;
        int currentIndex;

        public ForwardIterator(OurDeque<T> list) {
            this.source = list.toArray();
        }

        @Override
        public boolean hasNext() {
            return currentIndex < source.length;
        }

        @Override
        public T next() {
            if (currentIndex >= source.length)
                throw new IndexOutOfBoundsException();
            return (T) source[currentIndex++];
        }
    }
}
