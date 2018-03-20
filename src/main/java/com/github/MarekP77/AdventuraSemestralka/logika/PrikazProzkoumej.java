package com.github.MarekP77.AdventuraSemestralka.logika;
import java.util.*;
/**
 * Třída prozkoumej se stará o výpis informací důležitých pro hráče.
 * Vypisuje se obsah baťůžku a místnost ve které se nachází.
 * @author    Marek Pospíšil
 * @version   1.0
 */
class PrikazProzkoumej implements IPrikaz {
    private static final String NAZEV = "prozkoumej";
    private HerniPlan plan;
    private String Text;

    /**
     * Konstruktor, nastavení herního plánu.
     */    
    public PrikazProzkoumej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Tato metoda se stará o veškerou funkcionalitu uvedenou v základním popisu třídy.
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        Text = "";
        Map<String, Vec> seznam;
        seznam = plan.getTaska().vratSeznamVeci();
        if(seznam.size()==0)
        {
            Text = " nic - igelitová taška je prázdná ";
        }
        else
        {
            for (String key : seznam.keySet()) 
            {
                Text += " " + key;
            }
        }
        return " V igelitové tašce máš: " + Text +" \n Nalézáš se v místnosti: " 
        + plan.getAktualniProstor().getNazev() + "\n" + plan.getAktualniProstor().popisVychodu() 
        + "\n Kolem tebe jsou: " + plan.getAktualniProstor().popisVeci();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}

