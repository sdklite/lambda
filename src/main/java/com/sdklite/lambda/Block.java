package com.sdklite.lambda;

/**
 * Represents a code block with exception throwing
 * 
 * @author johnsonlee
 *
 * @param <E>
 *            The type of exception
 * 
 * @see Procedure
 */
@FunctionalInterface
public interface Block<E extends Throwable> {

    void invoke() throws E;

}
