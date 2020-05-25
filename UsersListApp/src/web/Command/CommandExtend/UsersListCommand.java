package web.Command.CommandExtend;

import DataBase.Model.User;
import Exceptions.AppExceptions;
import org.apache.log4j.Logger;
import web.Command.Command;
import web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UsersListCommand extends Command {
    private static ArrayList<User> listOfUsers = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger(UsersListCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.trace("List of users");
        if (listOfUsers.size() == 0){
            fillListOfUsers();
        }

        request.setAttribute("listOfUsers",listOfUsers);
        String forward = Path.USER_LIST_PAGE;

        return forward;
    }

    private void fillListOfUsers(){
        listOfUsers.add(new User(1,"Ivan","Ivanov","ivanovivan@gmail.com","123-456-7890"));
        listOfUsers.add(new User(2,"Petr","Petrov","petrpetrov@gmail.com","125-146-2390"));
        listOfUsers.add(new User(3,"Sidr","Sidorov","sidrsidorov@gmail.com","613-126-1890"));
        listOfUsers.add(new User(4,"Stephan","Stepanov","stepanstepanov@gmail.com","156-136-7340"));
        listOfUsers.add(new User(5,"Teresa","Hayes","teresahayes@gmail.com","109-236-7530"));
        listOfUsers.add(new User(6,"Gussie","Dixon","gussiedixon@gmail.com","113-463-7123"));
        listOfUsers.add(new User(7,"Maud","McKinney","maudmckinney@gmail.com","941-401-7250"));
        listOfUsers.add(new User(8,"Some","Person","someperson@gmail.com","161-410-5072"));
    }

    public static ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }
}
