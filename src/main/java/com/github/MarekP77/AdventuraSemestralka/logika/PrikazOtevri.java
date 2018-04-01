package com.github.MarekP77.AdventuraSemestralka.logika;

/**
 *  Třída PrikazOtevri implementuje pro hru příkaz otevri.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author    Marek Pospíšil
 * @version   1.0
 */
class PrikazOtevri implements IPrikaz {
    private static final String NAZEV = "otevři";
    private HerniPlan plan;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazOtevri(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda která zajišťuje otevírání lednice
     * 
     *@param parametry - parametrem je co chce hráč otevřít
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        if (parametry.length == 0) 
        {
            return "Co mám otevřít? Nevím.";
        }

        String nazev = parametry[0];
        String kod = "";
        if(parametry.length > 1)
        {
          kod = kod + parametry[1]; 
        }
        Prostor aktualni = plan.getAktualniProstor();
        if(nazev.equals("trezor"))
        {
            if(aktualni.jeVecVProstoru(nazev))
            {
                if(!plan.getTrezor()) // pokud je trezor zavřený
                {
                    if(kod.equals("Becherovka"))
                    {
                        plan.otevriTrezor();
                        Vec dluhopisy = new Vec ("dluhopisy",true,"dluhopis.jpg");
                        aktualni.vlozVec(dluhopisy);
                        return "Otevřel jsi trezor a dluhopisy vypadly do místnosti.";
                    }
                    else
                    {
                        return "Zadej Zemanův oblíbený nápoj příkazem otevři jako kod \n ( otevři trezor kod )";
                    }
                }
                else
                {
                    return "Trezor již je otevřený.";
                }
            }
            else
            {
                return "Trezor v této místnosti není.";
            }
        }
        if(nazev.equals("skříňka"))
        {
            if(aktualni.jeVecVProstoru(nazev))
            {
                if(!plan.getSkrinka()) // pokud je skříňka zavřená
                {
                    plan.otevriSkrinku();
                    Vec klic = new Vec ("klíč",true,"klic.jpg");
                    aktualni.vlozVec(klic);
                    return "Otevřel jsi skříňku a klíč vypadl do místnosti";
                }
                else
                {
                    return "Skříňka je již otevřená.";
                }
            }
            else
            {
                return "Skříňka v této místnosti není.";
            }
        }
        if(nazev.equals("předsíň"))
        {
            if(aktualni.getNazev().equals("kancelář"))
            {
               if(plan.getBatoh().obsahujeVec("klíč"))
               {    
                    if(!plan.getPredsin())
                    {
                       plan.otevriPredsin();
                       return "Otevřel jsi předsíň!";
                    }
                    else
                    {
                        return "Předsíň už je otevřená.";
                    }
               }
               else
               {
                   return "K otevření předsíně potřebuješ klíč.";
               }
            }
            else
            {
                return "Předsíň se z této místnosti otevřít nedá - jdi do kanceláře.";
            }
        }
        
        return "Zadaná věc/místnost se otevřít nedá.";

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
