
package org.pilat.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.pilat.model.Client;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Party {

    @Id
    @GeneratedValue
    private long partyId;
    private long partyType; //powod / pozwany
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @OneToMany
    private List<Adress> adres;
    @ManyToOne
    private Lawsuit lawsuit;

    
    /**
     * @return the partyId
     */
    public long getPartyId() {
        return partyId;
    }

    /**
     * @param partyId the partyId to set
     */
    public void setPartyId(long partyId) {
        this.partyId = partyId;
    }

    /**
     * @return the partyType
     */
    public long getPartyType() {
        return partyType;
    }

    /**
     * @param partyType the partyType to set
     */
    public void setPartyType(long partyType) {
        this.partyType = partyType;
    }

    /**
     * @return the adres
     */
    public List<Adress> getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(List<Adress> adres) {
        this.adres = adres;
    }

    /**
     * @return the lawsuit
     */
    public Lawsuit getLawsuit() {
        return lawsuit;
    }

    /**
     * @param lawsuit the lawsuit to set
     */
    public void setLawsuit(Lawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
