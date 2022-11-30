package controller.sysuser;

import entity.sysuser.SysRole;
import entity.sysuser.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import repository.sysUser.SysRoleRepository;
import repository.sysUser.SysUserRepository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 22:44
 * {@code @Description:} ManagementSystem TODO
 */
@Controller
@RequestMapping("admin")
public class SysUserController {
    @Resource
    private SysUserRepository adminUserRepository;
    
    @Resource
    private SysRoleRepository sysRoleRepository;
    
    @RequestMapping("/user/add")
    public String toAddUser(Model model) {
        List<SysRole> adminrole = sysRoleRepository.findAll();
        model.addAttribute("adminrole", adminrole);
        return "admin/user/add";
    }
    
    @PostMapping("/user")
    public String addUser(String name, String password, String role) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(password);
        SysUser user = new SysUser(name, encodePassword);
        List<SysRole> roles = new ArrayList<>();
        SysRole role1 = sysRoleRepository.findByRole(role);
        roles.add(role1);
        user.setRoles(roles);
        adminUserRepository.save(user);
        return "redirect:/admin/";
    }
    
    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm() {
        Set<String> urls = new HashSet<>();
        System.out.println(urls.toString());
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    
    @RequestMapping("/")
    public String index(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return "admin/index";
    }
    
    
    /**
     * 删除
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable("id") long id) {
        adminUserRepository.deleteById(id);
        return "redirect:";
    }
    
    @RequestMapping("/user/edit")
    public ModelAndView useredit(long id) {
        SysUser model = adminUserRepository.findById(id);
        ModelAndView mav = new ModelAndView("admin/user/edit");
        mav.addObject("adminuser", model);
        return mav;
    }
    
    /**
     * 编辑操作
     */
    @RequestMapping("/user/update")
    public String userUpdate(SysUser model) {
        adminUserRepository.save(model);
        
        return "redirect:";
    }
    
    @RequestMapping("/user/{id}")
    public ModelAndView testPathVariable(@PathVariable("id") Integer id) {
        SysUser adminUser = adminUserRepository.findById(id);
        ModelAndView mav = new ModelAndView("sys/user/show");
        mav.addObject("adminUser", adminUser);
        return mav;
    }
    
    
    @RequestMapping(value = "/system/user/{id}", method = RequestMethod.PUT)
    public String categoryUpdates(SysUser model) {
        String preUrl = "/";
        adminUserRepository.save(model);
        return "redirect:";
        
    }
    
    @GetMapping("/user")
    public ModelAndView userList(
            @RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, limit, sort);
        
        Page<SysUser> page = adminUserRepository.findAll(pageable);
        
        ModelAndView mav = new ModelAndView("admin/user/list");
        mav.addObject("page", page);
        return mav;
    }
    
}