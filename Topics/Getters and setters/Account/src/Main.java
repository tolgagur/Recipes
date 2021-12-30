class BaseClass {
    protected int a;
}


class DerivedClass extends BaseClass {
    private int b;

    public int sum() {
        return a + b;
    }
}