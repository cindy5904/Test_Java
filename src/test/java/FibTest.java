import org.example.Fib;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class FibTest {
    private Fib fib;

    @Test
    public void When_Range1_Result_No_Empty() {
        fib = new Fib(1);
        List<Integer> result = fib.getFibSeries();

        Assert.assertFalse(result.isEmpty());

    }

    @Test
    public void When_List_Containt_0() {
        fib =new Fib(1);
        List<Integer> result = fib.getFibSeries();

        Assert. assertEquals(List.of(0), result);
    }

    @Test
    public void When_Range_6_Result_Contains_3() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertTrue(result.contains(3));
    }

    @Test
    public void When_Range_6_Result_Contains_6_Element () {
        fib = new Fib(6);
        List <Integer> result = fib.getFibSeries();
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void When_Range_6_Result_Except_4() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertFalse(result.contains(4));
    }

    @Test
    public void When_Range_6_Result_List_Contains_0_1_1_2_3_5 () {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertEquals(List.of(0, 1, 1, 2, 3, 5), result);

    }

    @Test
    public void When_Range_6_Sorted_Ascending() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        boolean isSorted = result.stream()
                .sorted()
                .toList()
                .equals(result);
        Assert.assertTrue(isSorted);

    }


}
