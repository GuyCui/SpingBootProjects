package top.sql.entity.sysuser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;


/**
 * 角色实体
 *
 * @author CMZ
 * @date 2022/11/30
 */
@Data
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    /**
     *  编号
     */ private Integer id;
    private String cnname;
    /**
     * 角色标识程序中判断使用,如"sys",这个是唯一的
     */
    private String role;
    /**
     * 角色描述,UI界面显示使用
     */
    private String description;
    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;
    
    /**
     * 角色-权限关系：多对多关系;
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;
    /**
     * 用户-角色关系定义;
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    /**
     * 一个角色对应多个用户
     */ private List<SysUser> userInfos;
}