package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.*;
import dao.Service;
import meserreurs.*;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String LISTER_RADHERENT = "listerAdherent";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_ADHERENT = "insererAdherent";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_TYPE);
        String destinationPage = ERROR_PAGE;
		// execute l'action
		switch (actionName) {
			case LISTER_RADHERENT:
				try {

					Service unService = new Service();
					request.setAttribute("mesAdherents", unService.consulterListeAdherents());

				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				destinationPage = "/listerAdherent.jsp";
				break;
			case AJOUTER_ADHERENT:

				destinationPage = "/ajouterAdherent.jsp";
				break;
			case INSERER_ADHERENT:
				try {
					Adherent unAdherent = new Adherent();
					unAdherent.setNomAdherent(request.getParameter("txtnom"));
					unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
					unAdherent.setVilleAdherent(request.getParameter("txtville"));
					Service unService = new Service();
					unService.insertAdherent(unAdherent);

				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				destinationPage = "/index.jsp";
				break;

			default:
				String messageErreur = "[" + actionName + "] n'est pas une action valide.";
				request.setAttribute(ERROR_KEY, messageErreur);
				break;
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

}