//importação de bibliotecas
import java.util.ArrayList;
import java.util.Scanner; 
import java.util.List;

/*class inicia*/
public class App {
    /*variavel global onde qualquer outra clase pode aceesar*/
    public Integer b = 0;

    /*instacio a clase para ler os dados do sistema
    final => ele é atribuidor uma fez por metedodo*/
    private static final Scanner ler_teclado = new Scanner(System.in);
    
    /*no java não há paremtro defalde/opicional por isso é usado uma 
    sobrecarragade metedo ou seja se eu chamar o :
    input("test") ele vai me printar test e depois capturar o teclado do user
    mas se eu chamar o input nada acontece*/
    private static String input(String texter){
        //informe o imput que vai ser mostrado para o user
        System.out.println(texter);
        
        //associa o que o user digitou
        String _text_lido = ler_teclado.nextLine();

        //ver se o _text_lido ésta vazio
        if (_text_lido.isEmpty()){
            //raise erro
            throw new RuntimeException("informe um user");
        }

        //retonar a mesagem que é obrigada as er do tipo String
        return _text_lido; 
    }
    
    //para de mostra que ele não esta sendo usado
    @SuppressWarnings("unused")
    private static String input(){
        //associa o que o user digitou
        String _text_lido = ler_teclado.nextLine();

        if (_text_lido.isEmpty()){
            //raise erro
            throw new RuntimeException("informe um user");
        }

        //retonar a mesagem que é obrigada as er do tipo String
        return _text_lido; 
    }

    //static fala para o java que clear só pertecem a class app e não 
    //ao objeto de mesma
    private static void clear(){
        //codigo ANSI
        System.out.print("\033[H\033[2J");
        //isso limpar o buf de memoria do terminal
        System.out.flush();
        return;
    }

    @SuppressWarnings("unused")
    private static void delay(int cont){
        /*try exepct
        o try é necessario pois pode vim outra tareva enquando o 
        sleep não esta executando o que gera um erro */
        try {
            Thread.sleep(cont); 
        } catch (InterruptedException e) {
            //mostra como erro
            System.err.println("erro no timer: "+e);
        }
    }

    private static void delay(){
        /*try exepct
        o try é necessario pois pode vim outra tareva enquando o 
        sleep não esta executando o que gera um erro */
        try {
            Thread.sleep(2500); // 2,5 segundos
        } catch (InterruptedException e) {
            //mostra como erro
            System.err.println("erro no timer: "+e);
        }
    }

    private static void test(){
        //mesma coisa que função lambada no python
        Runnable finalizar_programr = () -> {
            delay();
            clear();
            System.out.println("finalizando o programa");
            //finaliza o programa
            System.exit(0);
        };

        /*o static é como se esse função meio que não existe no java
        porr isso se for acessa a varivel b eu tenho que instancia uma
        classe aqui dentro*/
        App _app = new App();

        //loop
        while (true) {
            _app.b += 1;
            try {
                /*lista*/
                List<String> users_permitidos = new ArrayList<>(List.of(
                    "test","nunes","lol"));
                
                /*var na propiedade*/
                String user;
                
                user = input("nome: ");
                
                //mesma coisa de if var in list
                if (users_permitidos.contains(user)){
                    /*print*/
                    System.out.println("user pode acessar");
                    System.out.println("seja bem vindo \"" + user +"\"");

                    System.out.println("valor de b :" + _app.b);
                    finalizar_programr.run();
                }
                else{
                    System.out.println("o user: \""+ user +
                    "\" não pode acessar o sistema");
                    //tenho que passar .run toda fez que chamr uma função lambada 
                    finalizar_programr.run();
                }
            } catch (RuntimeException e) {
                //getMessage -> quando eu pego a mensagem do propio erro
                System.out.println(e.getMessage());
                delay();
                clear();
            }
        }
    }

    /*void principal do java o inicio dele não pode ser de outra maneira*/
    public static void main(String[] args){test();}
}
