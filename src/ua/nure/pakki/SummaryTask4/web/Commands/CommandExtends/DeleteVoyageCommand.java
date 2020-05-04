package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.VoyageDAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Voyage;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteVoyageCommand extends Command {
    private static final Logger LOG = Logger.getLogger(DeleteVoyageCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Delete voyage command start");

        int id = Integer.valueOf(request.getParameter("id"));
        Voyage voyage = new Voyage();
        String forward = Path.ERROR_PAGE;

        try{
            voyage = new VoyageDAO().getById(id);
            LOG.trace("Deleting voyage with id = " + id);
            new VoyageDAO().delete(voyage);
            forward = Path.ADMIN_PAGE;

        }catch (DAOExceptions ex){
            LOG.error("Cannot obtain connection",ex);
            throw new AppExceptions("Problem with connection");
        }

        return forward;

    }
}
