import java.util.function.*;


class Operator {

  public static LongBinaryOperator binaryOperator = (x,y) -> {
    if (x-y == 0)
      return x;
    else {
      for (int i = (int) x+1; i <= y; i++) {
        x *= i;
      }
      return x;
    }
  };
}
