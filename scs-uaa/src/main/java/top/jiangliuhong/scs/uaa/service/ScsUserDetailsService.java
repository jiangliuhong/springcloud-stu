package top.jiangliuhong.scs.uaa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import top.jiangliuhong.scs.uaa.bean.ScsUser;

/**
 * UserDetailsServiceImpl <br/>
 *
 * @author jiangliuhong
 * @version 1.0.0
 * @date 2020/10/8 11:01 上午
 */
@Slf4j
@Service
public class ScsUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("usernameis:" + username);
        // 查询数据库操作
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("the user is not found");
        } else {
            // 用户角色也应在数据库中获取
            String role = "ROLE_ADMIN";
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));
            // 线上环境应该通过用户名查询数据库获取加密后的密码
            String password = passwordEncoder.encode("123456");
            // 返回默认的 User
            // return new org.springframework.security.core.userdetails.User(username,password, authorities);

            // 返回自定义的 KiteUserDetails
            ScsUser user = new ScsUser(username, password, authorities);
            user.setCorp("xxxx");
            user.setDept("xxxzaa");
            return user;
        }
    }
}
