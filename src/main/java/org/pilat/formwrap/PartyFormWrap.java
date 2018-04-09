/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.formwrap;

import org.pilat.model.Party;
import org.pilat.model.Client;

/**
 *
 * @author Pilat
 */
public class PartyFormWrap {

private Party party;
private Client client;

    public PartyFormWrap(Party party, Client client) {
        this.party = party;
        this.client = client;
    }

    public PartyFormWrap() {
        this.party = new Party();
        this.client = new Client();
    }

    /**
     * @return the party
     */
    public Party getParty() {
        return party;
    }

    /**
     * @param party the party to set
     */
    public void setParty(Party party) {
        this.party = party;
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
