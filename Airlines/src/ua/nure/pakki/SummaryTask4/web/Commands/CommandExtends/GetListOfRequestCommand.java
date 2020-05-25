package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.RequestDAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Request;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetListOfRequestCommand extends Command {
    private static final Logger LOG = Logger.getLogger(GetListOfRequestCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        ArrayList<Request> listOfRequest = new ArrayList<>();

        String forward = Path.ERROR_PAGE;
        LOG.trace("Getting list of request");
        try{
            listOfRequest = new RequestDAO().getAll();
            LOG.trace("size of list " + listOfRequest.size());
            request.setAttribute("listOfRequest", listOfRequest);
            forward = Path.ADMIN_PAGE;

        }catch (DAOExceptions ex){
            LOG.error("Connection problem",ex);
            throw new AppExceptions("Connection problem");
        }

        return forward;
    }
}
