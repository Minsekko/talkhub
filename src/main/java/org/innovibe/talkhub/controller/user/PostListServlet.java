package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.dao.PostDAO;
import org.innovibe.talkhub.model.vo.Post;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/list")
public class PostListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        List<Post> PostList =  postDAO.selectAll();

        req.setAttribute("count",PostList.size());
        req.setAttribute("posts",PostList);
        req.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(req,resp);
    }
}
