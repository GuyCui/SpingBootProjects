package repository.sysUser;

import entity.sysuser.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:10
 * {@code @Description:} ManagementSystem TODO
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Long> {
    SysPermission findById(long id);
}