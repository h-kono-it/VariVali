package jp.hk.vari;

import java.util.function.BiFunction;

@FunctionalInterface
public interface VariValidateFunction extends BiFunction<Object, Object[], Boolean> {
}
