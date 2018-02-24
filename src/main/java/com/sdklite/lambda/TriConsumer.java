package com.sdklite.lambda;

import java.util.Objects;

/**
 * Represents an operation that accepts three input arguments and returns no
 * result.
 *
 * @author johnsonlee
 *
 * @param <A>
 *            the type of the first argument to the operation
 * @param <B>
 *            the type of the second argument to the operation
 * @param <C>
 *            the type of the third argument to the operation
 */
@FunctionalInterface
public interface TriConsumer<A, B, C> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param a
     *            the first input argument
     * @param b
     *            the second input argument
     * @param c
     *            the third input argument
     */
    void accept(final A a, final B b, final C c);

    default TriConsumer<A, B, C> andThen(final TriConsumer<? super A, ? super B, ? super C> after) {
        Objects.requireNonNull(after);

        return (a, b, c) -> {
            accept(a, b, c);
            after.accept(a, b, c);
        };
    }

}
