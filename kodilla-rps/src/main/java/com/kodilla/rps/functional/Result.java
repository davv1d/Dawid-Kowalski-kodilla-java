package com.kodilla.rps.functional;

import com.kodilla.rps.elements.ElementCreateException;

import java.io.Serializable;
import java.util.function.BiFunction;

public abstract class Result<V> implements Serializable {
    private Result() {}

    public abstract V getOrElse(V defaultValue);

    public abstract <U, T> Result<U> map(BiFunction<V, T, U> f, T t);

    private static class Failure<V> extends Result<V> {
        private final String message;

        private Failure(String message) {
            this.message = message;
        }

        @Override
        public V getOrElse(V defaultValue) {
            return defaultValue;
        }

        @Override
        public <U, T> Result<U> map(BiFunction<V, T, U> f, T t) {
            return failure(message);
        }
    }

    private static class Success<V> extends Result<V> {
        private final V value;

        private Success(V value) {
            super();
            this.value = value;
        }

        @Override
        public V getOrElse(V defaultValue) {
            return value;
        }

        @Override
        public <U, T> Result<U> map(BiFunction<V, T, U> f, T t) {
            try {
                return success(f.apply(value, t));
            } catch (Exception e) {
                return failure(e.getMessage());
            }
        }
    }

    public static <V> Result<V> failure(String message) {
        return new Failure<>(message);
    }

    public static <V> Result<V> success(V value) {
        return new Success<>(value);
    }
}
