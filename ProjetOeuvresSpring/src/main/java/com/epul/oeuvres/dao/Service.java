package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import java.util.*;

import com.epul.oeuvres.metier.*;
import org.hibernate.Query;

import javax.persistence.EntityTransaction;

public class Service extends EntityService{

	/* Insertion d'un adherent
	 * param Adherent unAdherent
	 * */
	public void insertAdherent(AdherentEntity unAdherent) throws MonException {
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.persist(unAdherent);
			transac.commit();
			entitymanager.close();
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/* Lister les adherents
	 * */
	public List<AdherentEntity> consulterListeAdherents() throws MonException {
		List<AdherentEntity> mesAdherents = null;
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesAdherents = (List<AdherentEntity>)entitymanager.createQuery("SELECT a FROM AdherentEntity a ORDER BY a.nomAdherent").getResultList();
			transac.commit();
			entitymanager.close();
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mesAdherents;
	}

	/* Consultation d'une adherent par son numéro
	*/
	public AdherentEntity adherentById(int numero) throws MonException {
		AdherentEntity adherent = new AdherentEntity();
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			adherent = entitymanager.find(AdherentEntity.class, numero);
			transac.commit();
			entitymanager.close();
		}catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adherent;
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
		try{
			EntityTransaction transac = startTransaction();
			transac.begin();
			adherent = entitymanager.find(AdherentEntity.class, numero);
			transac.commit();
			entitymanager.close();
		}catch (Exception ex) {
			throw new MonException(ex.getMessage(), "systeme");
		}

		return adherent;
	}

	/**
	 * Insertion d'une oeuvre dans la BDD
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
			oeuvre =  entitymanager.find(OeuvreventeEntity.class, id);
			transac.commit();
			entitymanager.close();
		} catch (MonException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oeuvre;
	}
}
