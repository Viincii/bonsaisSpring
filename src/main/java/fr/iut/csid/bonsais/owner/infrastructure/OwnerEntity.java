package fr.iut.csid.bonsais.owner.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name="owner")
@Table(name="owner")
public class OwnerEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = BonsaiEntity.class, mappedBy = "owner", cascade = CascadeType.DETACH)
    private List<BonsaiEntity> bonsais;

    public OwnerEntity() {
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

    public List<BonsaiEntity> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiEntity> bonsais) {
        this.bonsais = bonsais;
    }
}
