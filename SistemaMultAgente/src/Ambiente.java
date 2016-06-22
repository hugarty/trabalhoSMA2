
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

    int anos = 50;
    
    public int qtdCoelhosInicial = 80;
    public char ambiente[][] = new char[50][50];
    public int qtdOncasInicial = 16;
    public int qtdPlantasInicial = (int) ((ambiente.length*ambiente.length)*0.5);
    public int nPlantas;
    public int rodadas=1;
  public  gerenciaLista L;
  
//    static void comerPlanta() {
//        planta--;
//    }

    public Ambiente() {
       iniciar_ambiente();
       
    }
   public  void iniciar_ambiente() {
        for (int x = 0; x < ambiente.length; x++) {
            for (int y = 0; y < ambiente.length; y++) {
                ambiente[x][y] = '-';
            }
           
        }
        
    }

    public void start() {
        L = new gerenciaLista();
       adicionarPlantas();
        adicionarCoelhos();
        adicionarOnca();
        L.loading();
        System.out.println("RODADA NUMERO: "+rodadas);
         System.out.println("Numero de plantas: " + L.qtdPlanta);
        System.out.println("Numero de coelhos: " + L.qtdcoelho);
        System.out.println("Numero de oncas: " + L.nOncas);
        L.qtdPlanta=0;
        L.qtdcoelho=0;
L.amb.imprimiTabuleiro();
        this.anos = anos * 48;
        int cont = 0;
       // int cont1=0;
        while (cont < anos) {
            rodadas++;
            L.loading();
            
            L.verificaStatusOnca();
            L.movimentaOnca();
            L.verificaOncaComeuCoelho();
            
          //  if(L.nCoelhos>0){
            L.verificaStatusCoelho();
//            if(L.repCoelho>0){
//                while (cont1 < L.repCoelho*10 ){
//                L.insereCoelho(new Coelho());
//                cont1++;
//                }
//                L.repCoelho=0;
//            }
            L.movimentaCueio();
            L.verificaCoelhoComeuPlanta();
          //  L.removeCoelho(L.ultimoCoelho.x, L.ultimoCoelho.y);
            //L.printaTd();
            System.out.println();
            System.out.println("RODADA NUMERO: "+rodadas);
            System.out.println("Numero de plantas: " + L.qtdPlanta);
            System.out.println("Numero de coelhos: " + L.qtdcoelho);
            System.out.println("Numero de oncas: " + L.nOncas);
            L.amb.imprimiTabuleiro();
            L.qtdPlanta=0;
            L.qtdcoelho=0;
          //  }
           // if(L.nOncas>0){
           // }
            //System.out.println("Fome Cu: "+L.getPrimeiroCueio().fome);
            System.out.println("");
            //L.amb.imprimiTabuleiro();
            
            cont++;
           if(L.nPlantas < 2150){
            reproduzPlantas();
            }
        }

        
   }
   
   void reproduzPlantas(){
       int plantas_filho = (int)(L.nPlantas*0.1);
       int cont = 0;
     //  Planta p = new Planta();
       while (cont < plantas_filho){
           L.inserePlanta(new Planta());
           cont++;
       }
       
   }
   public void adicionarPlantas(){
       int cont = 0 ;
       // Planta p = new Planta();
       while (cont < qtdPlantasInicial){
           
           L.inserePlanta(new Planta());
           cont++;
       }
      
       
       
   }
    public void adicionarCoelhos() {
       
        int cont = 0;
       // INSERE 40 COELHO
        // Coelho c = new Coelho();
        while (cont < qtdCoelhosInicial) {
            L.insereCoelho(new Coelho());
            cont++;
       }
       

       
    }
    
    public void adicionarOnca() {
      
        int cont = 0;
       // INSERE 8 COELHO
        //Onca o = new Onca();
        while (cont < qtdOncasInicial) {
            L.insereOnca(new Onca());
            cont++;
       }
        


       
    }
    
    public void imprimiTabuleiro() {
        for (int i = 0; i < this.ambiente.length; i++) {
            if( i< 10){
                System.out.print("0"+i+" ");
            }else
                System.out.print(i+" ");
        }
        System.out.println("Y X");
        for (int i = 0; i < this.ambiente.length; i++) {
            for (int j = 0; j < this.ambiente.length; j++) {
                System.out.printf(" %c ", this.ambiente[i][j]);
            } 
            System.out.print("  "+i);
            System.out.println("");
        }
   
    }
    
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
