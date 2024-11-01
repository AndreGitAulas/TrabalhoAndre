import java.util.Scanner; //vai servir para importar a classe Scanner


public class Calculadora {//é a classe pública da Calculadora
    public static void main(String[] args) {//por ser procedimento, irá usar void, que é sem retorno
        Scanner scanner = new Scanner(System.in);//criação do Scanner, que vai ler as entradas que o usuário digitar
        int opcao;

        do {//é um loop que vai ficar exibindo o menu até que o usuário escolha sair
            exibirMenu();//função de exibir o menu
            opcao = scanner.nextInt();//irá servir para ler qual opção que o usuário escolheu


            switch (opcao) {//é o switch case, que vai ler qual opção que o usuário escolheu e realizar a operação
                case 1:
                    realizarOperacaoBasica(scanner, "adição");//assim como todos os casos, esse primeiro vai ler a opção escolhida e aí realizar a conta que foi construída logo abaixo no código
                    break;
                case 2:
                    realizarOperacaoBasica(scanner, "subtração");//os casos vão levar diretamente ao switch-case criado abaixo, para as operações básicas
                    break;
                case 3:
                    realizarOperacaoBasica(scanner, "multiplicação");
                    break;
                case 4:
                    realizarOperacaoBasica(scanner, "divisão");
                    break;
                case 5:
                    calcularRaizQuadrada(scanner);
                    break;
                case 6:
                    calcularPotencia(scanner);
                    break;
                case 7:
                    calcularFatorial(scanner);
                    break;
                case 8:
                    mudarSinal(scanner);
                    break;//essa função é diferente das operações, essa vai realizar a troca do sinal
                case 9:
                    calcularLogaritmo(scanner);
                    break;
                case 10:
                    System.out.println("Saindo...");//essa vai ser a função de sair do loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");//caso o usuário digite algo diferente
            }
        } while(opcao != 10); /*while (opcao != 9);//é o enquanto do loop, que vai ficar realizando loop até que o usuário digite 9, e aí para*/


        scanner.close();//para fechar o Scanner
    }

    public static void exibirMenu() {//criação do menu, que vai ficar mostrando para o usuário escolher
        System.out.println("\nCalculadora Simples:");
        System.out.println("1. Adição");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Potência");
        System.out.println("7. Fatorial");
        System.out.println("8. Mudar Sinal");
        System.out.println("9. Logaritmo");//criei nova operação de logaritmo
        System.out.println("10. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void realizarOperacaoBasica(Scanner scanner, String operacao) {//vai servir quando o usuário escolher uma operação básica: adição, subtração, múltiplicação e divisão.
        System.out.print("Digite o primeiro número: ");//usuário digita primeiro número
        double num1 = scanner.nextDouble();//faz a leitura desse número de tipo double
        System.out.print("Digite o segundo número: ");//usuário digita segundo número
        double num2 = scanner.nextDouble();//faz leitura do segundo número de tipo double


        double resultado = 0;//o resultado é pré definido como varíavel double, com valor 0
        switch (operacao) {//switch case para determinar a operação que vai realizar, com base no switch case anterior
            case "adição":
                resultado = somar(num1, num2);//usando as funções que vão ser criadas abaixo, vai realizar essas operações
                break;
            case "subtração":
                resultado = subtrair(num1, num2);//todas operações vão usar as váriaveis tipo double que o usuário escolheu, e vai retornar para a varíavel resultado
                break;
            case "multiplicação":
                resultado = multiplicar(num1, num2);//entendo que utilizou recursividade para criação dessas contas, talvez se fosse eu criando iria dar um jeito de realizar as operações sem necessariamente usar a recursividade
                break;
            case "divisão":
                if (num2 != 0) {//usa if-else, pois o segundo número não pode ser 0, se não a divisão não existe
                    resultado = dividir(num1, num2);
                } else {
                    System.out.println("Erro: Divisão por zero.");//caso usuário escolha 0 como divisor na operação de divisão
                    return;
                }
                break;
        }


        System.out.printf("Resultado da %s: %.2f\n", operacao, resultado);//System Out para mostrar o resultado que deu
    }

    public static double somar(double a, double b) {//foi criado como função que vai realizar as operações, usando duas variáveis de tipo double
        return a + b;//realizar a soma
    }

    public static double subtrair(double a, double b) {
        return a - b;//realizar subtração
    }

    public static double multiplicar(double a, double b) {
        return a * b;//usando asterísco, realiza multiplicação
    }

    public static double dividir(double a, double b) {
        return a / b;//usando / faz a divisão
    }

    public static void calcularRaizQuadrada(Scanner scanner) {//procedimento criado para calcular a raiz quadrada
        System.out.print("Digite o número: ");//pede para o usuário digitar um número
        double num = scanner.nextDouble();//faz a leitura do número como tipo double
        double resultado = Math.sqrt(num);//usando biblioteca matemática, usa o sqrt com a variável e retorna resultado
        System.out.printf("Raiz quadrada de %.2f: %.2f\n", num, resultado);//vai mostrar o resultado para o usuário
    }

    public static void calcularPotencia(Scanner scanner) {//procedimento para calcular a potencia
        System.out.print("Digite a base: ");//pede para o usuário digitar a base da potencia
        double base = scanner.nextDouble();//faz a leitura da base como tipo double, usando scanner
        System.out.print("Digite o expoente: ");//pede para o usuário digitar o expoente
        double expoente = scanner.nextDouble();//faz a leitura do expoente, como tipo double
        double resultado = Math.pow(base, expoente);//usando a biblioteca matemática, usa pow para realizar a potencia entre as duas váriaveis tipo double
        System.out.printf("Resultado de %.2f elevado a %.2f: %.2f\n", base, expoente, resultado);//vai mostrar na tela o resultado
    }

    public static void calcularFatorial(Scanner scanner) {//procedimento para calcular o fatorial
        System.out.print("Digite um número inteiro: ");//pede para usuário digitar o número
        int num = scanner.nextInt();//vai fazer a leitura do número, como inteiro
        if (num < 0) {//usando if-else, se for menor que 0, não possui fatorial definido
            System.out.println("Erro: Fatorial de número negativo não é definido.");
            return;
        }
        long resultado = fatorial(num);//vai calcular fatorial, chamando a função criada abaixo
        System.out.printf("Fatorial de %d: %d\n", num, resultado);//vai mostrar o resultado
    }

    public static long fatorial(int n) {
        if (n == 0) {//se for 0, retorna 1, pois fatorial de 0 é 1
            return 1;
        } else { //se for
            return n * fatorial(n - 1);//calcular a fatorial
        }
    }

    public static void mudarSinal(Scanner scanner) {//procedimento para mudar sinal de um número
        System.out.print("Digite o número: ");//pede para o usuário digitar um número
        double num = scanner.nextDouble();//faz leitura do número como tipo double
        double resultado = -num;//apresenta o resultado como a váriavel double, mas com sinal negativo
        System.out.printf("O número com sinal trocado: %.2f\n", resultado);//mostra o resultado
    }

    public static void calcularLogaritmo(Scanner scanner){//procedimento que vou criar para logaritmo
        System.out.println("Digite o número: ");
        double num = scanner.nextDouble();
        System.out.println("Digite a base do logaritmo: ");
        double base = scanner.nextDouble();
        double resultado = Math.log(num) / Math.log(base);//usando biblioteca matemática, achei essa operação no stackoverflow
        System.out.printf("O logaritmo de %.2f na base %.2f é: %.5f\n", num, base, resultado);//sem usar a formatação correta não aparecia o resultado
    }
}
