package it.academy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class CounterServlet extends HttpServlet {
    int counter = 0;
    String path;
    File dir;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        path = servletContext.getRealPath("/");
        dir = new File(path + "/counter");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!dir.exists()) {        //данный блок можно было перенести в init(), однако в случае внешнего удаления
            dir.mkdirs();           //директории "counter", сервлет перестает работать корректно. В данном же варианте
        }                           //счетчик counter обнулится, но сервлет сохранит работоспособность


        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(dir + "/doGetCounter"))) {
            counter = dataInputStream.readInt();

        } catch (IOException e) {
            counter = 0;
        }
        counter++;

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(
                dir + "/doGetCounter"))) {
            dataOutputStream.writeInt(counter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Counter of \"doGet()\"</title></head>");
        out.println("<body><h1>Counter = " + counter + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
