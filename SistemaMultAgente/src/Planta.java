/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Filipe
 */
public class Planta {
   public Planta prox;
    
    int x;
    int y;
    
    public Planta(){
        this.prox = null;
    }
    public void setPos(int x, int y){
        this.x= x;
        this.y = y;
        
    }
    
}
