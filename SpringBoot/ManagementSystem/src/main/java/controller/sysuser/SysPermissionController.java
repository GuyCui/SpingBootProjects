package controller.sysuser;

import entity.sysuser.SysPermission;
import entity.sysuser.SysRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.sysUser.SysPermissionRepository;
import repository.sysUser.SysRoleRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 22:41
 * {@code @Description:} ManagementSystem TODO
 */
@Controller
@RequestMapping("/admin/permission")
public class SysPermissionController {
    @Resource
    private SysPermissionRepository sysPermissionRepository;
    @Resource
    private SysRoleRepository sysRoleRepository;
    
    @RequestMapping("/add")
    public String addPermission(Model model) {
        List<SysRole> sysRole = sysRoleRepository.findAll();
        model.addAttribute("sysRole", sysRole);
        return "admin/permission/add";
    }
    
    @PostMapping("/add")
    public String addPermission(SysPermission sysPermission, String role) {
        List<SysRole> roles = new ArrayList<>();
        SysRole role1 = sysRoleRepository.findByRole(role);
        roles.add(role1);
        sysPermission.setRoles(roles);
        sysPermissionRepository.save(sysPermission);
        return "redirect:/admin/";
    }
}