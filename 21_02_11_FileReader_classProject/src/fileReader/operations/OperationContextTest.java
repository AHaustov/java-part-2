package fileReader.operations;

import fileReader.ConfigReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OperationContextTest {


    ConfigReader cr;
    OperationContext oc;
    OperationContext ocMock;


    @BeforeEach
    public void init() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        cr = new ConfigReader("config.props");
        oc = new OperationContext(cr.getOperationPaths());
        ocMock = mock(OperationContext.class);
    }

    @Test
    public void test_getName() {
        assertEquals("lower_case", oc.getOperation("lower_case").getName());
        assertEquals("upper_case", oc.getOperation("upper_case").getName());
        assertEquals("sort", oc.getOperation("sort").getName());
        assertEquals("random", oc.getOperation("random").getName());
        assertEquals("reverse", oc.getOperation("reverse").getName());
        assertNull(oc.getOperation("sorto"));
    }

    @Test
    public void test_sort() {
        when(ocMock.getOperation("sorto")).thenReturn(oc.getOperation("sort"));

        assertEquals("12345", ocMock.getOperation("sorto").operate("54321"));
        assertEquals("annot", ocMock.getOperation("sorto").operate("anton"));
    }

    @Test
    public void test_reverse() {
        when(ocMock.getOperation("ravirs")).thenReturn(oc.getOperation("reverse"));

        String[] tests = {"pop", "sorto", "banana", "orange"};
        String[] expected = {"pop", "otros", "ananab", "egnaro"};

        for (int i = 0; i < tests.length; i++) {
            assertEquals(expected[i], ocMock.getOperation("ravirs").operate(tests[i]));
        }

    }

    @Test
    public void test_random_allChars() {
        when(ocMock.getOperation("rondo")).thenReturn(oc.getOperation("random"));

        String testSubject = "d1weo12hne1wiqjqokjf0dfj2kefodijsgj2o";
        char[] expected = testSubject.toCharArray();
        String afterHandle = ocMock.getOperation("rondo").operate(testSubject);

        for (int i = 0; i < testSubject.length(); i++) {
            assertTrue(afterHandle.contains("" + expected[i]));
        }

    }
}