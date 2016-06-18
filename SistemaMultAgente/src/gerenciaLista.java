
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
    Ambiente amb = new Ambiente();
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
        if (ultimoCoelho != null) {
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
        while (v == false) {
            if (amb.getElementFromIndex(rngx, rngy) != '-') {

                rngx = rngX.nextInt(50);
                rngy = rngY.nextInt(50);

            } else {
                v = true;
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
    void printaLista() {
        int posNaListaCoelho = 0;
        Coelho temp = primeiroCoelho;
        while (temp != null) {
            System.out.printf("\nCoelho: %d. Posição dele na matriz. [%d][%d]", posNaListaCoelho, temp.getX(), temp.getY());
            temp = temp.prox;
            posNaListaCoelho++;
        }

        System.out.printf("\nHeadCoelho: [%d][%d]", primeiroCoelho.getX(), primeiroCoelho.getY());
        System.out.printf("\nUltimoCoelho: [%d][%d]", ultimoCoelho.getX(), ultimoCoelho.getY());

        System.out.printf("\nTamanho da Matriz: [%d]", amb.getMatriz().length);
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
        while (v == false) {
            if (amb.getElementFromIndex(rngx, rngy) != '-') {

                rngx = rngX.nextInt(50);
                rngy = rngY.nextInt(50);

            } else {
                v = true;
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
    void removeCoelho(int x, int y) {
        //TEMP APONTA PRO MESMO Q O PRIMEIROCOELHO
        Coelho temp = primeiroCoelho;
        //SE O HEAD É O COELHO A SER REMOVIDO. O HEAD PASSA APONTAR PRO PROXIMO.
        if ((primeiroCoelho.getX() == x) && (primeiroCoelho.getY() == y)) {
            primeiroCoelho = primeiroCoelho.prox;
        } else {

                //SE FOR O HEAD A SER REMOVIDO, JA FOI DEFINIDO NO IF DE CIMA. AGORA SE NAO É O HEAD PODE SER DA SEGUNDO À ULTIMA LISTA.
            //ENTAO ENQUANTO O TEMP.PROX(Q NO CASO É A SEGUNDA LISTA SE PARTIRMOS Q AINDA ESTAMOS NA PRIMEIRA) FOR DIFERENTE DE NULA.
            //DAI, SE ESSA SEGUNDA LISTA FOR A Q VAI SER REMOVIDA, O Q VAI ACONTECER?
            //O TEMP.PROX VAI PASSAR A APONTAR PARA PARA A PRÓXIMA DA PRÓXIMA DA LISTA 
            // https://postimg.org/image/g10rkqyk6/
            while (temp.prox != null) {
                if ((temp.prox.getX() == x) && (temp.prox.getY() == y)) {
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
    
    
    public void movimentaOnca(Onca x) {
        int[] visao;
        while(x != null){
            amb.setElement('-', x.getX(), x.getY());
            System.out.println("Antes - X: "+x.getX()+" - Y: "+x.getY());
            visao = visaoOnca(x);
            int cont = 0;
            //Se tiver algum coelho na area de visão dele
            if (visao[0] != -1) {
                x.setPos(visao[0], visao[1]);
                amb.setElement('O', visao[0], visao[1]);
            } //Se não tiver
            else {
                visao[0] = x.getX();
                visao[1] = x.getY();
                Random ale = new Random();
                int auxiliar;
                
                while(cont < 3){
                    auxiliar = ale.nextInt(4)+2;

                    if(auxiliar % 2 == 0){
                        if(auxiliar <= 3){
                            visao[0]--;
                        }else
                            visao[0]++;
                    } 
                    else
                    {
                        if (auxiliar <= 3) {
                            visao[1]--;
                        } 
                        else 
                            visao[1]++;
                    }
                    cont++;
                }
                
                if(visao[0] < 0){
                     visao[0] = 0;
                }
                else
                if(visao[0]> 49){
                    visao[0] = 49;
                }
                else
                if(visao[1] < 0){
                    visao[1] = 0;
                }
                else
                if(visao[1] > 49) {
                    visao[1] = 49;
                }
                
                x.setPos(visao[0], visao[1]);
                
                amb.setElement('O', visao[0], visao[1]);
            }
            System.out.println("Depois - X: "+x.getX()+" - Y: "+x.getY());
            System.out.println("---------------------");
            x = x.prox;
        }
    }

    //onca vai ser visão 6  

    private int[] visaoOnca(Onca x) {
        int[] achou = new int [2];
        int X = x.getX();
        int Y = x.getY();
        int auxX1 = 6;
        int auxX2 = 6;
        int auxY10 = 6;
        int auxY20 = 6;
        if (X - 6 < 0) {
            auxX1 = verificaZero(X, auxX1);
        }
        if (Y - 6 < 0) {
            auxY10 = verificaZero(Y, auxY10);
        }
        if (X + 6 > 49) {
            auxX2 = verificaQn(X, auxX2);
        }
        if (Y + 6 > 49) {
            auxY20 = verificaQn(Y, auxY20);
        }
        for (int i = (X - auxX1); i <= (X + auxX2); i++) {
            for(int j = (Y - auxY10); j <= (Y + auxY20); j++)
            {
                if(amb.ambiente [i][j] =='C')
                {
                    achou[0]= i;
                    achou[1]= j;
                    return achou;
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    public void movimentaCueio(Coelho x)
    {
        int[] visao;
        while(x != null){
            amb.setElement('-', x.getX(), x.getY());
            System.out.println("Antes - X: "+x.getX()+" - Y: "+x.getY());
            visao = visaoCueio(x);
            int cont = 0;
            //Se tiver algum coelho na area de visão dele
            if (visao[0] != -1) {
                x.setPos(visao[0], visao[1]);
                amb.setElement('C', visao[0], visao[1]);
            } //Se não tiver
            else {
                visao[0] = x.getX();
                visao[1] = x.getY();
                Random ale = new Random();
                int auxiliar;
                
                while(cont < 2){
                    auxiliar = ale.nextInt(4)+2;

                    if(auxiliar % 2 == 0){
                        if(auxiliar <= 3){
                            visao[0]--;
                        }else
                            visao[0]++;
                    } 
                    else
                    {
                        if (auxiliar <= 3) {
                            visao[1]--;
                        } 
                        else 
                            visao[1]++;
                    }
                    cont++;
                }
                
                if(visao[0] < 0){
                     visao[0] = 0;
                }
                else
                if(visao[0]> 49){
                    visao[0] = 49;
                }
                else
                if(visao[1] < 0){
                    visao[1] = 0;
                }
                else
                if(visao[1] > 49) {
                    visao[1] = 49;
                }
                
                x.setPos(visao[0], visao[1]);
                
                amb.setElement('C', visao[0], visao[1]);
            }
            System.out.println("Depois - X: "+x.getX()+" - Y: "+x.getY());
            System.out.println("---------------------");
            x = x.prox;
        }
    }
    
    private int[] visaoCueio(Coelho x) {
        int[] fugir = new int [2];
        int X = x.getX();
        int Y = x.getY();
        int auxX1 = 4;
        int auxX2 = 4;
        int auxY10 = 4;
        int auxY20 = 4;
        if (X - 4 < 0) {
            auxX1 = verificaZero(X, auxX1);
        }
        if (Y - 4 < 0) {
            auxY10 = verificaZero(Y, auxY10);
        }
        if (X + 4 > 49) {
            auxX2 = verificaQn(X, auxX2);
        }
        if (Y + 4 > 49) {
            auxY20 = verificaQn(Y, auxY20);
        }
        for (int i = (X - auxX1); i <= (X + auxX2); i++) {
            for(int j = (Y - auxY10); j <= (Y + auxY20); j++)
            {
                if(amb.ambiente [i][j] =='O')
                {
                    if(X < i)
                    {
                        if (Y < j) {
                            //Essa subtração aqui é pra fugir dus animal
                            X = X - 4;
                            Y = Y - 4;
                            if (X < 0) {
                                X= verificaZero(X, auxX1);
                            }
                            if (Y < 0) {
                                Y = verificaZero(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }else
                        if(Y >= j)
                        {
                            X = X - 4;
                            Y = Y + 4;
                            if (X < 0) {
                                X= verificaZero(X, auxX1);
                            }
                            if (Y > 49) {
                                Y = verificaQn(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }else
                        {
                            
                            X = X - 4;
                            if (X < 0) {
                                X = verificaZero(X, auxX1);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }
                    }else
                    if(X > i)
                    {
                        if(Y < j){
                            //Essa subtração aqui é pra 
                            X = X + 4;
                            Y = Y - 4;
                            if (X > 49) {
                                X= verificaQn(X, auxX1);
                            }
                            if (Y < 0) {
                                Y = verificaZero(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }else
                        if(Y > j)
                        {
                            X = X + 4;
                            Y = Y + 4;
                            if (X > 49) {
                                X= verificaQn(X, auxX1);
                            }
                            if (Y > 49) {
                                Y = verificaQn(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }else
                        {
                            X = X + 4;
                            if (X > 49) {
                                X= verificaQn(X, auxX1);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }
                    }else
                    {
                        if(Y < j){
                            Y = Y - 4;
                            if (Y < 0) {
                                Y = verificaZero(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }else
                        if(Y > j)
                        {
                            Y = Y + 4;
                            if (Y > 49) {
                                Y = verificaQn(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }else
                        {
                            //AQUI OU O CUELHO MORREU OU A ONÇA TA TROLLANDO
                            X = X - 4;
                            Y = Y - 4;
                            if (X < 0) {
                                X= verificaZero(X, auxX1);
                            }
                            if (Y < 0) {
                                Y = verificaZero(Y, auxY10);
                            }
                            fugir[0] = X;
                            fugir[1] = Y;
                            return fugir;
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
    public Onca getPrimeiraOnca() {
        return primeiroOnca;
    }
    public Coelho getPrimeiraCueio() {
        return primeiroCoelho;
    }
    private int verificaZero(int X, int aux) {
        while (X - aux != 0) {
            aux++;
        }
        return aux;
    }

    private int verificaQn(int X, int aux) {
        while (X + aux != 49) {
            aux--;
        }
        return aux;
    }

    
}


/*
 Grama
 Verificar Caça coelho
 Verificar Caça Onça
 Visão
 Verificar os Status
 Alterar os status
 Movimentação
 */
