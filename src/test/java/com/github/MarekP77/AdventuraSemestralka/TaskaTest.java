/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.MarekP77.AdventuraSemestralka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.MarekP77.AdventuraSemestralka.logika.Taska;
import com.github.MarekP77.AdventuraSemestralka.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída TaskaTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    Marek Pospíšil
 * @version   1.0
 */
public class TaskaTest
{
    private Taska taska;
    private Vec a;
    private Vec b;
    private Vec c;
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        taska = new Taska();
        a = new Vec ("a",true);    
        b = new Vec ("b",true);
        c = new Vec ("c",true);

    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testVlozVec() 
    {
        assertEquals(taska.vlozVec(a), true );
        assertEquals(taska.obsahujeVec("a"), true );
    }   

    @Test
    public void testVyhodVec()
    {
        taska.vlozVec(a);
        assertEquals(taska.vyhodVec(a.getNazev()), a ); 
    }

    @Test
    public void testKapacity()
    {
        assertEquals(0, taska.vratSeznamVeci().size());
        taska.vlozVec(a);
        assertEquals(1, taska.vratSeznamVeci().size());
        taska.vlozVec(b);
        assertEquals(2, taska.vratSeznamVeci().size());
        taska.vlozVec(c);
        assertEquals(2, taska.vratSeznamVeci().size()); // c je nad kapacitu
    }    

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
}
