import java.util.stream.Stream;
import java.util.PriorityQueue;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueueTest {
    static Stream<Arguments> streamIntArrayProvider() {
        return Stream.of(
                arguments(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                arguments(new int[]{-3, -1, -2, 5}, new int[]{-3, -2, -1, 5}),
                arguments(new int[]{3, -2, -5, -1, 2}, new int[]{-5, -2, -1, 2, 3}),
                arguments(new int[]{-3, 1, 11, 0, 9, 3}, new int[]{-3, 0, 1, 3, 9, 11}),
                arguments(new int[]{3, 7, 2, -1, -1}, new int[]{-2, -1, 2, 3, 7})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument={0},{1}")
    @MethodSource("streamIntArrayProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        //TODO random array add to PriorityQueue
        for (int i = 0; i < random_array.length; i++) {
            test.add(random_array[i]);
        }
        //TODO get PriorityQueue result
        for (int i1 = 0; i1 < correct_array.length; i1++) {
            s= test.poll();
            result[i1] = s;
        }
        assertArrayEquals(correct_array, result);
    }
    @Test
    public void whenExceptionThrown_thenOfferEisNull() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> priorityqueue = new PriorityQueue<Integer>();
            priorityqueue.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_thenAddEisNull() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> priorityqueue = new PriorityQueue<Integer>();
            priorityqueue.add(null);
        });
    }
    @Test
    public void whenExceptionThrown_thentoArrayEisNull() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> priorityqueue = new PriorityQueue<Integer>();
            Integer[] arr1 = null;
            priorityqueue.toArray(arr1);
        });
    }
}
