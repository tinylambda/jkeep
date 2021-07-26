package example.formock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ExampleForMockTest {

    @Test
    void add() {
        List mock = mock(List.class);
        mock.add(1);
        mock.clear();

        verify(mock).add(1);
        verify(mock).clear();
    }

    @Test
    void sub() {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        assertEquals(result, "hello world world");
    }

    @Test
    void mul() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        doThrow(new IOException()).when(outputStream).close();
        assertThrows(IOException.class, outputStream::close);
    }

    @Test
    void divide() {
        List mock = mock(List.class, RETURNS_SMART_NULLS);
        log.info("{}", mock);
        log.info("{}", mock.get(0));
        log.info("{}", mock.toArray().length);
    }

    @Test
    void returnDeepStubs() {
        ExampleForMock exampleForMock = mock(ExampleForMock.class, RETURNS_DEEP_STUBS);
        when(exampleForMock.add(1, 2)).thenReturn(100);
        exampleForMock.add(1, 2);
        assertEquals(100, exampleForMock.add(1, 2));
    }
}