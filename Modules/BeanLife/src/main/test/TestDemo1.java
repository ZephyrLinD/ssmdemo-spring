import co.zephyrl.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        People people = ac.getBean("people", People.class);
        People people2 = ac.getBean("people", People.class);
        System.out.println(people);
        System.out.println(people2);
        System.out.println(people == people2);
    }

}
