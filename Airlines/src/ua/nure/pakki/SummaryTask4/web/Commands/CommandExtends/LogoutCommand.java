package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutCommand extends Command {

    private static final long serialVersionUID = -2785976616686657267L;

    private static final Logger LOG = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOG.debug("Command starts");

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        LOG.debug("Command finished");
        return Path.LOGIN_PAGE;
    }

}