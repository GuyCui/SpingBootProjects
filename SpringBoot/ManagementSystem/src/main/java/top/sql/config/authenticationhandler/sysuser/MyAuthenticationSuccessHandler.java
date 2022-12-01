package top.sql.config.authenticationhandler.sysuser;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/1 20:05
 * {@code @Description:} ManagementSystem 用户名和密码正确执行
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            httpServletRequest.getSession().setAttribute("userDetail", user);
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.write("{\"status\":\"ok\",\"message\":\"登录成功\"}");
            out.flush();
            out.close();
        }
        
    }
}