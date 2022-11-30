package controller.sysuser;

import entity.sysuser.SysRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.sysUser.SysRoleRepository;

import javax.annotation.Resource;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 22:49
 * {@code @Description:} ManagementSystem TODO
 */
@Controller
@RequestMapping("admin")
public class SysRoleController {
    @Resource
    private SysRoleRepository sysRoleRepository;
    
    @RequestMapping("/role/add")
    public String addRole() {
        return "admin/role/add";
    }
    
    @RequestMapping("/role")
    public String addRole(SysRole model) {
        String role = "ROLE_" + model.getRole();
        model.setRole(role);
        sysRoleRepository.save(model);
        return "redirect:/admin/";
    }
}