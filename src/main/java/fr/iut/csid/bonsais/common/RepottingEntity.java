package fr.iut.csid.bonsais.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "repotting")
@Table(name = "repotting")
public class RepottingEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id_repotting;

    @Column(name = "datetime")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_bonsai")
    private BonsaiEntity bonsai;

    public RepottingEntity() {
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

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}
