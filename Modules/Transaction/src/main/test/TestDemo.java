import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDemo {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "INSERT INTO bank VALUES (6, 18, ?, 123, now(), 100)";
        int linIsSuccessful = jdbcTemplate.update(sql, "Lin");
        System.out.println(linIsSuccessful);
    }
}
