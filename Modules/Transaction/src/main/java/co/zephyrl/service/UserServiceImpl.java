package co.zephyrl.service;

import co.zephyrl.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;

import javax.xml.transform.sax.TemplatesHandler;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    // 数据层注入
    @Autowired
    private UserDao userDao;
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 事务管理模板注入
    @Autowired
    private TransactionTemplate template;
//    public void setTemplate(TransactionTemplate template) {
//        this.template = template;
//    }

    // 提取方法简化代码封装防止灰线
    private void transfer(String aname, String bname, int money) {
        // 参数校验
        if (StringUtils.isEmpty(aname) || StringUtils.isEmpty(bname) || money <= 0) {
            System.out.println("参数状态非法");
        }
        // A扣钱
        int i = userDao.updateByUnameAndMoneySub(aname, money);
        // 人为异常
//        int a = 1 / 0;
        // B加钱
        int i1 = userDao.updateByUnameAndMoneyAdd(bname, money);

        if (i > 0 && i1 > 0) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
    }

    // 基础银行转账案例正确代码
    @Override
    public void aTob(String aName, String bName, int money) {
        transfer(aName, bName, money);
    }

    // 声明式事务处理 银行转账案例
    @Override
    public void aTob2(final String aName, final String bName, final int money) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                transfer(aName, bName, money);
            }
        });
    }

    // 声明式事务处理：注解方式


    @Override
    public void aTob3(String aname, String bname, int money) {
        transfer(aname, bname, money);
    }
}
