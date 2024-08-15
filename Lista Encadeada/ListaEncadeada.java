package listaencadeada;
import java.util.Scanner;

/**
 *
 * @author andrey
 */
public class ListaEncadeada {
    private Node Lista;

    public ListaEncadeada(){
        this.Lista = null;
    }

    //Inserindo elementos
    public void inserir(int informacao){
        Node no = new Node();
        no.setInformacao(informacao);

        if(Lista == null){
            Lista = no;
        } else {
            Node atual = Lista;
            while(atual.getProximo() != null){
                atual = atual.getProximo();
            }
            atual.setProximo(no);
        }
    }

    //Remover elementos
    public void remover(int posicao) {
        if (Lista == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        if (posicao <= 0) {
            System.out.println("Posição inválida. Deve ser maior que 0.");
            return;
        }

        if (posicao == 1) {
            Lista = Lista.getProximo(); // Move head to the next node
            return;
        }

        Node atual = Lista;
        Node anterior = null;
        int contador = 1;

        while (atual != null && contador < posicao) {
            anterior = atual;
            atual = atual.getProximo();
            contador++;
        }

        if (atual == null) {
            System.out.println("O nó na posição " + posicao + " não existe.");
        } else if (anterior != null) {
            anterior.setProximo(atual.getProximo());
        }
    }


    //Imprimindo elementos
    public void imprime(){
        Node atual = Lista;
        if (atual == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        while (atual != null) {
            System.out.print(atual.getInformacao() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("Acabou");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();
        int opcao;

        do {
            System.out.println("Escolha o que será feito:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Excluir");
            System.out.println("0 - Parar e imprimir");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    System.out.println("Adicione sua Lista Encadeada - 0 para parar:");
                    int item;
                    while (true) {
                        item = scanner.nextInt();
                        if (item == 0) {
                            break;
                        }
                        lista.inserir(item);
                    }
                    System.out.println("Lista Encadeada:");
                    lista.imprime();
                    break;

                case 2:
                    System.out.println("Digite a posição do nó a ser excluído:");
                    int posicao = scanner.nextInt();
                    lista.remover(posicao);
                    lista.imprime();
                    break;

                case 0:
                    System.out.println("Mostrar a Lista Encadeada:");
                    lista.imprime();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
