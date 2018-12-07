package regular.java.code;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TryCatchTest {

    @Test
    public void exceptionBreaksLoops() {

        List<String> list = Arrays.asList("a", "b", "c");

        for(String letter : list) {
            try {
                System.out.println("\t" + letter);
                if(letter.equals("b")) {
                    throw new RuntimeException("Error");
                }
                System.out.println("\tNEXT\n");
            } catch (Exception e) {
                System.out.println("\tHandle error\n");
            }
        }
        System.out.println("End");
    }
}
