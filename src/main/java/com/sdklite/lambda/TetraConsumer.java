package com.sdklite.lambda;

import java.util.Objects;

/**
 * Represents an operation that accepts four input arguments and returns no
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
 * @param <D>
 *            the type of the fourth argument to the operation
 */
@FunctionalInterface
public interface TetraConsumer<A, B, C, D> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param a
     *            the first input argument
     * @param b
     *            the second input argument
     * @param c
     *            the third input argument
     * @param d
     *            the fourth input argument
     */
    void accept(final A a, final B b, final C c, final D d);

    default TetraConsumer<A, B, C, D> andThen(final TetraConsumer<? super A, ? super B, ? super C, ? super D> after) {
        Objects.requireNonNull(after);

        return (a, b, c, d) -> {
            accept(a, b, c, d);
            after.accept(a, b, c, d);
        };
    }
}
