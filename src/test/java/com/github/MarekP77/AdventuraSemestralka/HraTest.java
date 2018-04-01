package com.github.MarekP77.AdventuraSemestralka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.MarekP77.AdventuraSemestralka.logika.Hra;
import com.github.MarekP77.AdventuraSemestralka.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    @Test       // Testování výherního scénáře
    public void testVyhry() {
        assertEquals(false, hra1.konecHry()); // Hra neskončila a hrajem
        hra1.zpracujPrikaz("jdi bar");
        hra1.zpracujPrikaz("jdi knihovna");
        assertEquals(0, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // V tašce nic není
        hra1.zpracujPrikaz("otevři trezor");
        hra1.zpracujPrikaz("seber dluhopisy");
        assertEquals(0, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // V tašce stále nic není, trezor se neotevřel, chce kod
        hra1.zpracujPrikaz("otevři trezor Becherovka");
        hra1.zpracujPrikaz("seber dluhopisy");
        assertEquals(1, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Trezor se otevřel a sebrali jsme dluhopisy
        hra1.zpracujPrikaz("jdi kancelář");
        hra1.zpracujPrikaz("otevři skříňka");
        hra1.zpracujPrikaz("seber klíč");
        hra1.zpracujPrikaz("jdi předsíň");
        assertEquals("kancelář", hra1.getHerniPlan().getAktualniProstor().getNazev()); // stále jsem v kaceláři, předsíň je zavřená
        hra1.zpracujPrikaz("otevři předsíň");
        hra1.zpracujPrikaz("jdi předsíň");
        assertEquals(true, hra1.konecHry()); // Vyhráli jsme
    }

    @Test       // Testování prohry
    public void testProhryOkno() {
        hra1.zpracujPrikaz("jdi bar");
        hra1.zpracujPrikaz("jdi knihovna");
        hra1.zpracujPrikaz("jdi kancelář");
        hra1.zpracujPrikaz("jdi okno");
        assertEquals(true, hra1.konecHry()); // Vyskočili jsme z okna
    }

    @Test       // Testování sbírání / vyhazování věcí / Tašky
    public void MultyTest() 
    {
        Vec a = new Vec ("a",true,"vodka.jpg");    // Příprava testovacích věcí
        Vec b = new Vec ("b",true,"hul.jpg");
        Vec c = new Vec ("c",false,"kybl.jpg");
        Vec d = new Vec ("d",true,"krysa.jpg");

        hra1.getHerniPlan().getAktualniProstor().vlozVec(a);    // Vložení testovacích věcí do mistnosti kde jsme abysme nemuseli chodit po hře
        hra1.getHerniPlan().getAktualniProstor().vlozVec(b);
        hra1.getHerniPlan().getAktualniProstor().vlozVec(c);

        // sbírání věcí
        assertEquals(0, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Taška je prázdná
        hra1.zpracujPrikaz("seber a");  
        assertEquals(1, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Sebrali jsme věc a

        hra1.zpracujPrikaz("seber c");
        assertEquals(1, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Věc c se nedá sebrat, proto máme stále 1 věc
        hra1.zpracujPrikaz("seber b"); 
        assertEquals(2, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size());
        hra1.zpracujPrikaz("seber d"); 
        assertEquals(2, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Taška je plná a žádná věc tak nebyla sebrána

        hra1.zpracujPrikaz("zahoď a");
        assertEquals(1, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Vyhodili jsme věc
        hra1.zpracujPrikaz("seber a");
        assertEquals(2, hra1.getHerniPlan().getBatoh().vratSeznamVeci().size()); // Opět jí mužeme sebrat, nikam nezmizela
    }
}
