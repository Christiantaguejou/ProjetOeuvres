package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;

import java.util.*;

import com.epul.oeuvres.metier.*;
import javax.persistence.Query;

import javax.persistence.EntityTransaction;

public class Service extends EntityService {

    private void insert(Object object) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.persist(object);
            transac.commit();
            entitymanager.close();
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    private void modify(Object object) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.merge(object);
            transac.commit();
            entitymanager.close();
        } catch (MonException e) {
            throw e;
        } catch (Exception ex) {
            throw new MonException(ex.getMessage(), "systeme");
        }
    }

    private boolean delete(Object object) {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.remove(entitymanager.merge(object));
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

    /* Insertion d'un adherent
     * param Adherent unAdherent
     * */
    public void insertAdherent(AdherentEntity unAdherent) throws MonException {
        insert(unAdherent);
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
        modify(adherent);
    }

    public boolean deleteAdherent(AdherentEntity adherentToDelete) {
        return delete(adherentToDelete);
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
        insert(oeuvre);
    }

    public void modifyOeuvre(OeuvreventeEntity oeuvre) throws MonException {
        modify(oeuvre);
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

    public List<Reservation> consulterListeReservation() {
        List<ReservationEntity> entities = null;
        List<Reservation> reservations = null;
        EntityTransaction transaction = null;
        try {
            transaction = startTransaction();
            transaction.begin();
            entities = (List<ReservationEntity>) entitymanager.createQuery("SELECT a FROM ReservationEntity a ORDER BY a.dateReservation").getResultList();
            entitymanager.close();
            if (entities != null) {
                reservations = new ArrayList<>();
                for (ReservationEntity entity : entities) {
                    reservations.add(associateObject(entity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservations;
    }

    private Reservation associateObject(ReservationEntity entity) throws Exception{
        Reservation reservation = new Reservation(entity);
        reservation.setAdherent(consulterAdherent(entity.getIdAdherent()));
        reservation.setOeuvre(consulterOeuvre(entity.getIdOeuvrevente()));
        return reservation;
    }

    public ReservationEntity consulterReservation(int adherent, int oeuvre) throws Exception{
        ReservationEntity reservation = null;
        ReservationEntityPK pk = new ReservationEntityPK();
        pk.setIdAdherent(adherent);
        pk.setIdOeuvrevente(oeuvre);
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            reservation = entitymanager.find(ReservationEntity.class, pk);
            transac.commit();
            entitymanager.close();
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public void insertReservation(ReservationEntity reservationToInsert) throws Exception {
        insert(reservationToInsert);
    }

    public boolean deleteReservation(ReservationEntity reservationToDelete) throws Exception{
        return delete(reservationToDelete);
    }

    public void confirmerReservation(ReservationEntity reservationToConfirm) throws Exception{
        reservationToConfirm.setStatut("confirmée");
        modify(reservationToConfirm);
    }
}
