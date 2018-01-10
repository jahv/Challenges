package inheritance;

public class Son extends Parent {

    public void process() {
        System.out.println("Processing son...");
        super.process();
    }

    protected void sayHello() {
        System.out.println("Hello from Son");
    }
}
