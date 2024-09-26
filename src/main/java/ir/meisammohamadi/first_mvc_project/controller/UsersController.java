package ir.meisammohamadi.first_mvc_project.controller;

import ir.meisammohamadi.first_mvc_project.model.User;
import ir.meisammohamadi.first_mvc_project.service.UsersService;
import ir.meisammohamadi.first_mvc_project.utils.RegularExpression;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UsersController extends HttpServlet {

    private UsersService usersService = new UsersService();
    private RegularExpression regex = new RegularExpression();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getServletPath());
        User newUser = User.builder()
                .username(req.getParameter("user"))
                .password(req.getParameter("pass"))
                .build();
        switch (req.getServletPath().substring(1)) {
            case "signup":
//                User newUser = new User();
//                newUser.setUsername(req.getParameter("user"));
//                newUser.setPassword(req.getParameter("pass"));
                boolean passwordIsValid = regex.validatePassword(req.getParameter("pass"));
                if (!passwordIsValid) {
                    req.getSession().setAttribute("error","password is not secure !!!");
                    resp.sendRedirect("index.jsp");
                }

                usersService.save(newUser);
                break;
            case "login":
                boolean loginResult = usersService.login(newUser);
                if(loginResult==true)
                {
                    req.getSession().setAttribute("loggedIn","true");
                    resp.sendRedirect("welcome.jsp");
                }
                else
                {
                    req.getSession().setAttribute("error","login failed");
                    resp.sendRedirect("login.jsp");
                }
                break;
            default:
                System.out.println("there is no valid url");
        }
        System.out.println("do post ejra shod");
    }
}
