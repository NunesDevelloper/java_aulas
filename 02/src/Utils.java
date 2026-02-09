import java.util.Scanner;

public class Utils {
    private static final Scanner ler_teclado = new Scanner(System.in);

    public static String input(String texter){
        System.out.println(texter);
        String _text_lido = ler_teclado.nextLine();
        if (_text_lido.isEmpty()){
            throw new RuntimeException("informe um user");
        }
        return _text_lido; 
    }

    public static String input(){
        String _text_lido = ler_teclado.nextLine();
        if (_text_lido.isEmpty()){
            throw new RuntimeException("informe um user");
        }
        return _text_lido; 
    }

    public static void delay(){
        try {
            Thread.sleep(2500); 
        } catch (InterruptedException e) {
            System.err.println("erro no timer: "+e);
        }
    }

    public static void delay(int cont){
        try {
            Thread.sleep(cont); 
        } catch (InterruptedException e) {
            System.err.println("erro no timer: "+e);
        }
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return;
    }

    public static Runnable finalizar_programr = () -> {
        delay();
        clear();
        System.out.println("finalizando o programa");
        System.exit(0);
    };

    public static void main(String[] args) {
        System.err.println("Utils não é para ser executudado");
    }

    
}