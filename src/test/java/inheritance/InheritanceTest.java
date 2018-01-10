package inheritance;

import org.junit.Test;

public class InheritanceTest {

    @Test
    public void test() {
        Parent son = new Son();
        son.process();
    }
}
