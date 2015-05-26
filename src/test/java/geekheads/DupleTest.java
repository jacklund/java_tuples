package geekheads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import geekheads.tuples.Duple;
import geekheads.tuples.Tuple;

import static org.junit.Assert.assertEquals;

public class DupleTest {

  @Test
  public void testAsFunction() {
    Duple<Integer, String> mono = Tuple.of(1, "foo");
    Object[] values = Arrays.stream(new int[]{0, 1})
      .mapToObj(mono)
      .toArray();
    assertEquals(2, values.length);
    assertEquals(1, values[0]);
    assertEquals("foo", values[1]);
  }

  @Test
  public void testAsComparable() {
    List<Duple<Integer, String>> list = new ArrayList<>();
    list.add(Tuple.of(3, "foo"));
    list.add(Tuple.of(2, "bar"));
    list.add(Tuple.of(2, "baz"));
    Collections.sort(list);
    assertEquals(2, (int) list.get(0).first);
    assertEquals("bar", (String) list.get(0).second);
    assertEquals(2, (int) list.get(1).first);
    assertEquals("baz", (String) list.get(1).second);
    assertEquals(3, (int) list.get(2).first);
    assertEquals("foo", (String) list.get(2).second);
  }
}
