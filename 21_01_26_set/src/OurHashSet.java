import map.OurHashMap;


import java.util.Iterator;

public class OurHashSet<T> implements OurSet<T> {

    private OurHashMap<T, Object> source;
    private final Object stubValue = new Object();

    public OurHashSet() {
        this.source = new OurHashMap<>();
    }

    @Override
    public boolean add(T elt) {
        return source.put(elt, stubValue) == null;
    }

    @Override
    public boolean remove(T elt) {
        return source.remove(elt) != null;
    }

    @Override
    public boolean contains(T elt) {
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public void addAll(OurSet<T> another) {
        for (T elt : another) {
            if (!this.contains(elt))
                this.add(elt);
        }
    }

    @Override
    public void retainAll(OurSet<T> another) {
        for (T elt : this) {
            if (!another.contains(elt))
                remove(elt);
        }
    }

    @Override
    public void removeAll(OurSet<T> another) {
        for (T elt : this) {
            if (another.contains(elt))
                remove(elt);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return source.iterator();
    }
}
