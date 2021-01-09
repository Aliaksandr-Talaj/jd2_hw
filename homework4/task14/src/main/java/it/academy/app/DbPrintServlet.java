package it.academy.app;


import it.academy.data.AccountingDao;
import it.academy.data.DaoFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DbPrintServlet extends HttpServlet {

    private String dbUrl, user, password;


    @Override
    public void init() throws ServletException {
        super.init();

        ServletConfig servletConfig = getServletConfig();
        dbUrl = servletConfig.getInitParameter("dbUrl");
        user = servletConfig.getInitParameter("user");
        password = servletConfig.getInitParameter("password");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DaoFactory daoFactory = new DaoFactory();
        AccountingDao accountingDao = null;
        PrintWriter out = resp.getWriter();

        try {
            accountingDao = daoFactory.getAccountingDao(dbUrl, user, password);
        } catch (SQLException e) {
           out.println("Database connection failure");
        }

            accountingDao.printAll(out);

    }
}



