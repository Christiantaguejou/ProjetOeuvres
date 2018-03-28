package com.epul.oeuvres.metier;

public class Reservation {

    private ReservationEntity entity;
    private OeuvreventeEntity oeuvre;
    private AdherentEntity adherent;

    public Reservation(ReservationEntity reservationEntity) {
        this.entity = reservationEntity;
    }

    public ReservationEntity getEntity() {
        return entity;
    }

    public void setEntity(ReservationEntity entity) {
        this.entity = entity;
    }

    public OeuvreventeEntity getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(OeuvreventeEntity oeuvre) {
        this.oeuvre = oeuvre;
    }

    public AdherentEntity getAdherent() {
        return adherent;
    }

    public void setAdherent(AdherentEntity adherent) {
        this.adherent = adherent;
    }
}
