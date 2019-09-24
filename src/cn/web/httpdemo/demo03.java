package cn.web.httpdemo;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/demo03")
public class demo03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //创建对象，内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片   背景色
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, width, height);

        //边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        //验证码
        String str = "ABCDEFGHIJKMNPQRSTUVWXYbcdefghjkmnpqrstuvwxy3456789";
        Random random = new Random();
        for (int j = 1; j <= 4; j++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);//随机字符j
            graphics.drawString(c + "", width / 5 * j, height / 2);
        }
        //将图片输出至页面
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
}
