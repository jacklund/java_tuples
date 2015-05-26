package geekheads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import geekheads.tuples.Triple;
import geekheads.tuples.Tuple;

import static org.junit.Assert.assertEquals;

public class TripleTest {

  @Test
  public void testAsFunction() {
    Triple<Integer, String, Double> mono = Tuple.of(1, "foo", 3.14);
    Object[] values = Arrays.stream(new int[]{0, 1, 2})
      .mapToObj(mono)
      .filter(opt -> opt.isPresent())
      .map(opt -> opt.get())
      .toArray();
    assertEquals(3, values.length);
    assertEquals(1, values[0]);
    assertEquals("foo", values[1]);
    assertEquals(3.14, values[2]);
  }

  @Test
  public void testAsComparable() {
    List<Triple<Integer, String, Double>> list = new ArrayList<>();
    list.add(Tuple.of(3, "foo", 3.14));
    list.add(Tuple.of(2, "bar", 4.2));
    list.add(Tuple.of(2, "baz", 1.5));
    Collections.sort(list);
    assertEquals(2, (int) list.get(0).first);
    assertEquals("bar", (String) list.get(0).second);
    assertEquals(4.2, (double) list.get(0).third, 0.01);
    assertEquals(2, (int) list.get(1).first);
    assertEquals("baz", (String) list.get(1).second);
    assertEquals(1.5, (double) list.get(1).third, 0.01);
    assertEquals(3, (int) list.get(2).first);
    assertEquals("foo", (String) list.get(2).second);
    assertEquals(3.14, (double) list.get(2).third, 0.01);
  }
}
