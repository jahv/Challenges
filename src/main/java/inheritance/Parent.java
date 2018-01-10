package inheritance;

public class Parent {

    public void process() {
        System.out.println("Processing parent...");
        sayHello();
    }

    protected void sayHello() {
        System.out.println("Hello from parent");
    }
}
