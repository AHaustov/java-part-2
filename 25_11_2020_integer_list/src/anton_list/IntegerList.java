package anton_list;

public interface IntegerList {
    /**
     * Adds element to this instance
     *
     * @param element - to add
     */
    void addLast(int element);

    /**
     * returns element by the index
     *
     * @param index - index of searched element
     *              It must be int the range between 0 and size-1
     * @return
     */
    int get(int index);

    /**
     * updates element at index with value
     *
     * @param index - the place to set
     * @param value - the value to set
     */
    void set(int index, int value);

    /**
     * removes element at index and returns deleted index
     *
     * @param index - index to delete
     * @return
     */
    int removeById(int index); //return is element u remove

    /**
     * returns length of given list
     *
     * @return size in int
     */
    int size();

    /**
     * makes 'this' empty
     */
    void clear();
}
