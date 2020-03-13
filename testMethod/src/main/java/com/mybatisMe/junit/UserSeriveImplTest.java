package com.mybatisMe.junit;

import com.mybatisMe.common.CommonUtil;
import com.mybatisMe.entities.User;
import com.mybatisMe.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})*/
class UserSeriveImplTest {
    /*@Autowired
    @Qualifier("userService")*/
    UserService userService;

    @Test
    void testCreateUsers() throws Exception {
        userService = (UserService) CommonUtil.getBean("userService");
        List<User> users = new ArrayList<User>();
        for (int i = 5; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(20 + i);
            user.setName("test" + i);
            users.add(user);
        }
        User user = new User();
        user.setId(2);
        user.setName("repeat");
        user.setAge(22);
        users.add(user);

        userService.createUsers(users);
    }

}
