package com.github.MarekP77.AdventuraSemestralka.logika;


/*******************************************************************************
 * Instance třídy {@code Postava} představují postavy v adventuře
 *
 * @author  Marek Pospíšil
 * @version 1.0
 */
public class Postava
{
 private String jmeno;
 private String text;
 
 public Postava(String jmeno,String text)
 {
     this.jmeno = jmeno;
     this.text = text;
 }
 
 public String getJmeno()
 {
     return this.jmeno;
 }
 
 public String getText()
 {
     return this.text;
 }
}
