package jp.hk.vari;

public class VariValidatorFactory {

  public VariValidator createValidator(Object target) {
    return new VariValidator(target);
  }
}
