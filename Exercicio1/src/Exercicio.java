/**
 *
 *  Trabalho Interdisciplinar 2 : BD e SI
 *  Exercicio 1 - Programa em Java que some dois números
 * 
 *  Nome: Larissa Valadares Silqueira
 *  Matricula: 754065-5
 * 
 *  Autoavaliação: 5 pontos
 * 
 */

// OBS: ao rodar o programa no Windows evite usar ponto ao inserir valores não inteiros
//      já no caso do Linux, evite usar vírgula para o mesmo fim acima.


import java.util.Scanner;

public class Exercicio {
    
    // permite a leitura de valores digitados pelo usuário
    public static Scanner ler = new Scanner(System.in);
    
    // retorna a soma de dois valores
    public static float Soma(float a, float b) {
        return a + b;
    }

    // principal
    public static void main(String[] args) {
        
        float a, b;

        System.out.print("Digite dois valores (separados por espaço/enter): ");
        
        try {
            // realiza a leitura dos valores
            a = ler.nextFloat(); b = ler.nextFloat();

            // mostra na tela o resultado final
            System.out.println("\nSoma: " + a + " + " + b + " = " + Soma(a,b));
        } 
        
        // exceção para casos em que os valores digitados não podem ser somados
        catch (Exception e) {
            System.out.println("\nOs valores inseridos não podem ser somados." +
                "\nOBS: Evite caracteres.");
        }
        
    }

}
