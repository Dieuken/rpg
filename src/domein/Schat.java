/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

/**
 *
 * @author Anke
 */
public class Schat 
{
    private int idSchat;
    private String omschrijving;
    private int waarde;

    public Schat()
    {
        
    }
    
    public Schat(int idSchat, String omschrijving, int waarde)
    {
        setIdSchat(idSchat);
        setOmschrijving(omschrijving);
        setWaarde(waarde);
    }

    public int getIdSchat()
    {
        return idSchat;
    }

    public void setIdSchat(int idSchat)
    {
        if (idSchat > 0) {
            this.idSchat = idSchat;
        } else {
            throw new IllegalArgumentException("idSchat moet positief zijn");
        }
    }

    public String getOmschrijving()
    {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving)
    {
        if (omschrijving != null && !omschrijving.trim().equals("")) {
            this.omschrijving = omschrijving;
        } else {
            throw new IllegalArgumentException("Omschrijving mag niet leeg zijn");
        }
    }

    public int getWaarde()
    {
        return waarde;
    }

    public void setWaarde(int waarde)
    {
        this.waarde = waarde;
    }

    /*
     * Een toString is nodig in dit voorbeeld. De ListView zal de toString aanroepen om te weten
     * welke tekst moet getoond worden voor deze schat.
     */
    @Override
    public String toString()
    {
        return omschrijving;
    }
}
