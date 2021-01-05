public interface OurDeque<T> extends Iterable<T> {
    /**
     * The implementations of the interface should be able to work with the last and the first
     * elements efficiently. Namly, add, remove and get.
     * @param < T> of elements.
     */


    /**
     * If the implementation may contain limited amount of elements, than the method throws
     * DequeOverflowException;
     *
     * @param elt
     * @throws DequeOverflowException
     */
    void addFirst(T elt);

    T getFirst();

    T removeFirst();

    void addLast(T elt);

    T getLast();

    T removeLast();

   T[] toArray();

    int size();
}
