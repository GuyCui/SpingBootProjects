package top.sql.repository.sysUser;

import org.springframework.data.jpa.repository.JpaRepository;
import top.sql.entity.sysuser.SysRole;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:09
 * {@code @Description:} ManagementSystem TODO
 */
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    SysRole findByRole(String name);
}