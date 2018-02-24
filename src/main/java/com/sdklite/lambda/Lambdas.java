package com.sdklite.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Utilities for lambda expressions
 * 
 * @author johnsonlee
 *
 */
public abstract class Lambdas {

    /**
     * Wrap consumer lambda which throws exceptions, for example:
     * 
     * <pre>
     * stream.forEach(file -&gt; unchecked(() -&gt; {
     *     FileUtils.readAsString(file);
     * }));
     * </pre>
     * 
     * @param block
     *            the consumer lambda to wrap
     * @param <E>
     *            the type of exception
     */
    public static <E extends Throwable> void unchecked(final Block<? super E> block) {
        try {
            block.invoke();
        } catch (final Error | RuntimeException e) {
            throw e;
        } catch (final Throwable e) {
            throw new UncheckedException(e);
        }
    }

    /**
     * Wrap function lambda which throws exceptions, for example:
     * 
     * <pre>
     * stream.filter(file -&gt; unchecked(() -&gt; {
     *     return FileUtils.readAsString(file).endsWith(".class");
     * }));
     * </pre>
     * 
     * @param procedure
     *            the function lambda to wrap
     * @param <R>
     *            the type of result
     * @param <E>
     *            the type of exception
     * @return the result
     */
    public static <R, E extends Throwable> R unchecked(final Procedure<R, E> procedure) {
        try {
            return procedure.invoke();
        } catch (final Error | RuntimeException e) {
            throw e;
        } catch (final Throwable e) {
            throw new UncheckedException(e);
        }
    }

    public static <T> void $(final T object, final Consumer<? super T> action) {
        action.accept(object);
    }

    public static <T, R> R $(final T object, final Function<T, R> action) {
        return action.apply(object);
    }

    public static <A, B> void $(final A a, final B b, final BiConsumer<A, B> action) {
        action.accept(a, b);
    }

    public static <A, B, C> void $(final A a, final B b, final C c, final TriConsumer<A, B, C> action) {
        action.accept(a, b, c);
    }

    public static <A, B, C, D> void $(final A a, final B b, final C c, final D d, final TetraConsumer<A, B, C, D> action) {
        action.accept(a, b, c, d);
    }

    public static <A, B, R> R $(final A a, final B b, final BiFunction<A, B, R> action) {
        return action.apply(a, b);
    }

    public static <A, B, C, R> R $(final A a, final B b, final C c, final TriFunction<A, B, C, R> action) {
        return action.apply(a, b, c);
    }

    public static <A, B, C, D, R> R $(final A a, final B b, final C c, final D d, final TetraFunction<A, B, C, D, R> action) {
        return action.apply(a, b, c, d);
    }

    private Lambdas() {
    }

}
