/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

/**
 *
 * @author GJ
 */
public class Item {
    
    private int iditems;
    private String naam;
    private int waarde;
    private String omschrijving;

    public Item(int iditems, String naam, int waarde, String omschrijving) {
        this.iditems = iditems;
        this.naam = naam;
        this.waarde = waarde;
        this.omschrijving = omschrijving;
    }

    public int getIditems() {
        return iditems;
    }

    public void setIditems(int iditems) {
        this.iditems = iditems;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

 
}
