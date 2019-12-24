package co.zephyrl.service;

import co.zephyrl.dao.UserDao;
import org.springframework.util.StringUtils;

public class UserServiceImpl implements UserService {

    // 基础银行转账案例正确代码
    @Override
    public void aTob(String aname, String bname, int money) {
        UserDao userDao = new UserDao();
        // 参数校验
        if (StringUtils.isEmpty(aname) || StringUtils.isEmpty(bname) || money <= 0) {
            System.out.println("参数状态非法");
        }
        // A扣钱
        int i = userDao.updateByUnameAndMoneySub(aname, money);
        // 人为异常
        int a = 1 / 0;
        // B加钱
        int i1 = userDao.updateByUnameAndMoneyAdd(bname, money);

        if (i > 0 && i1 > 0) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
    }
}
