import factory.DefaultListableBeanFactory;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Arrays;
import java.util.logging.Logger;

public class DefaultListableBeanFactoryTest {

    public static class Demo {
        void test() {
            System.out.println("test....");
        }
    }


    @Test
    public void testRegisterSingleton() {
        DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
        lbf.registerSingleton("demo", new Demo());
        ((Demo) lbf.getBean("demo")).test();
    }

    @Test
    public void testGetBean() {
        DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
        lbf.registerSingleton("demo", new Demo());
        System.out.println(((Demo) lbf.getBean("demo")).toString());
        System.out.println(((Demo) lbf.getBean("demo")).toString());
        ;
    }

    @Test
    public void testRegisterAlias() {
        DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
        lbf.registerAlias("demo", "demo");
        lbf.registerAlias("demo", "demo_a1");
        lbf.registerAlias("demo", "demo_a2");

        String[] array = lbf.getAliases("demo");
        System.out.println(Arrays.toString(array));
    }

}
