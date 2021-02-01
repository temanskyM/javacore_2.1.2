import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    private static long testStartTime;

    @BeforeEach
    void setUp() {
        System.out.println("Starting new test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test complete: " + (System.nanoTime() - testStartTime));
    }

    @Test
    void testFilter_validOutput_inputIsPositive() {
        //given
        List<Integer> inputList = Arrays.asList(7, 6, 5, 4, 3, 2, 1, 0);
        //when
        List<Integer> result = Filter.Filter(inputList);
        //then
        assertThat(result, is(not(empty())));
        assertThat(result, everyItem(greaterThan(0)));
        assertThat(result, equalTo(Arrays.asList(6, 4, 2)));
    }

    @Test
    void testFilter_validOutput_inputIsNegative() {
        //given
        List<Integer> inputList = Arrays.asList(-4, -6, -8, -2, 0);
        //when
        List<Integer> result = Filter.Filter(inputList);
        //then
        assertThat(result, is(empty()));
        assertThat(result, equalTo(Arrays.asList()));
    }

    @Test
    void testFilter_validOutput_validOutputIfEmptyInput() {
        //given
        List<Integer> inputList = Arrays.asList();
        //when
        List<Integer> result = Filter.Filter(inputList);
        //then
        assertThat(result, is((empty())));
    }
}