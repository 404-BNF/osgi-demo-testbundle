package dev.sk.bundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    public static final String SERVLET_ALIAS = "/service";

    private static final long serialVersionUID = 1L;

    public TestServlet() {
    }

    @Override
    public void init(ServletConfig config)
            throws ServletException
    {
        super.init(config);
    }

    @Override
    public void destroy()
    {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        System.out.println("Got request in OSGI Bundle TestServlet...");
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        out.println("Request = " + req);
        out.println("PathInfo = " + req.getPathInfo());
    }
}