package geekheads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import geekheads.tuples.Monople;
import geekheads.tuples.Tuple;

import static org.junit.Assert.assertEquals;

public class MonopleTest {

  @Test
  public void testAsFunction() {
    Monople<Integer> mono = Tuple.of(1);
    Object[] values = Arrays.stream(new int[]{0})
      .mapToObj(mono)
      .filter(Optional::isPresent)
      .map(Optional::get)
      .toArray();
    assertEquals(1, values.length);
    assertEquals(1, values[0]);
  }

  @Test
  public void testAsComparable() {
    List<Monople<Integer>> list = new ArrayList<>();
    list.add(Tuple.of(3));
    list.add(Tuple.of(2));
    list.add(Tuple.of(1));
    Collections.sort(list);
    assertEquals(1, (int) list.get(0).first);
    assertEquals(2, (int) list.get(1).first);
    assertEquals(3, (int) list.get(2).first);
  }
}
