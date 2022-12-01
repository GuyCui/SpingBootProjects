package top.sql.rabc;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/1 20:13
 * {@code @Description:} ManagementSystem TODO
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}