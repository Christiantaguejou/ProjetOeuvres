package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;

import java.util.*;

import com.epul.oeuvres.metier.*;
import javax.persistence.Query;

import javax.persistence.EntityTransaction;

public class Service extends EntityService {

    /* Insertion d'un adherent
     * param Adherent unAdherent
     * */
    public void insertAdherent(AdherentEntity unAdherent) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.persist(unAdherent);
            transac.commit();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* Lister les adherents
     * */
    public List<AdherentEntity> consulterListeAdherents() throws MonException {
        List<AdherentEntity> mesAdherents = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesAdherents = (List<AdherentEntity>) entitymanager.createQuery("SELECT a FROM AdherentEntity a ORDER BY a.nomAdherent").getResultList();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesAdherents;
    }

    /* Consultation d'une adherent par son numéro
    */
    public AdherentEntity adherentById(int numero) throws MonException {
        List<AdherentEntity> adherents = null;
        AdherentEntity adherent = new AdherentEntity();
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();

            adherents = (List<AdherentEntity>) entitymanager.createQuery("SELECT a FROM AdherentEntity a WHERE a.idAdherent=" + numero).getResultList();
            adherent = adherents.get(0);
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adherent;
    }

    public void test() {
       System.out.println(rechercherProprietaire("DUPONT Isabelle"));
    }

    public void modifyAdherent(AdherentEntity adherent) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.merge(adherent);
            transac.commit();
            entitymanager.close();
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
    public AdherentEntity consulterAdherent(int numero) throws MonException {
        AdherentEntity adherent = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            adherent = entitymanager.find(AdherentEntity.class, numero);
            transac.commit();
            entitymanager.close();
        } catch (Exception ex) {
            throw new MonException(ex.getMessage(), "systeme");
        }

        return adherent;
    }

    public List<OeuvreventeEntity> consulterListeOeuvres() {
        List<OeuvreventeEntity> oeuvresVente = null;
        EntityTransaction transaction = null;
        try {
            transaction = startTransaction();
            transaction.begin();
            oeuvresVente = (List<OeuvreventeEntity>) entitymanager.createQuery("SELECT a FROM OeuvreventeEntity a ORDER BY a.titreOeuvrevente").getResultList();
            entitymanager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oeuvresVente;
    }

    public List<OeuvrepretEntity> consulterListeReservations() {
        List<OeuvrepretEntity> oeuvresPret = null;
        EntityTransaction transaction = null;
        try {
            transaction = startTransaction();
            transaction.begin();
            oeuvresPret = (List<OeuvrepretEntity>) entitymanager.createQuery("SELECT a FROM OeuvrepretEntity a ORDER BY a.titreOeuvrepret").getResultList();
            entitymanager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oeuvresPret;
    }
//    public OeuvreventeEntity get(int numero) throws MonException {
//        List<AdherentEntity> adherents = null;
//        AdherentEntity adherent = new AdherentEntity();
//        try {
//            EntityTransaction transac = startTransaction();
//            transac.begin();
//
//            adherents = (List<AdherentEntity>)entitymanager.createQuery("SELECT a FROM AdherentEntity a WHERE a.idAndherent="+numero).getResultList();
//            adherent = adherents.get(0);
//            entitymanager.close();
//        }catch (RuntimeException e)
//        {
//            new MonException("Erreur de lecture", e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return adherent;
//    }

    public ProprietaireEntity  rechercherProprietaire(String proprio) {
        EntityTransaction transaction = null;
        String[] identite = proprio.split(" ");
        ProprietaireEntity proprietaireEntity=null;
        try {
            transaction = startTransaction();
            transaction.begin();
            String query ="SELECT a FROM ProprietaireEntity a WHERE  a.nomProprietaire='"+identite[0]+"'  AND a.prenomProprietaire='"+identite[1]+"'";
            proprietaireEntity = (ProprietaireEntity) entitymanager.createQuery(query).getSingleResult();
            entitymanager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proprietaireEntity;
    }


    /**
     * Insertion d'une oeuvre dans la BDD
     *
     * @param oeuvre
     * @throws MonException
     */
    public void insertOeuvre(OeuvreventeEntity oeuvre) throws MonException {

        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.persist(oeuvre);
            transac.commit();
            entitymanager.close();
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public void modifyOeuvre(OeuvreventeEntity oeuvre) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.merge(oeuvre);
            transac.commit();
            entitymanager.close();
        } catch (MonException e) {
            throw e;
        } catch (Exception ex) {
            throw new MonException(ex.getMessage(), "systeme");
        }
    }

    public OeuvreventeEntity consulterOeuvre(int id) throws MonException {
        OeuvreventeEntity oeuvre = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            oeuvre = entitymanager.find(OeuvreventeEntity.class, id);
            transac.commit();
            entitymanager.close();
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oeuvre;
    }

    public List<ProprietaireEntity> consulterListeProprietaire() {

        List<ProprietaireEntity> proprietaireEntities = null;
        EntityTransaction transaction = null;
        try {
            transaction = startTransaction();
            transaction.begin();
            proprietaireEntities = (List<ProprietaireEntity>) entitymanager.createQuery("SELECT a FROM ProprietaireEntity a ORDER BY a.idProprietaire").getResultList();
            entitymanager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proprietaireEntities;
    }

    public boolean deleteAdherent(AdherentEntity adherentToDelete) {

        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.remove(entitymanager.merge(adherentToDelete));
            transac.commit();
            entitymanager.close();
        } catch (Exception ex) {
            try {
                throw new MonException(ex.getMessage(), "systeme");
            } catch (MonException e) {
                e.printStackTrace();
            }
        }

        return true;
    }


}
