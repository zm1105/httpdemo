package FilterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo02 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("fileterdemo02执行了");
        chain.doFilter(req, resp);
        System.out.println("fileterdemo02回来");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
