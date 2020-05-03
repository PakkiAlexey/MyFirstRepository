//package ua.nure.pakki.SummaryTask4;
//
//import org.apache.log4j.BasicConfigurator;
//import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
//import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.*;
//
//import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.*;
//
//import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Writer;
//import java.util.ArrayList;
//
//public class Hello extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////       PrintWriter pw = resp.getWriter();
////        TeamDAO teamDAO = new TeamDAO();
////
////        try {
////            pw.println("Start");
////
////          ArrayList<Integer> list1 = teamDAO.;
////          list = voyageDAO.getAll();
//////            pw.println(pilotDAO.insert(pilot));
//////            pw.println(pilotDAO.delete(pilot));
//////            pw.println(pilotDAO.update(pilot));
//////            list = pilotDAO.getAll();
////
////            for (Voyage pilot : list1){
////                pw.println(pilot.toString());
////            }
////
////            pw.println();
////
////            for (Voyage pilot1 : list){
////                pw.println(pilot1.toString());
////            }
////
////            pw.println("finish");
////        } catch (DAOExceptions daoExceptions) {
////
////            Object[] array = daoExceptions.getStackTrace();
////            pw.println(daoExceptions.getCause());
////            for (int i = 0; i < array.length; i++){
////
////                pw.println(array[i].toString());
////
////            }
////            daoExceptions.printStackTrace();
////        }
////
////    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }
//}
