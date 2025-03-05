package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.innovibe.talkhub.model.dao.UserDAO;
import org.innovibe.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/user/login-proceed")
public class LoginProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User found = userDAO.findById(id);

        if (found == null) {
            req.setAttribute("error","아이디 또는 비밀 번호가 잘못되었습니다. 아이디와 비밀번호를 정확히 입력해주세요");
            req.setAttribute("id",id);
            req.getRequestDispatcher("/WEB-INF/views/user/login-fail.jsp").forward(req,resp);
        }else {
            if(found.getPassword().equals(password)) {
                //인증성공
                HttpSession session = req.getSession();
                session.setAttribute("user",found);
                resp.sendRedirect(req.getContextPath()+"/index");
            } else {
                //인증 실패
                req.setAttribute("error","아이디 또는 비밀 번호가 잘못되었습니다. 아이디와 비밀번호를 정확히 입력해주세요");
                req.setAttribute("id",id);
                req.getRequestDispatcher("/WEB-INF/views/user/login-fail.jsp").forward(req,resp);
            }
        }
    }
}
