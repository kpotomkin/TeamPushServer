package ua.nure.pi.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ua.nure.pi.dao.DAOFactory;
import ua.nure.pi.dao.PassDAO;
import ua.nure.pi.dao.RoomDAO;
import ua.nure.pi.dao.TeamLeadDAO;
import ua.nure.pi.dao.UserDAO;
import ua.nure.pi.parameter.AppConstants;


public class ContextListener implements ServletContextListener {
	//private static final Logger log = Logger.getLogger(ContextListener.class);
	
	public void contextInitialized(ServletContextEvent event) {
		/*if (log.isDebugEnabled()) {
			log.debug("Servlet context initialization starts");
		}*/
		ServletContext servletContext = event.getServletContext();
		setRoomDAOAttribute(servletContext);
		setUserDAOAttribute(servletContext);
		setTeamLeadDAOAttribute(servletContext);
		setPassDAOAttribute(servletContext);
	}

	private void setPassDAOAttribute(ServletContext servletContext) {
		PassDAO passDAO = DAOFactory.getDAOFactory().getPassDAO();
		servletContext.setAttribute(AppConstants.PASS_DAO, passDAO);
	}

	/*@Override
	public void contextDestroyed(ServletContextEvent sce) {
		/*if (log.isDebugEnabled()) {
			log.debug("Servlet context destruction starts");
			log.debug("Servlet context destruction finished");
		}/
	}
*/

	private void setUserDAOAttribute(ServletContext servletContext) {
		UserDAO userDAO = DAOFactory.getDAOFactory()
				.getUserDAO();
		servletContext.setAttribute(AppConstants.USER_DAO, userDAO);
		//log.debug("UserDAO was created");
	}
	private void setRoomDAOAttribute(ServletContext servletContext) {
		RoomDAO roomDAO = DAOFactory.getDAOFactory()
				.getRoomDAO();
		servletContext.setAttribute(AppConstants.ROOM_DAO, roomDAO);
	}
	
	private void setTeamLeadDAOAttribute(ServletContext servletContext) {
		TeamLeadDAO teamLeadDAO = DAOFactory.getDAOFactory()
				.getTeamLeadDAO();
		servletContext.setAttribute(AppConstants.TEAMLEAD_DAO, teamLeadDAO);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}