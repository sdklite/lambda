package com.sdklite.lambda;

import java.util.Objects;
import java.util.function.Function;

/**
 * Represents a function that accepts trhee arguments and produces a result.
 *
 * @param <A>
 *            the type of the first argument to the operation
 * @param <B>
 *            the type of the second argument to the operation
 * @param <C>
 *            the type of the third argument to the operation
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface TriFunction<A, B, C, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param a
     *            the first function argument
     * @param b
     *            the second function argument
     * @param c
     *            the second function argument
     * @return the function result
     */
    R apply(A a, B b, C c);

    default TriFunction<A, B, C, R> andThen(final Function<? super R, ? extends R> after) {
        Objects.requireNonNull(after);

        return (a, b, c) -> after.apply(apply(a, b, c));
    }
}
