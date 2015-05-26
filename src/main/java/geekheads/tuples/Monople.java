package geekheads.tuples;

public class Monople<T> implements Tuple<Monople<T>> {
  public final T first;

  public static <V> Monople<V> of(V v) {
    return new Monople<>(v);
  }

  private Monople(T t) {
    this.first = t;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Monople<?> tuple1 = (Monople<?>) o;

    return !(first != null ? !first.equals(tuple1.first) : tuple1.first != null);
  }

  @Override
  public int hashCode() {
    return first != null ? first.hashCode() : 0;
  }

  @Override
  public Object apply(int value) {
    switch (value) {
      case 0:
        return this.first;
      default:
        throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public int size() {
    return 1;
  }
}