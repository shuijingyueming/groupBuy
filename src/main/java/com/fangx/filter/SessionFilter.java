package com.fangx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionFilter implements Filter {
    String NO_LOGIN = "您还未登录";
    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/toLogin"};


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);

        if (!needFilter) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if(uri.indexOf("/xhsgetticket")>0){
            filterChain.doFilter(request, response);
        }else {
            if (session != null && session.getAttribute("user") != null) {
                filterChain.doFilter(request, response);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write(this.NO_LOGIN);
                } else {
                    response.setContentType("text/html;charset=utf-8");
                    PrintWriter out = response.getWriter();

                    out.println("<html>");
                    out.println("<script type='text/javascript' src='/assets/js/cookie.js'></script>");
                    out.println("<script>");
                    out.println("deleteCookie('tab_list');deleteCookie('left_menu_father');deleteCookie('left_menu_son');");
                    out.println("window.parent.location='/toLogin?error=" + this.NO_LOGIN + "';");
                    out.println("</script>");
                    out.println("</html>");
                    out.flush();
                }
                return;
            }
        }
    }

    /**
     * @Author: xxxxx
     * @Description: 是否需要过滤
     */
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}