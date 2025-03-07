package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.dao.PostDAO;
import org.innovibe.talkhub.model.vo.Post;

import java.io.IOException;

@WebServlet("/post/view")
public class PostViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int srchid = Integer.parseInt(req.getParameter("id"));

        PostDAO util = new PostDAO();

        Post post = util.selectByCode(srchid);

        if (post != null) {
            req.setAttribute("PostRead",post);
            req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req,resp);
        } else {
            resp.sendRedirect(req.getContextPath()+"/post/list");
        }

    }
}
