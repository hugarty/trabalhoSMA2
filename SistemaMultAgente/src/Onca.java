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
    
    Onca(){
        this.prox=null;
        
    }
    //Discernir um animal do outro
    String animal = "Onça";
    //primeiro valor é o tanto de filhotes
    //segundo é o tempo em semanas que ele demora para nascer
    int [] reproducao = {2, 48};
    //primeiro valor é o tanto de grama que ele come
    //segundo é o tempo em semanas que ele demora para comer
    int [] alimentacao  = {1, 1};
    //O movimento comum(aleatoria) é 3 se ele ver um coelho é 6 atras do coelho
    int [] movimento = {3,6};
    //contador negativo quando chega a zero morre
    int vida = 384;
    //distancia que ele pode enchegar para qualquer lado
    int rangeVisão = 4;
    //X e Y do jogador (random de range 50)
    int [] posInicial = {0,0};
    //if morte == 0 o cara morre;
    int mortePorFome = 12;
    
}
