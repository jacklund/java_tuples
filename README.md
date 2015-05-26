# Java Tuples
An implementation of [tuples](http://openbookproject.net/thinkcs/python/english3e/tuples.html) for Java 8.
Inspired from [this blog post](http://www.alexecollins.com/java-tuples/).

To create a tuple:

```java
Tuple.of(10, "foo")
```

creates a 2-tuple (a "Duple") containing an int and a String. Similarly,

```java
Tuple.of(3.1415, new ArrayList<String>(), "bar")
```

creates a 3-tuple (a "Triple") containing a float, an `ArrayList`, and a String.

Tuples are immutable (well, as immutable as you can get in Java). You can access the first element
of the tuple as `tuple.first`, the second as `tuple.second`, and so on. I've only implemented up to 3-tuples.

Also, there is a 1-tuple (a "Monople") implementation.

I've broken from Alex's implementation in that I do not have mine implement either `Serializable` or
`Cloneable`, the first because it seems superfluous, and the second because cloning one is really just a matter
of doing this:

```java
Duple<int, String> a = Tuple.of(1, "foo");
Duple<int, String> b = Tuple.of(a.first, a.second);
```

Mostly, I'm trying to avoid the Java trap of adding interfaces just because.

I've implemented `IntFunction` because Tuples _should_ be functions, and `Comparable` so that they can
be valid members of ordered collections.

As functions, tuples take an integer, which is the index into the tuple, and return an `Optional<Object>`,
which contains either the object at that index, if the index is in range, or empty if not.

As a `Comparable`, the tuples are ordered on their first entry, followed by their second, etc.