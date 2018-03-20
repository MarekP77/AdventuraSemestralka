package com.github.MarekP77.AdventuraSemestralka.logika;

/**
 *  Třída PrikazMluv implementuje pro hru příkaz mluv.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author    Marek Pospíšil
 * @version   1.0
 */
class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */    
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda mluv implementuje mluvení se Zemanem

     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "S kým mám mluvit, zadej jméno postavy.";
        }

        String nazevPostavy = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();

        if(nazevPostavy.equals("Zeman"))
        {
            if(aktualniProstor.getNazev().equals("bar"))
            {
                return aktualniProstor.getPostava("Zeman").getText();
            }
            else
            {
                return "Zeman v této místnosti není.";
            }
        }
        else
        {
            return "Mluvit lze jenom se Zemanem.";
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