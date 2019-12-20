import co.zephyrl.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {
    @Test
    public void test1() {
        Cat cat = new Cat();
        System.out.println(cat);
    }

    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Cat cat = ac.getBean("cat", Cat.class);
        System.out.println(cat);
    }

}
