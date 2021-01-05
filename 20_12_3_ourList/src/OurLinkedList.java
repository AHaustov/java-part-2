import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;


public class OurLinkedList<T> implements OurList<T> {
    Node<T> first;
    Node<T> last;
    int size;

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(null, last, element);
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.element;
    }

    @Override
    public void set(int index, T value) {
        Node<T> node = getNodeByIndex(index);
        node.element = value;
    }

    @Override
    public T removeById(int index) {
        Node<T> needle = getNodeByIndex(index);
        return removeNode(needle);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        first = last = null;
    }

    @Override
    public boolean remove(T obj) {
        Node<T> needle = findByElement(obj);
        if (needle == null)
            return false;

        removeNode(needle);
        return true;
    }

    @Override
    public boolean contains(T obj) {
        return findByElement(obj) != null;
    }

    private Node<T> findByElement(T obj) {
        Node<T> res = first;
        if (obj == null) {
//            for (int i = 0; i < size; i++)
            while (res != null) {
                if (res.element == null)
                    return res;

                res = res.next;
            }
        } else {
            while (res != null) {
                if (obj.equals(res.element))
                    return res;

                res = res.next;
            }
        }

        return null;
    }

    private T removeNode(Node<T> needle) {
        Node<T> before = needle.previous;
        Node<T> after = needle.next;

        if (before != null) {
            before.next = after;
        } else {
            first = after;
        }

        if (after != null) {
            after.previous = before;
        } else {
            last = before;
        }

        //clear the removing element
        needle.previous = needle.next = null;
        T res = needle.element;
        needle.element = null;

        size--;
        return res;
    }

    @Override
    public Iterator<T> forwardIterator() {
        Iterator<T> iterator = new ForwardIterator<>();
        return iterator;
    }

    @Override
    public Iterator<T> backwardIterator() {
        Iterator<T> iterator = new BackwardIterator();
        return iterator;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Object[] copy = new Object[size];

        int i = 0;
        for (T elt : this) {
            copy[i++] = elt;
        }
        this.clear();
        insertionSort(copy, comparator);
        for (Object elt : copy) {
            this.addLast((T) elt);
        }
    }

    public static void insertionSort(Object[] arr, Comparator comparator) {
        for (int i = 1; i < arr.length; i++) {
            Object elt =  arr[i];
            int indexOF = i - 1;
            while (indexOF >= 0 && comparator.compare( arr[indexOF], elt) > 0) {
                arr[indexOF + 1] = arr[indexOF];
                indexOF = indexOF - 1;
            }
            arr[indexOF + 1] = elt;
        }
    }

    private Node getNodeByIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }


    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T element;

        public Node() {
        }

        public Node(Node<T> next, Node<T> previous, T element) {
            this.next = next;
            this.previous = previous;
            this.element = element;
        }
    }

    private class ForwardIterator<T> implements Iterator<T> {
        OurLinkedList.Node<T> currentNode;

        public ForwardIterator() {
            this.currentNode = (Node<T>) first;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();
            T result = currentNode.element;
            currentNode = currentNode.next;
            return result;
        }
    }

    private class BackwardIterator<T> implements Iterator<T> {
        OurLinkedList.Node<T> currentNode;

        public BackwardIterator() {
            this.currentNode = (Node<T>) last;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();
            T result = currentNode.element;
            currentNode = currentNode.previous;
            return result;
        }
    }
}
