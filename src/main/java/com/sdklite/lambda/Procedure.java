package com.sdklite.lambda;

/**
 * Represents a code block which has result
 * 
 * @author johnsonlee
 *
 * @param <R>
 *            The type of result
 * @param <E>
 *            The type of exception
 * 
 * @see Block
 */
@FunctionalInterface
public interface Procedure<R, E extends Throwable> {

    R invoke() throws E;

}
