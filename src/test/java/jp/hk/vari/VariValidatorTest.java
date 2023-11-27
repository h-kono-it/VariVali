package jp.hk.vari;

import jp.hk.vari.helper.assertion.実行結果;
import org.junit.jupiter.api.Test;

class VariValidatorTest {
  @Test
  public void validIsNotEmpty_AddErrorMessageIfEmptyString() {
    VariValidateResult result = new VariValidatorFactory().createValidator("").validIsNotEmpty("message").getResult();
    実行結果.の(result.isValid()).はfalseです();
    実行結果.の(result.messages().getFirst()).は期待値の("message").と同じです();
  }

  @Test
  public void validIsNotEmpty_AddErrorMessageIfNull() {
    VariValidateResult result = new VariValidatorFactory().createValidator(null).validIsNotEmpty("message").getResult();
    実行結果.の(result.isValid()).はfalseです();
    実行結果.の(result.messages().getFirst()).は期待値の("message").と同じです();
  }
}