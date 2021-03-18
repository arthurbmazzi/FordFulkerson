package FordFulkerson;

import java.util.Random;

public class Principal {

    static final int tamanho = 1000;     

    public static void main(String[] args) throws java.lang.Exception 
    {
    	//Inicializa a classe do algoritmo
    	FordFulkerson ff = new FordFulkerson();
    	
    	//Cria a matriz de números aleatórios
    	Random rand = new Random();
    	int[][] grafo = new int[tamanho][tamanho];
    	
    	for(int i=0;i<tamanho;i++)
    	    for(int j=0;j<tamanho;j++)
    	       grafo[i][j]=rand.nextInt(100);  	
       
    	//Imprime o grafo inicial
        System.out.println("Grafo:");        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print("\t" + grafo[i][j]);
            }
            System.out.print("\n");
        }            
        
        //Executa o algoritmo e marca o tempo de execução
        long startTime = System.nanoTime();
        System.out.println("\n\nFluxo Máximo: " + ff.Executar(grafo, 0, tamanho - 1, tamanho));
        long stopTime = System.nanoTime();
        System.out.println("Tempo de execução: " + (stopTime - startTime));
    }
}