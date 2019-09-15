package com.kodilla.rps.functional;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Result<V> implements Serializable {
    private Result() {}

    public abstract V getOrElse(V defaultValue);

    public abstract <U> Result<U> map(Function<V, U> f);

    public abstract <U> Result<U> flatMap(Function<V, Result<U>> f);

    public abstract void forEach(Consumer<V> success, Consumer<String> failure);

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
        public <U> Result<U> map(Function<V, U> f) {
            return failure(message);
        }

        @Override
        public <U> Result<U> flatMap(Function<V, Result<U>> f) {
            return failure(message);
        }

        @Override
        public void forEach(Consumer<V> success, Consumer<String> failure) {
            failure.accept(message);
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
        public <U> Result<U> map(Function<V, U> f) {
            try {
                return success(f.apply(value));
            } catch (Exception e) {
                return failure(e.getMessage());
            }
        }

        @Override
        public <U> Result<U> flatMap(Function<V, Result<U>> f) {
            try {
                return f.apply(value);
            } catch (Exception e) {
                return failure(e.getMessage());
            }
        }

        @Override
        public void forEach(Consumer<V> success, Consumer<String> failure) {
            success.accept(value);
        }
    }

    public static <V> Result<V> failure(String message) {
        return new Failure<>(message);
    }

    public static <V> Result<V> success(V value) {
        return new Success<>(value);
    }
}
