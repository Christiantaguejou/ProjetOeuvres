package com.epul.oeuvres.metier;

import javax.persistence.*;

@Entity
@Table(name = "oeuvrepret", schema = "baseoeuvre", catalog = "")
public class OeuvrepretEntity {
    private int idOeuvrepret;
    private String titreOeuvrepret;
    private int idProprietaire;
    private ProprietaireEntity proprietaireEntity;

    @Id
    @Column(name = "id_oeuvrepret")
    public int getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(int idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    @Basic
    @Column(name = "titre_oeuvrepret")
    public String getTitreOeuvrepret() {
        return titreOeuvrepret;
    }

    public void setTitreOeuvrepret(String titreOeuvrepret) {
        this.titreOeuvrepret = titreOeuvrepret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OeuvrepretEntity that = (OeuvrepretEntity) o;

        if (idOeuvrepret != that.idOeuvrepret) return false;
        if (titreOeuvrepret != null ? !titreOeuvrepret.equals(that.titreOeuvrepret) : that.titreOeuvrepret != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOeuvrepret;
        result = 31 * result + (titreOeuvrepret != null ? titreOeuvrepret.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "id_proprietaire")
    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public void setProprietaireEntity(ProprietaireEntity proprietaireEntity) {
        this.proprietaireEntity = proprietaireEntity;
    }
    @ManyToOne
    @JoinColumn(name = "id_proprietaire",referencedColumnName = "id_proprietaire",nullable = false)
    public ProprietaireEntity getProprietaireEntity() {
        return proprietaireEntity;
    }
}
