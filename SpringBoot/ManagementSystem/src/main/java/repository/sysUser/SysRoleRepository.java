package repository.sysUser;

import entity.sysuser.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:09
 * {@code @Description:} ManagementSystem TODO
 */
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    SysRole findByRole(String name);
}