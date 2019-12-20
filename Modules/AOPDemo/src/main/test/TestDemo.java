import co.zephyrl.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    @Test
    public void demo1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        userDao.find();
        userDao.save();
        userDao.delete();
        userDao.update();
    }
}
