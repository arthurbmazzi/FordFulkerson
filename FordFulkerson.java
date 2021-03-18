package FordFulkerson;

public class FordFulkerson 
{
	//Executa o algoritmo
	public int Executar(int grafo[][], int inicio, int fim, int tamanho) 
    {    	   
		//Cria o grafo auxiliar
        int grafoAuxiliar[][] = new int[tamanho][tamanho];

        //Inicializa com uma c�pia do grafo original
        for (int i = 0; i < tamanho; i++) 
            for (int j = 0; j < tamanho; j++) 
            	grafoAuxiliar[i][j] = grafo[i][j];

        //Cria o vetor de vizinhos, inicializa a vari�vel de fluxo m�ximo e inst�ncia um objeto da classe Busca
        int vizinhos[] = new int[tamanho];
        int fluxoMaximo = 0;        
        Busca busca = new Busca();

        //Loop principal, percorre os vizinhos e incrementa o fluxo m�ximo enquanto houverem caminhos na rede
        while (busca.Largura(grafoAuxiliar, inicio, fim, vizinhos, tamanho)) 
        {
            int fluxo = Integer.MAX_VALUE;
            int indiceReverso = vizinhos.length - 1;
            
            for(int i = indiceReverso; i > 0; i = vizinhos[i]) {
                int aux = vizinhos[i];
                fluxo = Math.min(fluxo, grafoAuxiliar[aux][i]);
            }
            
            for(int i = indiceReverso; i > 0; i = vizinhos[i]) 
            {
            	int aux = vizinhos[i];
                grafoAuxiliar[aux][i] -= fluxo;
                grafoAuxiliar[i][aux] += fluxo;
            }

            fluxoMaximo += fluxo;
        }

        //Retorna o valor final
        return fluxoMaximo;
    }
}
