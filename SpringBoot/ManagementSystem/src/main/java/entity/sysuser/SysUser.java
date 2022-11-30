package entity.sysuser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/29 23:46
 * {@code @Description:} ManagementSystem 用户实体表
 */
@Entity
public class SysUser implements UserDetails {
    /**
     * 主键及自动增长
     */
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String password;
    private String cnname;
    private Boolean enabled = Boolean.TRUE;
    
    /**
     * 多对多映射，用户角色
     */
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<SysRole> roles;
    
    public SysUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public SysUser() {
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public String getCnname() {
        return cnname;
    }
    
    public void setCnname(String cnname) {
        this.cnname = cnname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<SysRole> getRoles() {
        return roles;
    }
    
    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
    
    /**
     * 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<SysRole> roles = this.getRoles();
        for (SysRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
    
    /**
     * 获取当前用户实例的password
     */
    @Override
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 获取当前用户实例的name
     */
    @Override
    public String getUsername() {
        return this.name;
    }
    
    /**
     * 帐号是否不过期，false则验证不通过
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    /**
     * 帐号是否不锁定，false则验证不通过
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    /**
     * 凭证是否不过期，false则验证不通过
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    /**
     * 该帐号是否启用，false则验证不通过
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}