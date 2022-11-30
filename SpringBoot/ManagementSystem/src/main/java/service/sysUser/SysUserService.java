package service.sysUser;

import entity.sysuser.SysUser;
import org.springframework.data.domain.Page;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 22:59
 * {@code @Description:} ManagementSystem TODO
 */
public interface SysUserService {
    /**
     * 保存用户
     */
    void save(SysUser adminUser);
    
    /**
     * 对用户数据进行分页
     */
    Page<SysUser> pageByAdminUser(Integer page, Integer size);
}