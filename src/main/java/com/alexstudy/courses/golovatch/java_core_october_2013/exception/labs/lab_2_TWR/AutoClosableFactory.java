package golovatch.courses.exception.labs.lab_2_TWR;

/**
 * Created by Alex on 8/6/2016.
 */
public interface AutoClosableFactory {
    public AutoCloseable create() throws Throwable;
}