//só pode der uma calss por arquivo
public class App {
    public static int altura = 5;

    public static void main(String[] args){
        //(int i = 1; i <= altura; i++) => for i in range(1, altura + 1)
        for (int i = 1; i <= altura; i++){
            //repeat => ""*n
            String espacos = " ".repeat(altura - i);
            String asteriscos = "*".repeat(2*i - 1);
            
            System.out.println(espacos+asteriscos);
        }

        //pego de outro arquivo na mesma pasta
        Utils.finalizar_programr.run();
    }
}