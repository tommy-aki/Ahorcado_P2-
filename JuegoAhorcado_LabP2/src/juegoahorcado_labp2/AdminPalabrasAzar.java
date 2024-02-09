/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado_labp2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Tommy Lee Pon
 */
public class AdminPalabrasAzar {
    protected static ArrayList<String> lista=new ArrayList();
    
    public AdminPalabrasAzar(){
        
    }
    
    public static void addPalabra(String palabra){
        palabra=palabra.toLowerCase();
        lista.add(palabra);
    }
    
    private static boolean buscar(String palabra, int cero){
        if (cero<lista.size()){
            if(lista.get(cero).equals(palabra))
                return true;
            return buscar(palabra, cero+1);
        }
        return false;
    }
    
    public static boolean quitarPalabras(String palabra){
        if(buscar(palabra, 0)==true){
            lista.remove(palabra);
            return true;
        }
        return false;
    }
    
    public static String ranWord(){
        Random rng=new Random();
        int index=rng.nextInt(lista.size());
        return lista.get(index);
    }
    
    public static String toString(int cero){
        /*String ret="";
        for(int i=0; i<lista.size();i++){
            ret+=lista.get(i) + "\n";
        }
        return ret;*/
        if(cero<lista.size()){
            return lista.get(cero) + "\n" + toString(cero+1);
        }
        return "";
    }
}
