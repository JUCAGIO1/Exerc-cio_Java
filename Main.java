import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static Produto[] listaProdutos = new Produto[5];
    static int opc = 0;
    static int posicao = 0;

    public static void main(String[] args) {
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar um produto");
            System.out.println("2 - Alterar dados de um produto");
            System.out.println("3 - Excluir um produto");
            System.out.println("4 - Listar todos os produtos");
            System.out.println("5 - Sair");

            opc = entrada.nextInt();
            entrada.nextLine();

            switch (opc) {
                case 1 -> {
                    if (posicao < listaProdutos.length) {
                        System.out.println("Cadastrar produto\n");
                        System.out.println("Digite o Id:");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        System.out.println("Digite o Nome:");
                        String nome = entrada.nextLine();

                        System.out.println("Digite o Preço:");
                        float preco = entrada.nextFloat();
                        entrada.nextLine();

                        listaProdutos[posicao] = new Produto(id, nome, preco);
                        posicao++;
                    } else {
                        System.out.println("Lista de produtos cheia!");
                    }
                }
                case 2 -> {
                    System.out.println("Alteração de produto\n\n");
                    System.out.println("Insira a posição do produto:");
                    int p = entrada.nextInt();
                    entrada.nextLine();

                    if (p >= 0 && p < listaProdutos.length && listaProdutos[p] != null) {
                        System.out.println("Digite o novo Nome:");
                        String nome = entrada.nextLine();

                        System.out.println("Digite o novo Preço:");
                        float preco = entrada.nextFloat();
                        entrada.nextLine();

                        listaProdutos[p].setNome(nome);
                        listaProdutos[p].setPreco(preco);
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 3 -> {
                    System.out.println("Excluir Produto\n");
                    System.out.println("Informe a posição do produto:");
                    int p = entrada.nextInt();

                    if (p >= 0 && p < listaProdutos.length && listaProdutos[p] != null) {
                        listaProdutos[p] = null;
                        System.out.println("Produto excluído com sucesso!");
                    } else {
                        System.out.println("Posição inválida ou produto inexistente.");
                    }
                }
                case 4 -> {
                    System.out.println("Lista de produtos:");
                    for (int i = 0; i < listaProdutos.length; i++) {
                        if (listaProdutos[i] != null) {
                            System.out.println("Posição " + i + ": " + listaProdutos[i]);
                        } else {
                            System.out.println("Posição " + i + ": [Vazio]");
                        }
                    }
                }
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opc != 5);
    }
}
