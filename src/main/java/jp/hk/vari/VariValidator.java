package jp.hk.vari;

import java.util.List;

public class VariValidator {
  private VariValidateResult result = new VariValidateResult();
  private Object target;

  private VariValidator() {
  }

  VariValidator(Object target) {
    this.target = target;
  }

  public VariValidateResult getResult() {
    return this.result;
  }

  public VariValidator valid(VariValidateFunction validation, Object[] params, String message) {
    if (!validation.apply(this.target, params)) {
      result.addErrors(message, params);
    }
    return this;
  }

  public VariValidator valid(VariValidateFunction validation, String message) {
    return this.valid(validation, new Object[]{}, message);
  }

  public VariValidator validIsNotEmpty(String message) {
    return this.valid(new VariValidator.NotEmpty(), message);
  }

  public VariValidator validIsNotEmpty() {
    return this.validIsNotEmpty("対象が空です");
  }


  private class NotEmpty implements VariValidateFunction {
    @Override
    public Boolean apply(Object o, Object[] objects) {
      if (o == null) {
        return false;
      }
      return switch (o) {
        case String s -> !s.isEmpty();
        case List<?> l -> !l.isEmpty();
        default -> false;
      };
    }
  }
}
