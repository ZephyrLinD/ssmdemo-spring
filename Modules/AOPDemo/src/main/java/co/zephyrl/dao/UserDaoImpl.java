package co.zephyrl.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void find() {
        System.out.println("查找用户");
    }

    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public int delete() {
        System.out.println("删除");
        return 1;
    }
}
