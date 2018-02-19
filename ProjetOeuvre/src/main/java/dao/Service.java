package dao;

import meserreurs.MonException;

import java.util.*;

import metier.*;
import persistance.*;

public class Service {

    /**
     * en cours de modif
     */
    public void ajoutOeuvre(Oeuvrevente oeuvrevente) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into oeuvrevente  (titre_oeuvrevente,etat_oeuvrevente,prix_oeuvrevente,id_proprietaire)  " + "values ('"
                    + oeuvrevente.getTitreOeuvrevente()  ;
            mysql += "'" + ",'L','" + oeuvrevente.getPrixOeuvrevente() +"','"+ oeuvrevente.getProprietaire().getIdProprietaire()+ "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }

    }

    /***********************************/
    public void insertAdherent(Adherent unAdherent) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
                    + unAdherent.getNomAdherent();
            mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    /**
     * Insertion d'une oeuvre dans la BDD
     * @param oeuvre
     * @throws MonException
     */
    public void insertOeuvre(Oeuvrevente oeuvre) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into oeuvrevente  (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)  "
                    + "values ('"+oeuvre.getTitreOeuvrevente()+"','"+"L"+"',"+oeuvre.getPrixOeuvrevente()+","
                    +oeuvre.getProprietaire().getIdProprietaire()+")";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }
    public void modifyAdherent(Adherent adherent) throws MonException {
        String mysql;
        DialogueBd dialogueBd = DialogueBd.getInstance();
        try {
            mysql = "UPDATE adherent SET nom_adherent='" + adherent.getNomAdherent() + "', prenom_adherent='" +
                    adherent.getPrenomAdherent() + "', ville_adherent='" + adherent.getVilleAdherent() +
                    "' WHERE id_adherent=" + adherent.getIdAdherent();
            dialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception ex) {
            throw new MonException(ex.getMessage(), "systeme");
        }
    }


    // gestion des adherents
    // Consultation d'un adhérent par son numéro
    // Fabrique et renvoie un objet adhérent contenant le résultat de la requête
    // BDD
    public Adherent consulterAdherent(int numero) throws MonException {

        try {
            String mysql = "select * from adherent where id_adherent=" + numero;
            List<Adherent> mesAdh = consulterListeAdherents(mysql);
            if (mesAdh.isEmpty()) {
                return null;
            } else {
                return mesAdh.get(0);
            }
        } catch (MonException e) {
            throw e;
        }
    }

    public Oeuvrevente consulterOeuvre(int id) throws MonException {

        try {
            String mysql = "select * from oeuvrevente where id_oeuvrevente=" + id;
            List<Oeuvrevente> mesOeuvres = consulterListeOeuvres(mysql);
            if (mesOeuvres.isEmpty()) {
                return null;
            } else {
                return mesOeuvres.get(0);
            }
        } catch (MonException e) {
            throw e;
        }
    }

    // Consultation des adh�rents
    // Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
    // la requ�te BDD
    public List<Adherent> consulterListeAdherents() throws MonException {
        String mysql = "select * from adherent";
        return consulterListeAdherents(mysql);
    }

    private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
        List<Object> rs;
        List<Adherent> mesAdherents = new ArrayList<Adherent>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = unDialogueBd.lecture(mysql);
            while (index < rs.size()) {
                // On cr�e un stage
                Adherent unA = new Adherent();
                // il faut redecouper la liste pour retrouver les lignes
                unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
                unA.setNomAdherent(rs.get(index + 1).toString());
                unA.setPrenomAdherent(rs.get(index + 2).toString());
                unA.setVilleAdherent(rs.get(index + 3).toString());

                index = index + 4;
                mesAdherents.add(unA);
            }

            return mesAdherents;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    /**
     * Permet d'afficher la liste des oeuvres
     * @return
     * @throws MonException
     */
    public List<Oeuvrevente> consulterListeOeuvres() throws MonException {
        String mysql = "select * from oeuvrevente";
        return consulterListeOeuvres(mysql);
    }

    private List<Oeuvrevente> consulterListeOeuvres(String mysql) throws MonException {
        List<Object> rs;
        List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = unDialogueBd.lecture(mysql);

            while (index < rs.size()) {

                // On cr�e un stage
                Oeuvrevente uneOeuvre = new Oeuvrevente();
                // il faut redecouper la liste pour retrouver les lignes
                uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
                uneOeuvre.setTitreOeuvrevente(rs.get(index + 1).toString());
                uneOeuvre.setEtatOeuvrevente(rs.get(index + 2).toString());
                uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
                uneOeuvre.setProprietaire(rechercherProprietaire(Integer.parseInt(rs.get(index + 4).toString())));

                index = index + 5;
                mesOeuvres.add(uneOeuvre);
            }

            return mesOeuvres;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    /**
     * Permet d'afficher la liste des proprietaires
     * @return
     * @throws MonException
     */
    public List<Proprietaire> consulterListeProprietaire() throws MonException {
        String mysql = "select * from proprietaire";
        return consulterListeProprietaire(mysql);
    }

    private List<Proprietaire> consulterListeProprietaire(String mysql) throws MonException {
        List<Object> rs;
        List<Proprietaire> mesPropio = new ArrayList<Proprietaire>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = unDialogueBd.lecture(mysql);
            while (index < rs.size()) {
                // On cr�e un stage
                Proprietaire proprio = new Proprietaire();
                // il faut redecouper la liste pour retrouver les lignes
                proprio.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
                proprio.setNomProprietaire(rs.get(index + 1).toString());
                proprio.setPrenomProprietaire(rs.get(index + 2).toString());

                // On incr�mente tous les 3 champs
                index = index + 3;
                mesPropio.add(proprio);
            }

            return mesPropio;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public void deleteAdherent(Adherent adherent) throws MonException {
        //@TODO supprimer les relations avec les oeuvres
        String mysql;
        DialogueBd dialogueBd = DialogueBd.getInstance();
        try {
            mysql = "DELETE FROM adherent WHERE id_adherent=" + adherent.getIdAdherent();
            dialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception ex) {
            throw new MonException(ex.getMessage(), "systeme");
        }
    }


    public Oeuvrevente rechercherOeuvreIdParam(int id) throws MonException {

        String mysql = "";
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Oeuvrevente uneOeuvre = null;
        ;
        try {
            mysql = "SELECT id_oeuvrevente, titre_oeuvrevente, etat_oeuvrevente,prix_oeuvrevente,id_proprietaire";
            mysql += " FROM Oeuvrevente WHERE id_Oeuvrevente = ? ";
            mParam = new HashMap();
            mParam.put(1, id);
            mParams.put(0, mParam);
            rs = DialogueBd.getInstance().lectureParametree(mysql, mParams);
            if (rs.size() > 0) {

                uneOeuvre = new Oeuvrevente();
                uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(0).toString()));
                uneOeuvre.setTitreOeuvrevente(rs.get(1).toString());
                uneOeuvre.setEtatOeuvrevente(rs.get(2).toString());
                uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(3).toString()));
                int num = Integer.parseInt(rs.get(4).toString());
                // On appelle la recherche d'un propri�taire
                uneOeuvre.setProprietaire(rechercherProprietaire(num));
            }
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
        return uneOeuvre;

    }


    public Proprietaire rechercherProprietaire(int id) throws MonException {

        String mysql = "";
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Proprietaire unProprietaire = null;
        mysql = "select * from proprietaire where id_proprietaire = ?";
        try {
            mParam = new HashMap();
            mParam.put(1, id);
            mParams.put(0, mParam);
            rs = DialogueBd.getInstance().lectureParametree(mysql, mParams);
            if (rs.size() > 0) {

                unProprietaire = new Proprietaire();

                unProprietaire.setIdProprietaire(Integer.parseInt(rs.get(0).toString()));
                unProprietaire.setNomProprietaire(rs.get(1).toString());
                unProprietaire.setPrenomProprietaire(rs.get(2).toString());
            }
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
        return unProprietaire;
    }

    public Proprietaire rechercherProprietaire(String nomPrenom) throws MonException {

        String[] identite = nomPrenom.split(" ");
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Proprietaire unProprietaire = null;
        String requete = " select id_proprietaire from proprietaire where nom_proprietaire = ? AND prenom_proprietaire = ?";
        try {
            mParam = new HashMap();
            mParam.put(1, identite[0]);
            mParam.put(2, identite[1]);
            mParams.put(0, mParam);
            rs = DialogueBd.getInstance().lectureParametree(requete, mParams);
            if (rs.size() > 0) {

                unProprietaire = new Proprietaire();

                unProprietaire.setIdProprietaire(Integer.parseInt(rs.get(0).toString()));
                unProprietaire.setNomProprietaire(identite[0]);
                unProprietaire.setPrenomProprietaire(identite[1]);
            }
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
        return unProprietaire;
    }


}
