/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado_labp2;

/**
 *
 * @author Tommy Lee Pon
 */
public class JugarAhorcadoFijo extends JuegoAhorcadoBase{
    private String memoria;
    
    public JugarAhorcadoFijo(){
        palabraActual="";
        super.palabraSecreta=inicializarPalabraSecreta();
        for(int i=0; i<this.palabraSecreta.length();i++)
            palabraActual=palabraActual+" ";
        intentos=10;
        
    }
    
    @Override
    public String actualizarPalabraActual(char letra){
        memoria=palabraActual;
        palabraActual="";
        for(int i=0; i<palabraSecreta.length();i++){
            if(palabraSecreta.charAt(i)==letra){
                palabraActual+=letra;
            } else if(palabraSecreta.charAt(i)==memoria.charAt(i)){
                palabraActual+=memoria.charAt(i);
            } else {
                palabraActual+=" ";
            }
        }
        return palabraActual;
    }
    
    @Override
    public boolean verificarLetra(char letra){
        for(int i=0; i<palabraSecreta.length();i++){
            if(palabraSecreta.charAt(i)==letra)
                return true;
        }
        intentos--;
        return false;
    }
    
    @Override
    public boolean hasGanado(){
        return palabraSecreta.equals(palabraActual);                    
    }
    
    @Override
    public boolean jugar(char letra){
        palabraActual=actualizarPalabraActual(letra);
        verificarLetra(letra);
        if(hasGanado()){
            return true;
        }
        return false;
    }

    @Override
    public String inicializarPalabraSecreta() {
        return AdminPalabrasAzar.lista.get(0);
    }

}
