package jp.hk.vari;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariValidateResult {
  VariValidateResult() {
  }

  private Map<String, Object[]> result = new HashMap<>();

  public boolean isValid() {
    return this.result.isEmpty();
  }

  void addErrors(String message, Object[] params) {
    result.put(message, params);
  }

  public List<String> messages() {
    return result.keySet().stream().toList();
  }
}
