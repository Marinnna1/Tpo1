package heapsort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {


    @Test
    @DisplayName("Test empty arrays")
    void testEmpty() {
        assertAll(() -> assertArrayEquals(new int[]{}, HeapSort.sort(new int[]{})));
    }

    @Test
    @DisplayName("Test arrays with zeros")
    void testZeros() {
        assertAll(() -> assertArrayEquals(new int[]{0, 0, 0}, HeapSort.sort(new int[]{0, 0, 0})));
    }


    @Test
    @DisplayName("Test arrays with negative numbers")
    void testNegatives() {
        assertAll(
                () -> assertArrayEquals(new int[]{-4, -3, -2, -1}, HeapSort.sort(new int[]{-4, -3, -2, -1})),
                () -> assertArrayEquals(new int[]{-4, -3, -2, -1}, HeapSort.sort(new int[]{-1, -2, -3, -4})),
                () -> assertArrayEquals(new int[]{-77,-67,-45,-21,-13},HeapSort.sort(new int[]{-45,-21,-67,-13,-77}))
        );
    }


    @Test
    @DisplayName("Test arrays with different numbers (zeros, positive and negative numbers)")
    void testMix() {
        assertAll(
                () -> assertArrayEquals(new int[]{-3, -1, 0, 2, 4}, HeapSort.sort(new int[]{4, -3, 2, -1, 0})),
                () -> assertArrayEquals(new int[]{-4, -3, -2, 0, 1}, HeapSort.sort(new int[]{-4, -3, -2, 1, 0})),
                () -> assertArrayEquals(new int[]{-67, -45, 13, 21, 77},HeapSort.sort(new int[]{77,-67,-45,21,13}))
        );
    }


    @Test
    @DisplayName("PositiveNumbers")
    void positiveNumberTest() {
        assertAll(
                () -> assertArrayEquals(new int[]{1, 2, 3, 4}, HeapSort.sort(new int[]{2, 4, 3, 1})),
                () -> assertArrayEquals(new int[]{1, 2, 3, 4}, HeapSort.sort(new int[]{1, 2, 3, 4})),
                () -> assertArrayEquals(new int[]{13,21,45,67,77},HeapSort.sort(new int[]{45,21,67,13,77}))
        );
    }
}
