package fileReader;

import fileReader.operations.IStringOperation;
import fileReader.operations.OperationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsumerTest {

    OperationContext oc;
    IStringOperation operation;
    Consumer consumer;
    ArrayBlockingQueue<String> queue;
    PrintWriter pw;
    LineCounter lc;

    @BeforeEach
    public void init() {
        lc=mock(LineCounter.class);
        oc = mock(OperationContext.class);
        operation = mock(IStringOperation.class);
        queue = mock(ArrayBlockingQueue.class);
        pw = mock(PrintWriter.class);
        consumer = new Consumer(queue, pw, oc,lc);
        consumer = spy(consumer);
    }

    @Test
    public void test_handleRawString_regularCase() {
        when(operation.operate("hello")).thenReturn("HeLlO");
        when(oc.getOperation("beliberda_operation")).thenReturn(operation);

        String res = consumer.handleStr("hello#beliberda_operation");
        assertEquals("HeLlO", res);
    }

    @Test
    public void test_handleRawString_wrongFormatWithOneItem() {
        String res = consumer.handleStr("hello");
        assertEquals("hello" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }

    @Test
    public void test_handleRawString_wrongFormatWithOneItemAndSeparator() {
        String res = consumer.handleStr("hello#");
        assertEquals("hello#" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }

    @Test
    public void test_handleRawString_wrongFormatWithThreeItems() {
        String res = consumer.handleStr("hello#world#pam");
        assertEquals("hello#world#pam" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }

    @Test
    public void test_handleRawString_wrongOperation() { //does not work
        when(oc.getOperation("beliberda_operation")).thenReturn(null);

        String res = consumer.handleStr("hello#beliberda_operation");
        assertEquals("hello#beliberda_operation" + Consumer.SEPARATOR + Consumer.WRONG_OPERATION, res);
    }

}