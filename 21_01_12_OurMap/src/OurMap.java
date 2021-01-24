import java.util.Iterator;

public interface OurMap<K, V> extends Iterable<K> {

    public V put(K key, V value);

    public V get(K key);

    public V remove(K key);

    public int size();

    boolean containsKey(K key);

    public Iterator<K> keyIterator();

    public Iterator<V> valueIterator();
}
