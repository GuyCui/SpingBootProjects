package top.sql.repository.sysUser;

import org.springframework.data.jpa.repository.JpaRepository;
import top.sql.entity.sysuser.SysUser;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:07
 * {@code @Description:} ManagementSystem TODO
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByName(String name);
    
    SysUser findById(long id);
}