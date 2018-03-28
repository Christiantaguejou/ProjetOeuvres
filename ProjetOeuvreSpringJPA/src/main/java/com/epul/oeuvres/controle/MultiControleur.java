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
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.text.SimpleDateFormat;


@Controller
public class MultiControleur {

    private static final String ID = "id";

    @RequestMapping(value = "listerAdherent.htm")
    public ModelAndView listerAdherents(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage;
        try {
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
    public View insererAdherent(HttpServletRequest request, HttpServletResponse response) {

        String destinationPage = "listerAdherent.htm";
        try {
            Service unService = new Service();
            unService.insertAdherent(setParameterToAdherent(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }

        return new RedirectView(destinationPage);
    }

    @RequestMapping(value = "ajouterAdherent.htm")
    public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) {

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
    public View saveAdherent(HttpServletRequest request, HttpServletResponse response) {

        try {
            AdherentEntity adherent = this.setParameterToAdherent(request);
            adherent.setIdAdherent(Integer.parseInt(request.getParameter("id")));
            Service unService = new Service();
            unService.modifyAdherent(adherent);
        } catch (MonException e) {
            e.printStackTrace();
        }
        return new RedirectView("listerAdherent.htm");
    }

    @RequestMapping(value = "modifierAdherent.htm")
    public ModelAndView modifierAdherent(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            int id = Integer.parseInt(request.getParameter(ID));
            Service unService = new Service();
            request.setAttribute("adherent", unService.consulterAdherent(id));
        } catch (MonException e) {
            e.printStackTrace();
        }
        destinationPage = "modifierAdherent";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "deleteAdherent.htm")
    public RedirectView deleteAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "listerAdherent.htm";
        Service unService = new Service();
        try {
            AdherentEntity adherentToDelete = unService.consulterAdherent(Integer.parseInt(request.getParameter(ID)));
            if (adherentToDelete == null) {
                response.getWriter().write("error");
                destinationPage = "Erreur";

                return new RedirectView("erreur.htm");
            }
            unService.deleteAdherent(adherentToDelete);
        } catch (MonException e) {
            e.printStackTrace();
            response.getWriter().write("error");
            return new RedirectView("erreur.htm");
        }
        return new RedirectView(destinationPage);
    }

    /**
     * Oeuvres
     */

    @RequestMapping(value = "listerOeuvre.htm")
    public ModelAndView listerOeuvres(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        Service unService = new Service();
        request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
        destinationPage = "listerOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterOeuvre.htm")
    public ModelAndView ajoutOeuvre(HttpServletRequest request, HttpServletResponse response) {

        String destinationPage = "";

        Service unService = new Service();
        request.setAttribute("mesPropio", unService.consulterListeProprietaire());


        destinationPage = "ajouterOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererOeuvre.htm")
    public View insererOeuvre(HttpServletRequest request, HttpServletResponse response) {

        try {

            Service unService = new Service();
            OeuvreventeEntity oeuvre = this.setParameterToOeuvrevente(request);

            unService.insertOeuvre(oeuvre);

        } catch (MonException e) {
            e.printStackTrace();
        }

        return new RedirectView("listerOeuvre.htm");
    }

    @RequestMapping(value = "saveOeuvre.htm")
    public View saveOeuvre(HttpServletRequest request, HttpServletResponse response) {
        try {
            OeuvreventeEntity oeuvre = this.setParameterToOeuvrevente(request);
            oeuvre.setIdOeuvrevente(Integer.parseInt(request.getParameter("idOeuvre")));

            Service unService = new Service();
            unService.modifyOeuvre(oeuvre);
        } catch (MonException e) {
            e.printStackTrace();
        }
        return new RedirectView("listerOeuvre.htm");
    }

    @RequestMapping(value = "modifierOeuvre.htm")
    public ModelAndView modiferOeuvre(HttpServletRequest request, HttpServletResponse response) {
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

    /**
     * Reservations
     */

    @RequestMapping(value = "reserverOeuvre.htm")
    public ModelAndView reserverOeuvre(HttpServletRequest request, HttpServletResponse response) {
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
        destinationPage = "reserverOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "listerReservations.htm")
    public ModelAndView listerReservation(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        Service unService = new Service();
        try {
            request.setAttribute("reservations", unService.consulterListeReservation());
            destinationPage = "listerReservations";
        } catch (Exception e) {
            destinationPage = "Erreur";
            e.printStackTrace();
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "saveReservation.htm")
    public View insererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RedirectView redirect = new RedirectView("listerReservations.htm");
        try {
            Service unService = new Service();
            ReservationEntity reservation = this.setParameterToReservation(request);
            if (! unService.insertReservation(reservation)) {
                return new RedirectView("listerReservations.htm?success=false");
            }

        } catch (MonException e) {
            e.printStackTrace();
        }
        return new RedirectView("listerReservations.htm");
    }

    @RequestMapping(value = "supprimerReservation.htm")
    public View supprimerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Service unService = new Service();
        ReservationEntity reservationToDelete = unService.consulterReservation(Integer.parseInt(request.getParameter("adherent")), Integer.parseInt(request.getParameter("oeuvre")));
        if (reservationToDelete == null) {
            response.getWriter().write("error");

            return new RedirectView("listerReservations.htm");
        }
        unService.deleteReservation(reservationToDelete);
        return new RedirectView("listerReservations.htm");
    }

    @RequestMapping(value = "confirmerReservation.htm")
    public View confirmerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RedirectView redirectView = new RedirectView("listerReservations.htm");
        Service unService = new Service();
        try {
            ReservationEntity reservationToConfirm = unService.consulterReservation(Integer.parseInt(request.getParameter("adherent")), Integer.parseInt(request.getParameter("oeuvre")));
            unService.confirmerReservation(reservationToConfirm);
        } catch (MonException e) {
            e.printStackTrace();
            response.getWriter().write("error");
        }
        return redirectView;
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
    public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("Erreur");
    }

    private AdherentEntity setParameterToAdherent(HttpServletRequest request) {
        AdherentEntity unAdherent = new AdherentEntity();
        unAdherent.setNomAdherent(request.getParameter("nom"));
        unAdherent.setPrenomAdherent(request.getParameter("prenom"));
        unAdherent.setVilleAdherent(request.getParameter("ville"));
        return unAdherent;
    }

    private OeuvreventeEntity setParameterToOeuvrevente(HttpServletRequest request) {
        OeuvreventeEntity oeuvrevente = new OeuvreventeEntity();
        Service unService = new Service();
        oeuvrevente.setTitreOeuvrevente(request.getParameter("titreOeuvre"));
        oeuvrevente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prixOeuvre")));
        oeuvrevente.setProprietaireEntity(unService.rechercherProprietaire(request.getParameter("proprio")));
        oeuvrevente.setEtatOeuvrevente("L");
        if (request.getParameter("etatOeuvre") != null)
            oeuvrevente.setEtatOeuvrevente(request.getParameter("etatOeuvre"));
        if (request.getParameter("idOeuvre") != null)
            oeuvrevente.setIdOeuvrevente(Integer.parseInt(request.getParameter("idOeuvre")));
        return oeuvrevente;
    }

    private ReservationEntity setParameterToReservation(HttpServletRequest request) throws Exception {
        ReservationEntity reservation = new ReservationEntity();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        reservation.setIdAdherent(Integer.parseInt(request.getParameter("adherent")));
        reservation.setDateReservation(new Date(format.parse(request.getParameter("dateReservation")).getTime()));
        reservation.setIdOeuvrevente(Integer.parseInt(request.getParameter("id")));
        reservation.setStatut("en attente");
        return reservation;
    }

}
