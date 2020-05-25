import DataBase.DAO.DAOExtends.UserDAO;
import DataBase.Model.User;
import Exceptions.DAOExceptions;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static com.sun.deploy.config.JREInfo.getAll;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        PrintWriter pw = resp.getWriter();

        try {
            ArrayList<User> list = userDAO.getAll();

            for (User someUser : list) {
                pw.println(someUser.toString());
            }
        } catch (DAOExceptions ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
