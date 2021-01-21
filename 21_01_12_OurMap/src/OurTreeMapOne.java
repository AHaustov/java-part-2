import java.util.Comparator;
import java.util.Iterator;

public class OurTreeMapOne<K, V> implements OurMap<K, V> {


    private static class Node<K, V> {
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        K key;
        V value;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private final Comparator<K> keyComparator;
    private Node<K, V> root;
    private int size;

    public OurTreeMapOne(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    public OurTreeMapOne() {
        this.keyComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                Comparable<K> comparableO1 = (Comparable<K>) o1;
                return comparableO1.compareTo(o2);
            }
        };
    }


    private Node<K, V> findNode(K key) {
        Node<K, V> parentNode = null;
        Node<K, V> currentNode = root;
        while (currentNode != null && !currentNode.key.equals(key)) {
            parentNode = currentNode;
            currentNode = keyComparator.compare(currentNode.key, key) < 0 ? currentNode.right : currentNode.left;
        }
        if (currentNode == null)
            currentNode = new Node<>(null, null, parentNode);
        return currentNode;
    }

    @Override
    public V put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value, null);
            size++;
            return null;
        }
        V temp = null;
        Node<K, V> currentNode = findNode(key);
        if (currentNode.key != null && currentNode.key.equals(key)) {
            temp = currentNode.value;
            currentNode.value = value;
        } else {
            currentNode.key = key;
            currentNode.value = value;
            size++;
            if (keyComparator.compare(currentNode.parent.key, key) < 0) {
                currentNode.parent.right = currentNode;
            } else
                currentNode.parent.left = currentNode;
        }
        return temp;
    }

    @Override
    public V get(K key) {
        return findNode(key).value;
    }

    public V linearRemove(Node<K, V> node) {
        if (node.equals(root)) {
            if (node.right == null) {
                root = node.left;
            } else
                root = node.right;
        }

        size--;
        return node.value;
    }

    @Override
    public V remove(K key) {
        Node<K, V> currentNode = findNode(key);
        if (currentNode.key == null)
            return null;
        V temp = currentNode.value;


        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public Iterator<K> keyIterator() {
        return null;
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }
}
