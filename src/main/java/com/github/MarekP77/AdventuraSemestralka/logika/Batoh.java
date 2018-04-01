/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.MarekP77.AdventuraSemestralka.logika;
import java.util.*;
/*******************************************************************************
 * Taška představuje třídu, do které se ukládají jednotlivé věci - nese záznam toho co má člověk  u sebe.
 * @author    Marek Pospíšil
 * @version   1.0
 */
public class Batoh
{
    private Map<String, Vec> seznamVeci;
    private int kapacita = 2;
    // konstruktor
    public Batoh()
    {
        seznamVeci = new HashMap<>();
    }
    // přidání věci
    public boolean vlozVec(Vec vec)
    {
        if(kapacita > seznamVeci.size())
        {
            seznamVeci.put(vec.getNazev(),vec);
            return true;
        }
        else
        {
            return false;
        }
    }
    // vrátí seznam věcí z tašky
    public Map<String, Vec> vratSeznamVeci()
    {
        return this.seznamVeci;
    }
    // vyhodí věc z tašky
    public Vec vyhodVec(String nazev)
    {
        return seznamVeci.remove(nazev);
    }
    // Detekovací metoda, která řekne jestli věc v tašce je či není.
    public Boolean obsahujeVec(String nazev)
    {
        boolean hledana = false;
        Vec pomocna = null;
        pomocna = this.seznamVeci.get(nazev);
        if(pomocna != null)
        {
            hledana = true;
        }
        return hledana;
    }
    // Vrací kapacitu tašky
    public int getKapacita()
    {
        return this.kapacita;
    }
}
