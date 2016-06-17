/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugarty
 */

/* 
Onça
 Reprodução: 2 filhotes a cada ano
 Alimentação: 1 coelho por rodada
 Movimentação: 3 passos aleatório, caso encontre coelhos próximos anda 6
passos em direção ao coelho
 Tempo de vida: 8 anos
 Posição inicial: aleatória
 Morte por fome: 3 meses
 Objetivo: sobreviver e reproduzir
 Estratégia: buscar coelhos
*/

//cada mês tem 4 semanas
public class Onca {
    Onca prox;
    int  reproducao =48;
    int x;
    int y;
    int fome = 12;
    int vida = 384;
    
    String animal = "Onça";
    Onca(){
        this.prox=null;
       
        
    }
    //Discernir um animal do outro
    //primeiro valor é o tanto de filhotes
    //segundo é o tempo em semanas que ele demora para nascer
    //primeiro valor é o tanto de grama que ele come
    //segundo é o tempo em semanas que ele demora para comer
    //int [] alimentacao  = {1, 1};
    //O movimento comum(aleatoria) é 3 se ele ver um coelho é 6 atras do coelho
    //int [] movimento = {3,6};
    //contador negativo quando chega a zero morre
    //distancia que ele pode enchegar para qualquer lado
    
    //X e Y do jogador (random de range 50)
    
    //if morte == 0 o cara morre;
    
   public void setPos(int xC, int yC){
       this.x = xC;
       this.y = yC;
   }
    int getY(){
        return this.y;
    }
    int getX(){
        return this.x;
    }
}
