package cn.wusx.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebFilter(urlPatterns = { "/TestServlet" , "/hello"}) // 注册拦截器，并添加拦截路径‘/TestServlet’
public class TestFilter implements Filter {

    /**
     * 初始化，只在项目启动的时候执行一次
     */
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("===> TestFilter init");
    }
    /**
     * 用于存放过滤器的业务逻辑实现代码
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(request, response);// 处理请求和响应的分界线
        System.out.println("===> chain.doFilter 后执行处理 response 的相关方法");
        // 在response header里设置一个token
        setToken(response);

    }

    private void setToken(ServletResponse response) {
        HttpServletResponse res = (HttpServletResponse) response;
        String token = UUID.randomUUID().toString();
        res.setHeader("Token", token);
        System.out.println("===> 设置了token：" + token);
    }

    /**
     * 销毁，在项目关闭，Servlet 容器销毁前调用
     */
    @Override
    public void destroy() {
        System.out.println("===> TestFilter destroy");
    }

}
