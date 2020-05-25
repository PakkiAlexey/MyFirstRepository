package web;

import Exceptions.AppExceptions;
import org.apache.log4j.Logger;
import web.Command.Command;
import web.Path;
import web.Command.Util.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 9019091611735677481L;
    private static final Logger LOG = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        LOG.debug("Controller starts");
        // extract command name from the request
        String commandName = request.getParameter("command");
        LOG.trace("Request parameter: command --> " + commandName);
        // obtain command object by its name
        String typeOFList = request.getParameter("typeOfList");
        request.setAttribute("typeOfList",typeOFList);

        Command command = CommandContainer.get(commandName);
        LOG.trace("Obtained command --> " + command);
        // execute command and get forward address


        String forward = Path.ERROR_PAGE;
        try {
            forward = command.execute(request, response);
        } catch (AppExceptions ex) {
            request.setAttribute("errorMessage", ex.getMessage());
        }
        LOG.trace("Forward address --> " + forward);

        LOG.debug("Controller finished, now go to forward address --> " + forward);

        request.getRequestDispatcher(forward).forward(request, response);
        //response.sendRedirect(forward);
    }
}
