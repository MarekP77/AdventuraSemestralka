package com.github.MarekP77.AdventuraSemestralka.logika;

import java.util.Observable;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan extends Observable
{

    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    private Batoh batoh;
    private Hra hra;
    private boolean trezor; // říká zda je trezor otevřený
    private boolean skrinka; // říká zda je skříňka otevřená
    private boolean zamekPredsin; // říká zda je předsíň zamčená či ne
    
    
    
    
    
    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Hra hra) 
    {
        zalozProstoryHry();
        batoh = new Batoh();
        this.hra = hra;
        trezor = false;
        skrinka = false;
        zamekPredsin = false;
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví sklep.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor sklep = new Prostor("sklep", "Zde začínáte hru",230,0);
        Prostor bar = new Prostor("bar", "Zde je cítit zápach Becherovky",430,0);
        Prostor kancelar = new Prostor("kancelář", "Je vybavena drahým nábytkem",230,150);
        Prostor knihovna = new Prostor("knihovna", "Je málo osvětlená",430,150);
        Prostor predsin = new Prostor("předsíň", "Konečná místnost",230,300);
        Prostor okno = new Prostor("okno", "Úniková místnost",0,150);

        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        sklep.setVychod(bar);
        bar.setVychod(sklep);
        bar.setVychod(knihovna);
        knihovna.setVychod(bar);
        knihovna.setVychod(kancelar);
        kancelar.setVychod(knihovna);
        kancelar.setVychod(predsin);
        kancelar.setVychod(okno);
        predsin.setVychod(kancelar);

        aktualniProstor = sklep;  // hra začíná ve sklepě
        viteznyProstor = predsin; // hra konci v přesíni

        Vec vodka = new Vec("vodka",true,"vodka.jpg");
        Vec hul = new Vec("hůl",true,"hul.jpg");
        Vec trezor = new Vec("trezor",false,"trezor.jpg");
        Vec kybl = new Vec("kýbl",true,"kybl.jpg");
        Vec krysa = new Vec("krysa",true,"krysa.jpg");
        Vec stul = new Vec("stůl",false,"stul.jpg");
        Vec zidle = new Vec("židle",false,"zidle.jpg");
        Vec skrinka = new Vec("skříňka",false,"skrinka.jpg");
        
        Postava zeman = new Postava("Zeman","Rád piji Becherovku, to je můj oblíbený nápoj.");
        
        bar.vlozPostavu(zeman);

        bar.vlozVec(vodka);
        bar.vlozVec(hul);
        knihovna.vlozVec(trezor);
        sklep.vlozVec(kybl);
        sklep.vlozVec(krysa);
        kancelar.vlozVec(stul);
        kancelar.vlozVec(zidle);
        kancelar.vlozVec(skrinka);
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;

    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }
    // metoda vrací odkaz na tašku
    public Batoh getBatoh() 
    {
        return this.batoh;
    }
    // metoda vrací odkaz na hru
    public Hra getHra()
    {
        return this.hra;
    }

    public boolean getTrezor()
    {
        return this.trezor;
    }

    public void otevriTrezor()
    {
        trezor = true;
    }

    public boolean getSkrinka()
    {
        return this.skrinka;
    }

    public void otevriSkrinku()
    {
        skrinka = true;
    }

    public boolean getPredsin()
    {
        return this.zamekPredsin;
    }

    public void otevriPredsin()
    {
        zamekPredsin = true;
    }
    
    @Override
    public void notifyObservers(){
        setChanged();
        super.notifyObservers();
    }
}

