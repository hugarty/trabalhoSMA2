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
 Ambiente
 O ambiente é representado por uma área de 50x50 pontos. Onde os agentes coelhos
 e onças convivem. O ambiente começa com espaço de 50% de plantas distribuídas
 aleatoriamente. As plantas sempre crescem aleatoriamente sobre essa área com uma
 taxa de 10% por step. Nosso step (rodada) é de uma semana.

 */
//cada mês tem 4 semanas 
public class Ambiente {
    static int planta = 123;
    
    public Ambiente (){
    }
    
    static void comerPlanta() {
        planta --;
    }

    String ambiente[][] = new String[50][50];

    void ambiente123() 
    {
        for (int x = 0; x < 50; x++) 
        {
            for (int y = 0; y < 50; y++) 
            {
                ambiente [x] [y] = "O";
            }
        }
        
        for (int i = 0; i < 50; i++) 
        {
            for (int j = 0; j < 50; j++) 
            {
                System.out.printf("%s ",ambiente [i] [j]);
            }
            System.out.println("");
        }
    }

}
