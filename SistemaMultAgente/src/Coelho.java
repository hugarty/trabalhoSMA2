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
Coelho
 Reprodução: 10 filhotes a cada 6 meses
 Alimentação: 1 planta por semana
 Movimentação: 2 passos aleatórios, caso encontre onça próxima anda 4
 passos
 Tempo de vida: 2 anos
 Posição inicial: aleatória
 Morte por fome: 1 mês
 Objetivo: sobreviver e reproduzir
 Estratégia: buscar plantas e fugir da onça
*/

//cada mês tem 4 semanas/round

public class Coelho {
    String animal ="Coelho";
    int reproducao ;
    int x;
    int y;
    int vida;
    int fome;
    Coelho prox;
    
        Coelho () {
            this.vida = 94;
            this.fome= 4;
            this.reproducao=24;
            this.prox =null;
}
//    //primeiro valor é o tanto de filhotes
//    //segundo é o tempo em semanas que ele demora para nascer
//    int [] reproducao = {10, 24};
//    //primeiro valor é o tanto de grama que ele come
//    //segundo é o tempo em semanas que ele demora para comer
//    int [] alimentacao  = {1, 1};
//    //O movimento comum é 2 se ele ver uma onça é 4
//    int [] movimento = {2,4};
//    //contador negativo quando chega a zero morre
//    static int vida = 96;
//    //distancia que ele pode enchegar para qualquer lado
//    int rangeVisão = 3;
//    //X e Y do jogador (random de range 50)
//    static int [] posInicial = {0,0};
//    //if morte == 0 o cara morre;
//    static int mortePorFome = 4;
//    
//    static int quantidade = 0;
//    
   
   public void setPos(int xC, int yC){
       this.x = xC;
       this.y = yC;
   }
   public int getY(){
        return this.y;
    }
  public  int getX(){
        return this.x;
    }
}
