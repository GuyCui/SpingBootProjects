package repository.sysUser;

import entity.sysuser.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:07
 * {@code @Description:} ManagementSystem TODO
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByName(String name);
    
    SysUser findById(long id);
}