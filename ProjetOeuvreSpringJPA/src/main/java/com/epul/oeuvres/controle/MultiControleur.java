package com.epul.oeuvres.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.meserreurs.*;
import com.epul.oeuvres.metier.*;

///
/// Les m�thode du contr�leur r�pondent � des sollicitations
/// des pages JSP

@Controller
public class MultiControleur {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);
    private static final String ID = "id";

	@RequestMapping(value = "listerAdherent.htm")
	public ModelAndView listerAdherents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
            Service unService = new Service();
            request.setAttribute("mesAdherents", unService.consulterListeAdherents());
            destinationPage = "listerAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "insererAdherent.htm")
	public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
        destinationPage = "index";
		try {
           /* AdherentEntity unAdherent = new AdherentEntity();
            unAdherent.setNomAdherent(request.getParameter("txtnom"));
            unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
            unAdherent.setVilleAdherent(request.getParameter("txtville"));*/
            Service unService = new Service();
            unService.insertAdherent(setParameterToAdherent(request));
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterAdherent.htm")
	public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }

        return new ModelAndView(destinationPage);
	}

    @RequestMapping(value = "saveAdherent.htm")
    public ModelAndView saveAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            AdherentEntity adherent = this.setParameterToAdherent(request);
            adherent.setIdAdherent(Integer.parseInt(request.getParameter("id")));
            Service unService = new Service();
            unService.modifyAdherent(adherent);
        }catch (MonException e){
            e.printStackTrace();
        }
        destinationPage = "index";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "modifierAdherent.htm")
    public ModelAndView modifierAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            int id = Integer.parseInt(request.getParameter(ID));
            Service unService = new Service();
            request.setAttribute("adherent", unService.consulterAdherent(id));
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        destinationPage = "modifierAdherent";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "deleteAdherent.htm")
    public ModelAndView deleteAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "listerAdherent";
        Service unService = new Service();
        try {
            AdherentEntity adherentToDelete = unService.consulterAdherent(Integer.parseInt(request.getParameter(ID)));
            if (adherentToDelete == null) {
                response.getWriter().write("error");
                destinationPage = "Erreur";

                return new ModelAndView(destinationPage);
            }
            unService.deleteAdherent(adherentToDelete);
        } catch (MonException e) {
            e.printStackTrace();
            response.getWriter().write("error");
            return new ModelAndView(destinationPage);
        }
        //response.getWriter().write("AdherentSupprimer");
        return new ModelAndView(destinationPage);
    }

    /**
     * Oeuvres
     */

    @RequestMapping(value = "listerOeuvre.htm")
    public ModelAndView listerOeuvres(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        Service unService = new Service();
        request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
        destinationPage = "listerOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterOeuvre.htm")
    public ModelAndView ajoutOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";

            Service unService = new Service();
            request.setAttribute("mesPropio", unService.consulterListeProprietaire());


        destinationPage = "ajouterOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererOeuvre.htm")
    public ModelAndView insererOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {

            Service unService = new Service();
            OeuvreventeEntity oeuvre = this.setParameterToOeuvrevente(request);

            unService.insertOeuvre(oeuvre);

        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        destinationPage = "index";
        return new ModelAndView(destinationPage);
    }

	@RequestMapping(value = "pretOeuvre.htm")
    public ModelAndView pretOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            int id = Integer.parseInt(request.getParameter(ID));
            Service unService = new Service();
            request.setAttribute("oeuvre", unService.consulterOeuvre(id));
            request.setAttribute("lesAdherents", unService.consulterListeAdherents());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        destinationPage = "pretOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "savePret.htm")
    public ModelAndView savePret(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        /*try {
            int id = Integer.parseInt(request.getParameter(ID));
            Service unService = new Service();
            request.setAttribute("oeuvre", unService.consulterOeuvre(id));
            request.setAttribute("lesAdherents", unService.consulterListeAdherents());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        destinationPage = "pretOeuvre";
        return new ModelAndView(destinationPage);*/
    }

    @RequestMapping(value = "saveOeuvre.htm")
    public ModelAndView saveOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            OeuvreventeEntity oeuvre = this.setParameterToOeuvrevente(request);
            oeuvre.setIdOeuvrevente(Integer.parseInt(request.getParameter("idOeuvre")));

            Service unService = new Service();
            unService.modifyOeuvre(oeuvre);
        }catch (MonException e){
            e.printStackTrace();
        }
        destinationPage = "index";
        return new ModelAndView(destinationPage);
    }

	@RequestMapping(value = "modifierOeuvre.htm")
    public ModelAndView modiferOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            int id = Integer.parseInt(request.getParameter(ID));
            Service unService = new Service();
            request.setAttribute("oeuvre", unService.consulterOeuvre(id));
            request.setAttribute("mesProprio", unService.consulterListeProprietaire());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        destinationPage = "modifierOeuvre";
        return new ModelAndView(destinationPage);
    }

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}

	// /
		// / Affichage de la page d'accueil
		// /
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return new ModelAndView("index");
		}
	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("Erreur");
	}

    protected AdherentEntity setParameterToAdherent(HttpServletRequest request) {
        AdherentEntity unAdherent = new AdherentEntity();
        unAdherent.setNomAdherent(request.getParameter("nom"));
        unAdherent.setPrenomAdherent(request.getParameter("prenom"));
        unAdherent.setVilleAdherent(request.getParameter("ville"));
        return unAdherent;
    }
    protected OeuvreventeEntity setParameterToOeuvrevente(HttpServletRequest request) throws MonException {
        OeuvreventeEntity oeuvrevente = new OeuvreventeEntity();
        Service unService = new Service();
        oeuvrevente.setTitreOeuvrevente(request.getParameter("titreOeuvre"));
        oeuvrevente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prixOeuvre")));
        oeuvrevente.setProprietaireEntity(unService.rechercherProprietaire(request.getParameter("proprio")));
        oeuvrevente.setEtatOeuvrevente("L");
        if(request.getParameter("etatOeuvre") != null)
            oeuvrevente.setEtatOeuvrevente(request.getParameter("etatOeuvre"));
        if(request.getParameter("idOeuvre") != null)
            oeuvrevente.setIdOeuvrevente(Integer.parseInt(request.getParameter("idOeuvre")));
        return oeuvrevente;
    }
	

}
