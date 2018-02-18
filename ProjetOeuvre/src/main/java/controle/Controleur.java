package controle;

import java.io.IOException;
import java.util.Enumeration;

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
	private static final String ID = "id";
    private static final String SAVE_ADHERENT = "saveAdherent";
	private static final String LISTER_ADHERENT = "listerAdherent";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_ADHERENT = "insererAdherent";
	private static final String DELETE_ADHERENT = "deleteAdherent";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";
	private static final String MODIFIER_ADHERENT = "modifierAdherent";
    private static final String AJOUT_OEUVRE = "ajouterOeuvre";
	private static final String INSERER_OEUVRE = "insererOeuvre";
	private static final String LISTER_OEUVRE = "listerOeuvre";

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
			case AJOUT_OEUVRE:
				try {

					Service unService = new Service();
					request.setAttribute("mesPropio", unService.consulterListeProprietaire());

				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				destinationPage = "/ajouterOeuvre.jsp";
				break;
			case INSERER_OEUVRE:
				try {

					Service unService = new Service();
					Oeuvrevente oeuvre = this.setParameterToOeuvrevente(request);

					unService.insertOeuvre(oeuvre);

				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				destinationPage = "/index.jsp";
				break;
			case LISTER_OEUVRE:
				try {

					Service unService = new Service();
					request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());


				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				destinationPage = "/listerOeuvre.jsp";
				break;
			case LISTER_ADHERENT:
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
					Adherent unAdherent = this.setParameterToAdherent(request);
					Service unService = new Service();

					unService.insertAdherent(unAdherent);

				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                destinationPage = "/index.jsp";
				break;
            case SAVE_ADHERENT:
                try {
                    Adherent adherent = this.setParameterToAdherent(request);
                    adherent.setIdAdherent(Integer.parseInt(request.getParameter("id")));
                    Service unService = new Service();
                    unService.modifyAdherent(adherent);
                }catch (MonException e){
                    e.printStackTrace();
                }
                destinationPage = "/index.jsp";
                break;
            case MODIFIER_ADHERENT:
				try {
					int id = Integer.parseInt(request.getParameter(ID));
					Service unService = new Service();
					request.setAttribute("adherent", unService.consulterAdherent(id));
				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				destinationPage = "/modifierAdherent.jsp";
                break;
            case DELETE_ADHERENT:
                Service unService = new Service();
                try {
                    Adherent adherentToDelete = unService.consulterAdherent(Integer.parseInt(request.getParameter(ID)));
                    if (adherentToDelete == null) {
                        response.getWriter().write("error");
                        return;
                    }
                    unService.deleteAdherent(adherentToDelete);
                } catch (MonException e) {
                    e.printStackTrace();
                    response.getWriter().write("error");
                    return;
                }
                response.getWriter().write("AdherentSupprimer");
                return;
			default:
				String messageErreur = "[" + actionName + "] n'est pas une action valide.";
				request.setAttribute(ERROR_KEY, messageErreur);
				break;
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

	protected Adherent setParameterToAdherent(HttpServletRequest request) {
        Adherent unAdherent = new Adherent();
        unAdherent.setNomAdherent(request.getParameter("nom"));
        unAdherent.setPrenomAdherent(request.getParameter("prenom"));
        unAdherent.setVilleAdherent(request.getParameter("ville"));
        return unAdherent;
    }
    protected Oeuvrevente setParameterToOeuvrevente(HttpServletRequest request) throws MonException {
        Oeuvrevente oeuvrevente = new Oeuvrevente();
        Service unService = new Service();
        oeuvrevente.setTitreOeuvrevente(request.getParameter("titreOeuvre"));
        oeuvrevente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prixOeuvre")));
		oeuvrevente.setProprietaire(unService.rechercherProprietaire(request.getParameter("listeProprio")));
		return oeuvrevente;
    }
}
