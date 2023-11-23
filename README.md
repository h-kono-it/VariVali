# Vari-Vali
`Vari-Vali` is Validation Library for Java.  
`Vari-Vali` means `Variable, Validation` and the Japanese word `BARIBARI`, which is a "mimetic word for doing work at a furious pace".

# Features
- Don't use Libraries
- Don't use Exception
- Use `String Templates`(Delivered in Java 23?)

# Usage
```
VariValidateResult result = new VariValidatorFactory().createValidator("hello").validIsNotEmpty().getResult();
System.out.println(result.isValid()); // true

VariValidateResult result1 = new VariValidatorFactory().createValidator("").validIsNotEmpty().getResult();
System.out.println(result1.isValid()); // false
System.out.println(result1.messages()); // [対象が空です]
```

## Validators
- NotEmpty
- Length(WIP)
- Date(WIP)
- DateTime(WIP)
- DateLimit(WIP)
- Number(WIP)
- NumberLimit(WIP)
- Enum(WIP)

... and You can implement Custom Validator.

## Use Custom Validator
You will implement `Validation` class and override `apply` method.  
And You call `valid` method with error message.
### Example: IsNotEmpty Validation
```
private class NotEmpty implements Validation {
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
```
