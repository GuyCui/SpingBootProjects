package service.sysUser;

import entity.sysuser.SysUser;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import repository.sysUser.SysUserRepository;

import javax.annotation.Resource;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:01
 * {@code @Description:} ManagementSystem TODO
 */
public class SysSecurityService implements UserDetailsService {
    @Resource
    private SysUserRepository sysUserRepository;
    
    /**
     *
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else if (!user.getEnabled()) {
            throw new LockedException("用户被锁定");
        }
        System.out.println(user.getEnabled());
        return user;
    }
}