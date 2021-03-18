package FordFulkerson;

import java.util.LinkedList;

public class Busca {
	
	//Algoritmo de busca em largura
	public boolean Largura(int grafoAuxiliar[][], int origem, int destino, int vizinhos[], int tamanho)
    {
        boolean visitados[] = new boolean[tamanho];
        
        //Inicializa a lista de visitados
        for (int i = 0; i < tamanho; ++i) {
        	visitados[i] = false;
        }

        //Adiciona a origem na lista
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(origem);
        visitados[origem] = true;
        vizinhos[origem] = -1;

        //Loop que procura o caminho
        while (!lista.isEmpty()) 
        {
        	//Retorna o primeiro elemento da lista
            int element = lista.poll();
            
            //Itera com base no tamanho da lista, e verifica se o elemento já não está na lista dos visitados e se o elemento tem valor válido
            //Caso positivo o elemento é adicionado na lista e seu pai é atualizado, assim como seu status de visitado. 
            for (int i = 0; i < tamanho; i++) 
            {
                if (visitados[i] == false && grafoAuxiliar[element][i] > 0) 
                {
                	lista.add(i);
                	vizinhos[i] = element;
                    visitados[i] = true;
                }
            }
        }
        
        //Encerra a busca
        return (visitados[destino] == true);
    }
}
