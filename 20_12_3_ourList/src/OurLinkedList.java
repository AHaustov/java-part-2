import java.util.Iterator;


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
        if (index >= size || index < 0)
            throw new NullPointerException();
        if (size == 1) {
            Node<T> node = first;
            first = last = null;
            size = 0;
            return node.element;
        }
        if (index == 0) {
            Node<T> node = first;
            first = node.next;
            first.previous = null;
            size--;
            return node.element;
        }
        if (index == size - 1) {
            Node<T> node = last;
            last = node.previous;
            last.next = null;
            size--;
            return node.element;
        }
        Node<T> node = getNodeByIndex(index);
        node.previous.next = node.next;
        node.next.previous = node.previous;
        size--;
        return node.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        OurLinkedList.Node<T> node = first;
        while (node.next != null) {
            node = node.next;
            node.previous.next = null;
            node.previous = null;
        }
        size = 0;
        first = last = null;
    }

    @Override
    public boolean remove(T obj) {
        if (obj == null) {
            Node<T> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    removeById(i);
                    return true;
                }
                node = node.next;
            }
            return false;
        }
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.element.equals(obj)) {
                removeById(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean contains(T obj) {
        if (obj == null) {
            Node<T> node = first;
            while (node.next != null) {
                if (node.element == null) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }
        Node<T> node = first;
        while (node.next != null) {
            if (node.element.equals(obj)) {
                return true;
            }
            node = node.next;
        }
        return false;
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

    private Node getNodeByIndex(int index) {
        if (index >= size || index < 0)
            throw new NullPointerException();
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
            return currentNode != last;
        }

        @Override
        public T next() {
            if (currentNode == last)
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
            return currentNode != first;
        }

        @Override
        public T next() {
            if (currentNode == first)
                throw new IndexOutOfBoundsException();
            T result = currentNode.element;
            currentNode = currentNode.previous;
            return result;
        }
    }
}
