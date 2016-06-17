
import java.util.Random;

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
  
    public int qtdCoelhos = 40;
//    static int planta = 123;
   public char ambiente[][] = new char[50][50];

//    static void comerPlanta() {
//        planta--;
//    }
   public  Ambiente(){
       iniciar_ambiente();
       
    }
   public  void iniciar_ambiente() {
        for (int x = 0; x < this.ambiente.length; x++) {
            for (int y = 0; y < this.ambiente.length; y++) {
                this.ambiente[x][y] = '-';
            }
        }
    }
   public void start(){
   //iniciar_populacao(); 
       adicionarCoelhos();
//       setElement('C', 0, 0);
       // imprimiTabuleiro();
   }
    public void adicionarCoelhos() {
        
       gerenciaLista L = new gerenciaLista();
      
        
        int cont = 0;
        //INSERE 40 COELHO
        while (cont < qtdCoelhos) {
            L.insereCoelho(new Coelho());
            cont++;
       }
        L.printaLista();
        L.removeCoelho(L.primeiroCoelho.prox.getX(), L.primeiroCoelho.prox.getY());
       // L.printa_Tabuleiro();
        L.printaLista();
        System.out.println("\nNumero de coelhos: " + L.nCoelhos);
    }
    
//    public void imprimiTabuleiro() {
//        for (int i = 0; i < this.ambiente.length; i++) {
//            for (int j = 0; j < this.ambiente.length; j++) {
//                System.out.printf("%c ", this.ambiente[i][j]);
//            }
//            System.out.println("");
//        }
//    }
    
    //RETORNA MATRIZ
    public char[][] getMatriz(){
        return this.ambiente;
    }
    
    //RETORNA ELEMENTO, DADO INDEX
    public char getElementFromIndex(int x, int y) {

        return this.ambiente[x][y];
    }
    
    //SETA UM ELEMENTO NA MATRIZ, PASSAR DADO, INDEX X E INDEX Y
    public void setElement(char v, int x, int y){
        this.ambiente[x][y] =v ;
    }
    
    
}
