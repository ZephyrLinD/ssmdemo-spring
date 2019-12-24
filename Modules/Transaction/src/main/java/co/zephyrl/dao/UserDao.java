package co.zephyrl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 根据用户名扣除相应金额
    public int updateByUnameAndMoneySub(String aname, int money) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "UPDATE bank SET cdata = now(), money = money - ? WHERE uname = ?";
        int linIsSuccessful = jdbcTemplate.update(sql, money, aname);
        return linIsSuccessful;
    }
    // 根据用户名增加金额
    public int updateByUnameAndMoneyAdd(String bname, int money) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "UPDATE bank SET cdata = now(), money = money + ? WHERE uname = ?";
        int linIsSuccessful = jdbcTemplate.update(sql, money, bname);
        return linIsSuccessful;
    }
}
