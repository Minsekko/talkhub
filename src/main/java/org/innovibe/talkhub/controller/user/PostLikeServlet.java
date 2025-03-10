package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.dao.PostDAO;
import org.innovibe.talkhub.model.dao.PostLikeDAO;
import org.innovibe.talkhub.model.vo.PostLike;
import org.innovibe.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/likes-proceed")
public class PostLikeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        PostLikeDAO postLikeDAO = new PostLikeDAO();

        User requester = (User) req.getSession().getAttribute("user");
        List<PostLike> likes = postLikeDAO.findByUserId(requester.getId());

        boolean alreadyLiked = false;
        for (PostLike like : likes) {
            if (like.getPostId() == id) {
                alreadyLiked = true;
            }
        }

        if (!alreadyLiked) {
            PostDAO dao = new PostDAO();
            dao.increaseLikesById(id);
            PostLike log = PostLike.builder().postId(id).userId(requester.getId()).build();
            postLikeDAO.create(log);
        }

        resp.sendRedirect(req.getContextPath() + "/post/view?id=" + id);
    }
}
