
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
public class gerenciaLista {

    Coelho primeiroCoelho;
    Coelho ultimoCoelho;
    Onca primeiroOnca;
    Onca ultimoOnca;
    Ambiente amb= new Ambiente();
    int nCoelhos;
    int nOncas;

    gerenciaLista() {
        this.primeiroCoelho = null;
        this.primeiroOnca = null;
        this.nCoelhos = 0;
        this.nOncas = 0;
    }
    //INSERE ULTIMO
    void insereCoelho(Coelho novoCoelho) {

        if (primeiroCoelho == null) {
            primeiroCoelho = novoCoelho;
        } 
        if(ultimoCoelho != null){
            ultimoCoelho.prox = novoCoelho;
        }

        ultimoCoelho = novoCoelho;
        
       
            Random rngX = new Random();
            Random rngY = new Random();
            //GERA INDEX X E Y, PRA INSERIR NA MATRIZ
            int rngx = rngX.nextInt(50);
            int rngy = rngY.nextInt(50);
           
            boolean v = false;
            
            //ENQUANTO NOSSO ELEMENTO DE INDEX X E Y GERADO, CONTIVER ALGO Q N SEJA '-', GERA NOVO INDEX X E Y
            while (v==false) {
                if(amb.getElementFromIndex(rngx, rngy) != '-'){
              
              
                rngx = rngX.nextInt(50);
                rngy = rngY.nextInt(50);
                    
                }else{
                    v=true;
                }
            }
            
            //CADA INSERIDA O ULTIMOCOELHO VAI SETANDO SEU ATRIBUTO DE POSIÇAO
            ultimoCoelho.setPos(rngx, rngy);
            
            //SETA ESSE COELHO INSERIDO NA MATRIZ 
            amb.setElement('C', ultimoCoelho.getX(), ultimoCoelho.getY());
          // amb.imprimiTabuleiro();
        nCoelhos++;
           
        }
        
        //ISSO AKI É PRA TESTA SE A LISTA TA ENCADEANDO MESMO. (DE COELHOS)
        void printaLista(){
            int posNaListaCoelho=0;
            Coelho temp=primeiroCoelho;
            while (temp!=null){
                System.out.printf("\nCoelho: %d. Posição dele na matriz. [%d][%d]",posNaListaCoelho,temp.getX(),temp.getY());
                temp = temp.prox;
                posNaListaCoelho++;
            }
               
            System.out.printf("\nHeadCoelho: [%d][%d]",primeiroCoelho.getX(),primeiroCoelho.getY());
            System.out.printf("\nUltimoCoelho: [%d][%d]",ultimoCoelho.getX(),ultimoCoelho.getY());
            
            System.out.printf("\nTamanho da Matriz: [%d]",amb.getMatriz().length);
        }
        
    void insereOnca(Onca novaOnca) {

        if (primeiroOnca == null) {
            primeiroOnca = novaOnca;
        } else {
            ultimoOnca.prox = novaOnca;
        }
        
        ultimoOnca = novaOnca;
        
        Random rngX = new Random();
            Random rngY = new Random();
            //GERA INDEX X E Y, PRA INSERIR NA MATRIZ
            int rngx = rngX.nextInt(50);
            int rngy = rngY.nextInt(50);
           
            boolean v = false;
            
            //ENQUANTO NOSSO ELEMENTO DE INDEX X E Y GERADO, CONTIVER ALGO Q N SEJA '-', GERA NOVO INDEX X E Y
            while (v==false) {
                if(amb.getElementFromIndex(rngx, rngy) != '-'){
              
              
                rngx = rngX.nextInt(50);
                rngy = rngY.nextInt(50);
                    
                }else{
                    v=true;
                }
            }
            
            //CADA INSERIDA O ULTIMOCOELHO VAI SETANDO SEU ATRIBUTO DE POSIÇAO
            ultimoOnca.setPos(rngx, rngy);
            
            //SETA ESSE COELHO INSERIDO NA MATRIZ 
            amb.setElement('O', ultimoOnca.getX(), ultimoOnca.getY());
          // amb.imprimiTabuleiro();
        nOncas++;
    }

        
        //caso cabeça, caso corpo;
    void removeCoelho(int x , int y) {
        //TEMP APONTA PRO MESMO Q O PRIMEIROCOELHO
        Coelho temp = primeiroCoelho;
        //SE O HEAD É O COELHO A SER REMOVIDO. O HEAD PASSA APONTAR PRO PROXIMO.
        if ((primeiroCoelho.getX() == x) && (primeiroCoelho.getY() == y) ) {
            primeiroCoelho = primeiroCoelho.prox;
        } else {
            
                 
                
                //SE FOR O HEAD A SER REMOVIDO, JA FOI DEFINIDO NO IF DE CIMA. AGORA SE NAO É O HEAD PODE SER DA SEGUNDO À ULTIMA LISTA.
                //ENTAO ENQUANTO O TEMP.PROX(Q NO CASO É A SEGUNDA LISTA SE PARTIRMOS Q AINDA ESTAMOS NA PRIMEIRA) FOR DIFERENTE DE NULA.
                //DAI, SE ESSA SEGUNDA LISTA FOR A Q VAI SER REMOVIDA, O Q VAI ACONTECER?
                //O TEMP.PROX VAI PASSAR A APONTAR PARA PARA A PRÓXIMA DA PRÓXIMA DA LISTA 
            
                // https://postimg.org/image/g10rkqyk6/
            while (temp.prox != null) {
                if ((temp.prox.getX() == x) && (temp.prox.getY() ==y ) ) {
                    temp.prox = temp.prox.prox;
                   
                } else {
                    //PERCURSSO
                    temp = temp.prox;
                }
            }

        }

    }

    void removeOnca(Onca onca) {
        Onca temp = primeiroOnca;
        //caso cabeça, caso corpo;
        if (primeiroOnca == onca) {
            primeiroOnca = primeiroOnca.prox;
        } else {

            while (temp.prox != null) {
                if (temp.prox == onca) {
                    temp.prox = temp.prox.prox;
                } else {
                    temp = temp.prox;
                }
            }

        }

    }

  }

//        void printa_Tabuleiro(){
//            //Ambiente ambi =amb; 
//            char[][] matriz= amb.getMatriz();
//            
//            for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length; j++) {
//                System.out.printf("%c ", matriz[i][j]);
//            }
//            System.out.println("");
//        }
//        }