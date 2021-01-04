package task4_sgl.filter;

public interface IPredicate<T> {
    boolean apply(final T type);
}