package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.dao.PostDAO;
import org.innovibe.talkhub.model.dao.PostLikeDAO;
import org.innovibe.talkhub.model.vo.Post;
import org.innovibe.talkhub.model.vo.PostLike;
import org.innovibe.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/view")
public class PostViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int srchid = Integer.parseInt(req.getParameter("id"));

        int id = Integer.parseInt(req.getParameter("id"));

        PostDAO util = new PostDAO();

        boolean r = util.increaseViewById(id);
        Post post = util.selectByCode(srchid);

        PostLikeDAO postLikeDAO = new PostLikeDAO();

        User requester = (User) req.getSession().getAttribute("user");
        List<PostLike> likes = postLikeDAO.findByUserId(requester.getId());

        boolean alreadyLiked = false;
        for (PostLike like : likes) {
            if (like.getPostId() == id) {
                alreadyLiked = true;
            }
        }

        if (post != null) {
            req.setAttribute("PostRead",post);
            req.setAttribute("alreadyLiked",alreadyLiked);
            req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req,resp);
        } else {
            resp.sendRedirect(req.getContextPath()+"/post/list");
        }

    }
}
