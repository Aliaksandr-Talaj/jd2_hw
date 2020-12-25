package it.academy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

    @WebServlet(name = "timeServlet", urlPatterns = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            final PrintWriter writer = resp.getWriter();
            writer.println("Now it is " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}