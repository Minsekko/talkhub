package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/post/write")
public class PostWriteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String writerid = user.getId();
        req.getRequestDispatcher("/WEB-INF/views/post/write.jsp").forward(req,resp);
    }
}
