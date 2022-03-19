/**
 * 
 *  Trabalho Interdisciplinar 2 : BD e SI
 *  Exercicio 1 - Programa em Java que some dois n�meros
 * 
 *  Nome: Larissa Valadares Silqueira
 *  Matricula: 754065-5
 * 
 *  Autoavalia��o: 5 pontos
 * 
 */

// OBS: ao rodar o programa no Windows evite usar ponto ao inserir valores n�o inteiros
//      j� no caso do Linux, evite usar v�rgula para o mesmo fim acima.


import java.util.Scanner;

public class Exercicio {
    
    // permite a leitura de valores digitados pelo usu�rio
    public static Scanner ler = new Scanner(System.in);
    
    // retorna a soma de dois valores
    public static float Soma(float a, float b) {
        return a + b;
    }

    // principal
    public static void main(String[] args) {
        
        float a, b;

        System.out.print("Digite dois valores (separados por espa�o/enter): ");
        
        try {
            // realiza a leitura dos valores
            a = ler.nextFloat(); b = ler.nextFloat();

            // mostra na tela o resultado final
            System.out.println("\nSoma: " + a + " + " + b + " = " + Soma(a,b));
        } 
        
        // exce��o para casos em que os valores digitados n�o podem ser somados
        catch (Exception e) {
            System.out.println("\nOs valores inseridos n�o podem ser somados." +
                "\nOBS: Evite caracteres.");
        }
        
    }

}
