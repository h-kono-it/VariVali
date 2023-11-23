package jp.hk;

import jp.hk.vari.VariValidateResult;
import jp.hk.vari.VariValidatorFactory;

public class Main {
  public static void main(String[] args) {

    VariValidateResult result = new VariValidatorFactory().createValidator("hello").validIsNotEmpty().getResult();
    System.out.println(result.isValid()); // true

    VariValidateResult result1 = new VariValidatorFactory().createValidator("").validIsNotEmpty().getResult();
    System.out.println(result1.isValid()); // false
    System.out.println(result1.messages()); // [対象が空です]
  }
}
