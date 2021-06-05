import cn.zhangle.dao.impl.UserDaoImpl;
import cn.zhangle.domain.User;
import cn.zhangle.service.impl.UserServiceImpl;
import org.junit.Test;
import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2020/12/16 15:46
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */

public class test {
    @Test
    public void testFindAllDao(){
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
    @Test
    public void testFindIdDao(){
        UserDaoImpl userDao = new UserDaoImpl();
        User byId = userDao.findById(5);
        System.out.println(byId);
    }
    @Test
    public void testDelDao(){
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.delete(6);
    }
    @Test
    public void testcheckNameDao(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.checkUserName("admin");
        System.out.println(user);
    }
}
