package hust.soict.dsai.aims.test;

interface Interface3 {
    default void doSomething() {
    System.out.println("Execute in Interface3"); }
}
abstract class Parent {
    public void doSomething() { System.out.println("Execute in Parent");
    }
    public static void test() { System.out.println("test");
    } }
public class Test extends Parent implements Interface3 {
    public static void main(String[] args) {
        Test m = new Test();
        m.doSomething(); // OK
    }
}