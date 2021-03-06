package fr.iut.csid.bonsais.common;

import fr.iut.csid.bonsais.bonsai.exposition.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "acquisition_date")
    private String acquisition_date;

    @Column(name = "acquisition_age")
    private int acquisition_age;

    @ManyToOne
    @JoinColumn(name = "id_owner")
    private OwnerEntity owner;

    @OneToMany(targetEntity = WateringEntity.class, mappedBy="bonsai", cascade = CascadeType.REMOVE)
    private List<WateringEntity> listWatering;

    @OneToMany(targetEntity = PruningEntity.class, mappedBy="bonsai", cascade = CascadeType.REMOVE)
    private List<PruningEntity> listPruning;

    @OneToMany(targetEntity = RepottingEntity.class, mappedBy="bonsai", cascade = CascadeType.REMOVE)
    private List<RepottingEntity> listRepotting;


    public BonsaiEntity(){

    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public List<WateringEntity> getListWatering() {
        return listWatering;
    }

    public void setListWatering(List<WateringEntity> listWatering) {
        this.listWatering = listWatering;
    }

    public List<PruningEntity> getListPruning() {
        return listPruning;
    }

    public void setListPruning(List<PruningEntity> listPruning) {
        this.listPruning = listPruning;
    }

    public List<RepottingEntity> getListRepotting() {
        return listRepotting;
    }

    public void setListRepotting(List<RepottingEntity> listRepotting) {
        this.listRepotting = listRepotting;
    }
}
