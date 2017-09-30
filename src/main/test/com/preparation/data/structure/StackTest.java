package com.preparation.data.structure;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

/**
 * Created by vlados on 9/30/2017.
 */
public class StackTest {
    private Stack<Integer> stack;

    @Before
    public void init() {
        stack = new Stack<>();
    }

    @Test
    public void testAddAndRemoveOneElement() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);

        assertTrue("size expected to be 1", 1 == stack.size());
        assertTrue("expected element to be equal 5", stack.pop().equals(5));
        assertTrue("size expected to be 0", 0 == stack.size());
    }

    @Test
    public void testAddRandomNumberOfElementsToStack() {
        int stackSize = ThreadLocalRandom.current().nextInt(10);
        for (int i = 0; i < stackSize; i++) {
            stack.push(i);
        }

        assertTrue("size expected to be " + stackSize, stackSize == stack.size());


        for (int i = stackSize - 1; i >= 0; i--) {
            assertTrue("expected element to be equal " + i, stack.pop().equals(i));
        }

        assertTrue("size expected to be 0", 0 == stack.size());
    }


    @Test(expected = RuntimeException.class)
    public void testPopExceptionWhenSizeZero() {
        testAddRandomNumberOfElementsToStack();

        stack.pop();
    }

}