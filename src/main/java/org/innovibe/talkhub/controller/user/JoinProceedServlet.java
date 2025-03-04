package org.innovibe.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.innovibe.talkhub.model.dao.UserDAO;

import java.io.IOException;

@WebServlet("/user/join-proceed")
public class JoinProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        int birth = Integer.parseInt(req.getParameter("birth"));
        //=======================================================================
        UserDAO userDAO = new UserDAO();
        boolean r = userDAO.create(id,password,nickname,gender,birth);

        if (r) {    //success 값이 성공 true 이면 if 조건값 하위가 실행 된다
            resp.sendRedirect(req.getContextPath() + "/index");
        }else{  // try 구문에 성공했던 Boolean 값이 실패하면 아래 구문 실행
            req.getRequestDispatcher("/WEB-INF/view/join-fail.jsp").forward(req,resp);  //포켓몬 등록이 실패 하면 error.jsp 파일을 실행
        }

    }
}
