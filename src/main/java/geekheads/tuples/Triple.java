package geekheads.tuples;

public class Triple<T, U, V> implements Tuple<Triple<T, U, V>> {
  public final T first;
  public final U second;
  public final V third;

  public static <A, B, C> Triple<A, B, C> of(A a, B b, C c) {
    return new Triple<>(a, b, c);
  }

  private Triple(T t, U u, V v) {
    this.first = t;
    this.second = u;
    this.third = v;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Triple<?, ?, ?> tuple3 = (Triple<?, ?, ?>) o;

    if (first != null ? !first.equals(tuple3.first) : tuple3.first != null) {
      return false;
    }
    if (second != null ? !second.equals(tuple3.second) : tuple3.second != null) {
      return false;
    }
    return !(third != null ? !third.equals(tuple3.third) : tuple3.third != null);

  }

  @Override
  public int hashCode() {
    int result = first != null ? first.hashCode() : 0;
    result = 31 * result + (second != null ? second.hashCode() : 0);
    result = 31 * result + (third != null ? third.hashCode() : 0);
    return result;
  }

  @Override
  public Object apply(int value) {
    switch (value) {
      case 0:
        return first;
      case 1:
        return second;
      case 2:
        return third;
      default:
        throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public int size() {
    return 3;
  }
}
