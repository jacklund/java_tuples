package geekheads.tuples;

import java.util.Objects;
import java.util.Optional;
import java.util.function.IntFunction;

public interface Tuple<T extends Tuple> extends IntFunction<Optional<Object>>, Comparable<T> {
  public static <U> Monople<U> of(U u) {
    return Monople.of(u);
  }

  public static <U, V> Duple<U, V> of(U u, V v) {
    return Duple.of(u, v);
  }

  public static <U, V, W> Triple<U, V, W> of(U u, V v, W w) {
    return Triple.of(u, v, w);
  }

  int size();

  @Override
  default int compareTo(T o) {
    Objects.requireNonNull(o);
    if (!getClass().equals(o.getClass())) {
      throw new ClassCastException(o.getClass() + " must equal " + getClass());
    }

    for (int i = 0; i < size(); i++) {
      @SuppressWarnings("unchecked")
      Comparable<Object> l = (Comparable<Object>) apply(i).get();
      @SuppressWarnings("unchecked")
      Object r = ((Optional<Object>) o.apply(i)).get();
      int c = l.compareTo(r);
      if (c != 0) {
        return c;
      }
    }

    return 0;
  }
}
