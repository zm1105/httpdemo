package cn.web.httpdemo.requst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo04")
public class ServletDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo444444被访问了");
        /*请求转发
        *  1 浏览器地址不改变
        *  2 只能访问当前服务器内部资源中
        *  3  转发是一次请求*/
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletDemo05");
//        requestDispatcher.forward(request,response);
        request.setAttribute("msg","hello");//数据共享
        request.getRequestDispatcher("/ServletDemo05").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
