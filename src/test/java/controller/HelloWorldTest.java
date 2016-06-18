package controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void helloWorld() throws Exception {
        assertEquals("Hello World", HelloWorld.helloWorld());
    }
}
