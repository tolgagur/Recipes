import java.util.function.BiFunction;

class Clazz {
  int magic;



  public Clazz(int magic) {
    this.magic = magic;
  }

  public static int staticMethod(int a) { return a + a; }

  public int instanceMethod(int b) { return b * magic; }
}
class main(){
  public static void main(String[] args) {
    BiFunction<Clazz, Integer, Integer> instanceMethod = Clazz::instanceMethod;
    instance::staticMethod

    Clazz::instanceMethod;

    Clazz::staticMethod

    instance::instanceMethod

    Clazz::method

    Clazz::new
  }
}