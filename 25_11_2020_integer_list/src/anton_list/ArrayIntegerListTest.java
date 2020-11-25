package anton_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest {
    ArrayIntegerList arrIntList = new ArrayIntegerList();

    @Test
    public void testAddLast_0xAdd_0() {
        assertEquals(0, arrIntList.size());
    }

    @Test
    public void testAddLast_1xAdd_1() {
        arrIntList.addLast(5);
        assertEquals(5, arrIntList.get(arrIntList.size() - 1));
    }

    @Test
    public void testAddLast_16xAdd_16() {
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(5, arrIntList.get(arrIntList.size() - 1));
        arrIntList.addLast(9);
        assertEquals(9, arrIntList.get(arrIntList.size() - 1));
    }

    @Test
    public void testIncreaseCapacity_17xAdd_32() {
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(16, arrIntList.source.length);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(32, arrIntList.source.length);
    }


    @Test
    void testGet_5_5() {
        arrIntList.addLast(5);
        assertEquals(5, arrIntList.get(1));
    }

    @Test
    void testGet_9_9() {
        arrIntList.addLast(5);
        arrIntList.addLast(9);
        assertEquals(9, arrIntList.get(2));
    }

    @Test
    void testSet_6_6() {
        arrIntList.addLast(5);
        arrIntList.addLast(9);
        arrIntList.addLast(5);
        arrIntList.addLast(9);
        arrIntList.set(3, 6);
        assertEquals(6, arrIntList.get(3));
    }

    @Test
    void testRemoveById_6xAdd1xRemove3_4() {
        arrIntList.addLast(1);
        arrIntList.addLast(2);
        arrIntList.addLast(3);
        arrIntList.addLast(4);
        arrIntList.addLast(5);
        arrIntList.addLast(6);
        assertEquals(4, arrIntList.removeById(3));
        assertEquals(5, arrIntList.size());
    }

    @Test
    void testSize_10xAdd_10() {
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(4, arrIntList.size());
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(8, arrIntList.size());
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(10, arrIntList.size());
    }

    @Test
    void testClear_1xAdd1xClear_0() {
        arrIntList.addLast(5);
        arrIntList.clear();
        assertEquals(0, arrIntList.size());
        assertEquals(16, arrIntList.source.length);
    }

    @Test
    void testClear_17xAdd1xClear_0() {
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        arrIntList.addLast(5);
        assertEquals(32, arrIntList.source.length);
        arrIntList.clear();
        assertEquals(0, arrIntList.size());
        assertEquals(16, arrIntList.source.length);
    }

    @Test
    void testClear_1xAdd1xClear1xAdd_1() {
        arrIntList.addLast(5);
        arrIntList.clear();
        arrIntList.addLast(5);
        assertEquals(1, arrIntList.size());
    }
}