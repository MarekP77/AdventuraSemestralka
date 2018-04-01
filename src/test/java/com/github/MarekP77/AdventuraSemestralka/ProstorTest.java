package com.github.MarekP77.AdventuraSemestralka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.MarekP77.AdventuraSemestralka.logika.Prostor;
import com.github.MarekP77.AdventuraSemestralka.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2016/2017
 */
public class ProstorTest
{
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
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {		
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě",230,0);
        Prostor prostor2 = new Prostor("bufet", "bufet, kam si můžete zajít na svačinku",430,0);
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }

    @Test
    public void test()
    {
        Prostor prostor1 = new Prostor("a", null,230,0);
        Vec vec1 = new Vec("a", true,"vodka.jpg");
        prostor1.vlozVec(vec1);
        assertSame(vec1, prostor1.odeberVec("a"));
        assertNull(prostor1.odeberVec("b"));
    }
}

