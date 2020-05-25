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

public class CreateRequestCommand extends Command {
    private static final Logger LOG = Logger.getLogger(CreateRequestCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Creating new request");

        RequestDAO requestDAO = new RequestDAO();
        int idRequest = Integer.valueOf(request.getParameter("idRequest"));
        int idTeam = Integer.valueOf(request.getParameter("idTeam"));
        int idVoyage = Integer.valueOf(request.getParameter("idVoyage"));

        LOG.trace("Creating new request instance");

        Request request1 = new Request();
        request1.setId(idRequest);
        request1.setIdVoyage(idVoyage);
        request1.setIdTeam(idTeam);
        request1.setStatus(true);

        String forward = Path.ERROR_PAGE;
        LOG.trace("");
        try {
            LOG.trace("before insert " + requestDAO.getAll().size());
            requestDAO.insert(request1);
            LOG.trace("after insert " + requestDAO.getAll().size());
            forward = Path.DISPATCHER_PAGE;

        }catch (DAOExceptions ex){
            throw new AppExceptions("problem");
        }
        return forward;
    }
}
