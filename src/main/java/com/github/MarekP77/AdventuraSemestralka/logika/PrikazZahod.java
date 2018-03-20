package com.github.MarekP77.AdventuraSemestralka.logika;
/**
 * Tato Třída se stará o vyhazování věcí.
 * Prvně zjistí, zda hráč zadal jakou věc chce vyhodit.
 * Následně zjistí, jestli má danou věc v igelitové tašce.
 * Pokuď ano tak jí vyhodí
 * 
 * @author    Marek Pospíšil
 * @version   1.0
 */
class PrikazZahod implements IPrikaz {
    private static final String NAZEV = "zahoď";
    private HerniPlan plan;

    /**
     * Konstruktor třídy, který nastavuje herní plán.
     */    
    public PrikazZahod(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Tato metoda se stará o veškerou funkcionalitu popsanou v základním popisu třídy.
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        if(parametry.length == 0){
            return "Co mám zahodit? Musíš zadat název věci.";
        }
        String nazevVeci = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        if(plan.getTaska().obsahujeVec(nazevVeci))
        {
            Vec vyhozena = plan.getTaska().vyhodVec(nazevVeci);
            aktualniProstor.vlozVec(vyhozena);
            return "Zahodil jsi " + vyhozena.getNazev();
        }
        else
        {
            return "Zadaná věc se v igelitové tašce nevyskytuje.";   
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
