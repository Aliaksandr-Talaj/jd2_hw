package it.academy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserFormServlet extends HttpServlet {

    boolean inputIsOkay;
    boolean noName;
    boolean noContact;

    @Override
    public void init() throws ServletException {
        super.init();

        NameValidator nameValidator = new NameValidator();
        PhoneValidtor phoneValidtor = new PhoneValidtor();
        EmailValidator emailValidator = new EmailValidator();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        RequestDispatcher requestDispatcher =context.getRequestDispatcher("/");
        requestDispatcher.forward(req,resp);
        //при вызове сервлета через doGet происходит перенаправление на index.html
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        inputIsOkay = true;
        noName = false;
        noContact = false;

        NameValidator nameValidator = new NameValidator();
        PhoneValidtor phoneValidtor = new PhoneValidtor();
        EmailValidator emailValidator = new EmailValidator();

        final PrintWriter out = resp.getWriter();

        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setTelNumber(req.getParameter("telNumber"));
        user.setEmail(req.getParameter("email"));

        if (user.getUserName() == null || nameValidator.badInput(user.getUserName())) {
            inputIsOkay = false;
            noName = true;
        }
        if ((user.getTelNumber() == null && user.getEmail() == null) ||
                (phoneValidtor.badInput(user.getTelNumber()) && emailValidator.badInput(user.getEmail()))) {
            inputIsOkay = false;
            noContact = true;
        }

        if (inputIsOkay) {
            out.println("<html><head><meta charset=\"UTF-8\"><title>Success!</title></head>");

            out.println("<body><h1>You've entered your information successfully!</h1>");
            out.println("Your name is: " + user.getUserName()+",");
            if (user.getTelNumber() != null && !phoneValidtor.badInput(user.getTelNumber())) {
                out.println("<br>your telephone number is: " + user.getTelNumber()+",");
            } else {
                out.println("<br>you've entered no telephone number or it has wrong format," +
                        "<br>don't worry, it wil be enough for us to have your email only,");
            }
            if (user.getEmail() != null && !emailValidator.badInput(user.getEmail())) {
                out.println("<br>your email is: " + user.getEmail()+",");
            } else {
                out.println("<br>you've entered no email or it has wrong format," +
                        "<br>don't worry, it wil be enough for us to have your telephone number only,");
            }
            out.println("<br>good luck!</body></html>");
        } else {
            out.println("<html><head><meta charset=\"UTF-8\"><title>Error!</title></head>");
            out.println("<body><h1>It seems, that you've made something wrong!</h1>");
            if (noName) {
                out.println("You had to enter your name!<br>");
            }
            if (noContact) {
                out.println("You had to enter you telephone number or email!<br>");
            }

            out.println("<a href=\"/task10\">Retry input</a>");

            out.println("</body></html>");
        }


    }
}
