import beans.BeanDefinition;
import beans.BeanReference;
import beans.PropertyValue;
import beans.PropertyValues;
import factory.DefaultListableBeanFactory;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Arrays;
import java.util.Date;
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

    @Test
    public void testBeanDefinition() {
        DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
        lbf.registerBeanDefinition("demo", new BeanDefinition(Demo.class));

        String[] beanDefinitionNames = lbf.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

        System.out.println(lbf.getBeanDefinitionCount());

        Demo demo = (Demo) lbf.getBean("demo");
        demo.test();
    }

    @Test
    public void testBeanField() {
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "张三"));
        propertyValues.addPropertyValue(new PropertyValue("age", 123));
        propertyValues.addPropertyValue(new PropertyValue("birthday", new Date()));

        DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
        lbf.registerBeanDefinition("student", new BeanDefinition(Student.class, propertyValues));
        Student studentOfContainer = (Student) lbf.getBean("student");
        System.out.println(studentOfContainer.getName());
        System.out.println(studentOfContainer.getBirthday());
        System.out.println(studentOfContainer.getAge());
    }

    @Test
    public void testReference() {

        DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
        PropertyValues propertyValuesForSchool = new PropertyValues();
        propertyValuesForSchool.addPropertyValue(new PropertyValue("name", "付张小学"));
        lbf.registerBeanDefinition("school", new BeanDefinition(School.class, propertyValuesForSchool));


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "张三"));
        propertyValues.addPropertyValue(new PropertyValue("age", 123));
        propertyValues.addPropertyValue(new PropertyValue("birthday", new Date()));
        propertyValues.addPropertyValue(new PropertyValue("school", new BeanReference("school")));


        lbf.registerBeanDefinition("student", new BeanDefinition(Student.class, propertyValues));
        Student studentOfContainer = (Student) lbf.getBean("student");
        System.out.println(studentOfContainer.getName());
        System.out.println(studentOfContainer.getBirthday());
        System.out.println(studentOfContainer.getAge());

        School schoolOfStudent = studentOfContainer.getSchool();
        System.out.println(schoolOfStudent.getName());
    }
}
