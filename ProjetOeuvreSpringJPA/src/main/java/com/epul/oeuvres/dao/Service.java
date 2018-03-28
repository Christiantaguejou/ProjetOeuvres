package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;

import java.util.*;

import com.epul.oeuvres.metier.*;

import javax.persistence.EntityTransaction;

public class Service extends EntityService {

    private void insert(Object object) throws MonException {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.persist(object);
        transac.commit();
        entitymanager.close();
    }

    private void modify(Object object) throws MonException {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.merge(object);
        transac.commit();
        entitymanager.close();
    }

    private boolean delete(Object object) {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.remove(entitymanager.merge(object));
        transac.commit();
        entitymanager.close();
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
        EntityTransaction transac = startTransaction();
        transac.begin();
        mesAdherents = (List<AdherentEntity>) entitymanager.createQuery("SELECT a FROM AdherentEntity a ORDER BY a.nomAdherent").getResultList();
        entitymanager.close();
        return mesAdherents;
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

    public ProprietaireEntity rechercherProprietaire(String proprio) {
        EntityTransaction transaction = null;
        String[] identite = proprio.split(" ");
        ProprietaireEntity proprietaireEntity = null;
        try {
            transaction = startTransaction();
            transaction.begin();
            String query = "SELECT a FROM ProprietaireEntity a WHERE  a.nomProprietaire='" + identite[0] + "'  AND a.prenomProprietaire='" + identite[1] + "'";
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
        EntityTransaction transac = startTransaction();
        transac.begin();
        oeuvre = entitymanager.find(OeuvreventeEntity.class, id);
        transac.commit();
        entitymanager.close();
        return oeuvre;
    }

    public List<ProprietaireEntity> consulterListeProprietaire() {

        List<ProprietaireEntity> proprietaireEntities = null;
        EntityTransaction transaction = null;
        transaction = startTransaction();
        transaction.begin();
        proprietaireEntities = (List<ProprietaireEntity>) entitymanager.createQuery("SELECT a FROM ProprietaireEntity a ORDER BY a.idProprietaire").getResultList();
        entitymanager.close();
        return proprietaireEntities;
    }

    public List<Reservation> consulterListeReservation() throws Exception {
        List<ReservationEntity> entities = null;
        List<Reservation> reservations = null;
        EntityTransaction transaction = null;
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
        return reservations;
    }

    private Reservation associateObject(ReservationEntity entity) throws MonException {
        Reservation reservation = new Reservation(entity);
        reservation.setAdherent(consulterAdherent(entity.getIdAdherent()));
        reservation.setOeuvre(consulterOeuvre(entity.getIdOeuvrevente()));
        return reservation;
    }

    public ReservationEntity consulterReservation(int adherent, int oeuvre) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public void insertReservation(ReservationEntity reservationToInsert) throws MonException {
        insert(reservationToInsert);
    }

    public boolean deleteReservation(ReservationEntity reservationToDelete) {
        return delete(reservationToDelete);
    }

    public void confirmerReservation(ReservationEntity reservationToConfirm) throws MonException {
        reservationToConfirm.setStatut("confirmée");
        modify(reservationToConfirm);
    }
}
