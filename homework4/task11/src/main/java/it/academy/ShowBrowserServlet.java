package it.academy;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowBrowserServlet extends HttpServlet {



    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        String info = req.getHeader("User-Agent");
        if (info==null){
            info="неизветного браузера";
        }
        final PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Hello!</title></head>");
        out.println("<body><meta charset=\"utf-8\">Приветствую пользователя  " + info + "!</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}