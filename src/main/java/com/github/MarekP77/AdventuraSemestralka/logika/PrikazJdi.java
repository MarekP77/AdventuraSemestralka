package com.github.MarekP77.AdventuraSemestralka.logika;
import java.util.*;
/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
public class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */    
    public PrikazJdi(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak se vypíše
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) 
        {
            return "Tam se odsud jít nedá!";
        }
        else 
        {
            if(plan.getTaska().obsahujeVec("hůl"))
            {
                return "Se Zemanovou holí nikam jít nemůžeš, zahoď ji.";
            }
            else
            {
                if(sousedniProstor.getNazev().equals("okno"))
                {
                    plan.setAktualniProstor(sousedniProstor);
                    plan.getHra().setKonecHry(true);
                    return "Vyskočil jsi z okna - umřel jsi - konec hry";
                }
                if(sousedniProstor.getNazev().equals("předsíň"))
                {
                    if(plan.getPredsin())
                    {
                        if(plan.getTaska().obsahujeVec("dluhopisy"))
                        {
                            plan.setAktualniProstor(sousedniProstor);
                            plan.getHra().setKonecHry(true);
                            return "Uprchl jsi z Čapího hnízda.\n" + "Konec hry - vyhrál jsi";
                        }
                        else
                        {
                            plan.setAktualniProstor(sousedniProstor);
                            return "Došel jsi na konec hry, ale nemáš dluhopisy, naprav to!";
                        }
                    }
                    else
                    {
                        return "Nejdříve musíš otevřít dveře klíčem.";
                    }
                }
                plan.setAktualniProstor(sousedniProstor);
                return sousedniProstor.dlouhyPopis();
            }
        }
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
