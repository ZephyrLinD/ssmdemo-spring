import co.zephyrl.service.UserService;
import co.zephyrl.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDemo {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "INSERT INTO bank VALUES (5, 18, ?, 123, now(), 100)";
        int linIsSuccessful = jdbcTemplate.update(sql, "Lin");
        System.out.println(linIsSuccessful);
    }

    @Test
    public void test2() {
        // 准备测试数据
        String aname = "zhangxin1";
        String bname = "Lin";
        int money = 10;
        // 创建业务层对象，使用方法测试
        UserService userService = new UserServiceImpl();
        userService.aTob(aname, bname, money);
    }
}
