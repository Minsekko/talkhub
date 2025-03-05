package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/logout")
public class LogoutProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        //session.removeAttribute("user");
        session.invalidate();  //잔여 메모리들이 있어서 완전히 삭제하게 되어 이걸로 많이 씀.

        resp.sendRedirect(req.getContextPath()+"/index");
    }
}
