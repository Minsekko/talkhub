package org.innovibe.talkhub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/index")
public class HomeServelt extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        HttpSession session = req.getSession();
        String sid = session.getId();
        boolean f = session.isNew();
        long ct = session.getCreationTime();  //세션이 만들어진 시간

        System.out.println("session info");
        System.out.println(sid);
        System.out.println(f);
        System.out.println(ct);
        */

        //session 저장: setAttribute(String key, object value)
        //session 값 확인 : getAttribute(String key)
        //session 값 삭제 : removeAttribute(String key)

        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            req.setAttribute("authentication", true);
        } else {
            req.setAttribute("authentication", false);
        }
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
