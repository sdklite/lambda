package com.sdklite.lambda;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TetraFunction<A, B, C, D, R> {
    R apply(A a, B b, C c, D d);

    default TetraFunction<A, B, C, D, R> andThen(final Function<? super R, ? extends R> after) {
        Objects.requireNonNull(after);

        return (a, b, c, d) -> after.apply(apply(a, b, c, d));
    }

}
