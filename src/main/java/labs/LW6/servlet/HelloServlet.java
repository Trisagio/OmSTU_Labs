package labs.LW6.servlet;

import java.io.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void  service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fileName = request.getParameter("fileName");

        String formattedText = TextFormatter.formatText(getServletContext().getRealPath(fileName));

        String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "_formatted.txt";
        TextFormatter.writeToFile(newFileName, formattedText);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Formatted Text</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Formatted Text:</h1>");
        out.println("<pre>" + formattedText + "</pre>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}