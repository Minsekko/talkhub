package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.dao.PostDAO;
import org.innovibe.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/post/write-proceed")
public class PostWriteProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String writerid = req.getParameter("writer_id");
        User user = (User) req.getSession().getAttribute("user");
        String writerId = user.getId();
        String category = req.getParameter("category");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        PostDAO postDAO = new PostDAO();
        boolean r = postDAO.create(writerId,category,title,content);

        if (r) {
            req.getRequestDispatcher("/WEB-INF/view/write.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/write-fail.jsp").forward(req,resp);  //등록이 실패 하면 error.jsp 파일을 실행
        }
    }
}
