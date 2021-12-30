
class A {

    public void method() {
        System.out.println("A");
    }
}

class B extends A {

    public void method() {
        System.out.println("B");
    }
}

class C extends B {

}

class D extends C {

    public void method() {
        super.method();
    }
}
class Main {
    public static void main(String[] args) {
        A a = new D();
        a.method();
        Object anObject = new Object();

    }
}