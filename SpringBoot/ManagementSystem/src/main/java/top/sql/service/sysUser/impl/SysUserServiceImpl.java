package top.sql.service.sysUser.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.sql.entity.sysuser.SysUser;
import top.sql.repository.sysUser.SysUserRepository;
import top.sql.service.sysUser.SysUserService;

import javax.annotation.Resource;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 23:04
 * {@code @Description:} ManagementSystem TODO
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserRepository sysUserRepository;
    
    /**
     * 保存
     */
    @Override
    public void save(SysUser adminUser) {
        sysUserRepository.save(adminUser);
    }
    
    /**
     * 用户数据分页处理
     */
    @Override
    public Page<SysUser> pageByAdminUser(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return sysUserRepository.findAll(pageable);
    }
    
}