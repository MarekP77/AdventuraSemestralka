/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.MarekP77.AdventuraSemestralka.main;


import com.github.MarekP77.AdventuraSemestralka.logika.*;
import com.github.MarekP77.AdventuraSemestralka.ui.TextoveRozhrani;

import java.io.File;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author    Jarmila Pavlíčková
 * @version   ZS 2016/2017
 */
public class Start
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {

        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        if(args.length == 0){
            ui.hraj();
        }
        else{
            File soubor = new File(args[0]);
            ui.hrajZeSouboru(soubor);

        }
    }
}
