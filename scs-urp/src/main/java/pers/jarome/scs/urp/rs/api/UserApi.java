package pers.jarome.scs.urp.rs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.jarome.scs.urp.core.model.User;
import pers.jarome.scs.urp.core.service.UserService;

import java.sql.Date;
import java.util.UUID;

@RestController
public class UserApi {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @GetMapping(value = "/addUser")
    public User addUser(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setSalt("test");
        userService.addUser(user);
        return user;
    }
}
