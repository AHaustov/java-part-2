import java.util.Iterator;
import java.util.Map;

public class OurHashMap<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;

    private Pair<K, V>[] source;
    private int size;
    private double loadFactor;
    private int capacity;

    public OurHashMap() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    static int hash(Object key) {
        return Math.abs(key.hashCode());
    }

    public OurHashMap(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity)
            resize();

        Pair<K, V> pair = find(key);

        if (pair != null) {
            V res = pair.value;
            pair.value = value;
            return res;
        }
        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair<>(key, value, source[index]);
        source[index] = newPair;
        size++;
        return null;
    }

    private void resize() {
        capacity = capacity * 2;
        Pair<K, V>[] sourceNew = new Pair[capacity];
        for (Pair<K, V> pair : source) {
            Pair<K, V> currentPair = pair;
            while (currentPair != null) {
                int newIndex = hash(currentPair.key) % capacity;
                currentPair.next = sourceNew[newIndex];
                sourceNew[newIndex] = currentPair;
                currentPair = currentPair.next;
            }
        }
        source = sourceNew;
    }

    @Override
    public V get(K key) {
        return find(key).getValue();
    }

    private Pair<K, V> find(K key) {
        int index = hash(key) % capacity;
        Pair<K, V> res = source[index];
        while (res != null) {
            if (key.equals(res.key))
                return res;
            res = res.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];
        if (key.equals(current.key)) {
            source[index] = current.next;
            size--;
            return current.value;
        } else {
            V temp;
            while (current != null) {
                if (current.next.key.equals(key)) {
                    temp = current.next.value;
                    current.next = current.next.next;
                    size--;
                    return temp;
                }
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {

        Iterator<K> it = new KeyIterator<K>();
        return it;
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }

    static public class Pair<K, V> {
        private K key;
        private V value;
        private Pair<K, V> next;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Pair<K, V> getNext() {
            return next;
        }

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    class KeyIterator<K> implements Iterator<K> {
        int position;
        int index;
        Pair<K, V> currentPair;


        public KeyIterator() {
            this.position = 0;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public K next() {
            if (position >= size()) {
                throw new NullPointerException();
            }
            while (currentPair == null) {
                currentPair = (Pair<K, V>) source[index++];
                if (currentPair != null) {
                    position++;
                    return currentPair.key;
                }
            }

            if (currentPair.next != null) {
                position++;
                currentPair = currentPair.next;
                return currentPair.key;
            }
            if (currentPair.next == null) {
                while (source[index] == null && index < capacity) {
                    index++;
                }
                currentPair = (Pair<K, V>) source[index++];
                position++;
                return currentPair.key;
            }

            return null;
        }
    }
}