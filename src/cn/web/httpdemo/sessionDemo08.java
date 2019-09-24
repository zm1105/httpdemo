package cn.web.httpdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo08")
public class sessionDemo08 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用Session获取数据
        HttpSession Hs = request.getSession();
        Cookie cookie = new Cookie("JESSIONID",Hs.getId());
        cookie.setMaxAge(60*60);
        Object msg = Hs.getAttribute("msg");
        System.out.println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
