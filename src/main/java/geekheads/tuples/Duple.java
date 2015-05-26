package geekheads.tuples;

import java.util.Optional;

public class Duple<T, U> implements Tuple<Duple<T, U>> {
  public final T first;
  public final U second;

  public static <V, W> Duple<V, W> of(V v, W w) {
    return new Duple<>(v, w);
  }

  private Duple(T t, U u) {
    this.first = t;
    this.second = u;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Duple<?, ?> tuple = (Duple<?, ?>) o;

    if (first != null ? !first.equals(tuple.first) : tuple.first != null) {
      return false;
    }
    return !(second != null ? !second.equals(tuple.second) : tuple.second != null);

  }

  @Override
  public int hashCode() {
    int result = first != null ? first.hashCode() : 0;
    result = 31 * result + (second != null ? second.hashCode() : 0);
    return result;
  }

  @Override
  public Optional<Object> apply(int value) {
    switch (value) {
      case 0:
        return Optional.of(first);
      case 1:
        return Optional.of(second);
      default:
        return Optional.empty();
    }
  }

  @Override
  public int size() {
    return 2;
  }
}
