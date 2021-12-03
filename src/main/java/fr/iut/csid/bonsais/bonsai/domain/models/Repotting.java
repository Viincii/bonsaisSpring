package fr.iut.csid.bonsais.bonsai.domain.models;

import java.util.Date;
import java.util.UUID;

public class Repotting {

    private UUID id_repotting;
    private Date date;
    private Bonsai bonsai;

    public Repotting(UUID id_watering, Date date, Bonsai bonsai) {
        this.id_repotting = id_watering;
        this.date = date;
        this.bonsai = bonsai;
    }

    public UUID getId_repotting() {
        return id_repotting;
    }

    public void setId_repotting(UUID id_repotting) {
        this.id_repotting = id_repotting;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bonsai getBonsai() {
        return bonsai;
    }

    public void setBonsai(Bonsai bonsai) {
        this.bonsai = bonsai;
    }
}
