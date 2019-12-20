import co.zephyrl.MyRowMapper;
import co.zephyrl.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
+----+------+-----------+-----+---------------------+------+
| id | ages | uname     | psd | cdata               | msg  |
+----+------+-----------+-----+---------------------+------+
|  1 |   10 | zhangxin1 | 123 | 2019-12-19 00:00:00 | NULL |
|  2 |   10 | zhangxin2 | 123 | 2019-12-18 00:00:00 | NULL |
|  3 |   10 | zhangxin3 | 123 | 2019-12-19 00:00:00 | NULL |
|  4 |   10 | zhangxin4 | 123 | 2019-12-19 14:13:51 | NULL |
|  5 |   10 | zx2       | 123 | 2019-12-19 14:14:15 | cs   |
|  6 |   10 | zx0       | 123 | 2019-12-19 14:14:28 | cs   |
|  7 |   10 | zx1       | 123 | 2019-12-19 14:14:52 | cs   |
|  8 |   10 | zx2       | 123 | 2019-12-19 14:15:08 | cs   |
+----+------+-----------+-----+---------------------+------+
*/

public class TestDemo {
    @Test
    public void test1() {
        DriverManagerDataSource dmd = new DriverManagerDataSource();
        dmd.setDriverClassName("com.mysql.jdbc.Driver");
        dmd.setUrl("jdbc:mysql://localhost:3306/LZA_SSM");
        dmd.setUsername("root");
        dmd.setPassword("123456");

        JdbcTemplate jdt = new JdbcTemplate(dmd);

        // 测试（老师带着做的）
        String sql = "select * from users";
        List<Map<String, Object>> li = jdt.queryForList(sql);
        for (Map<String, Object> map : li) {
            for (String s : map.keySet()) {
                System.out.println("列名: " + s + '\t' +map.get(s));
            }
        }
    }

    @Test
    public void test2() {
        // 给Spring处理
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 测试
        String sql = "select * from users";
        List<Map<String, Object>> li = jdt.queryForList(sql);
        for (Map<String, Object> map : li) {
            for (String s : map.keySet()) {
                System.out.println("列名: " + s + '\t' + map.get(s));
            }
        }
    }

    @Test
    public void saveTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String nowDate = sdf.format(d);
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jdt.update("Insert into users values(null, ?, ?, ?, ?, ?)", "22", "jbn", "123", nowDate, "sb");
    }

    @Test
    public void deleteTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jdt.update("Delete from users where id = ?", 12);
    }

    @Test
    public void queryTest1() {
        // 查询操作
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String name = jdt.queryForObject("Select uname from users where id = ?", String.class, "9");
        System.out.println("Name from query is: " + name);

        // 统计查询
        int count = jdt.queryForObject("Select count(*) from users", int.class);
        System.out.println("The count of query is: " + count);
    }



    @Test
    public void  queryTest2_1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 封装在一个对象中
        Users usr = jdt.queryForObject("Select * from users where id = ?", new MyRowMapper(), "10");
        System.out.println(usr);
    }

    @Test
    public void queryTest2_2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 查询多条记录
        List<Users> list = jdt.query("Select * from users", new MyRowMapper());
        for(Users u : list) {
            System.out.println(u);
        }
    }

}
