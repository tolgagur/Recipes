class  Pizza {
    public static void main(String[] args) {

        SomeClass someClass= new SomeClass();


        someClass.method1();
        someClass.method3();
    }


}

class SomeClass {

    public  SomeClass(){

    }

    public synchronized void method1() {
        System.out.println("a thread entered method1");
        method2();
        System.out.println("a thread left method1");
    }

    public synchronized void method2() {
        System.out.println("a thread entered method2");
        System.out.println("a thread left method2");
    }

    public synchronized void method3() {
        System.out.println("a thread entered method3");
        System.out.println("a thread left method3");
    }
}