package liaoxuefeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/7/13 8:36
 **/
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        if (name == null)
            name = "world";
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>Hello, "+ name +"!</h1>");
        pw.flush();
    }
}
