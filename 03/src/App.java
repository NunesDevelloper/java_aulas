import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static Runnable clear = () -> {
        Utils.delay();
        Utils.clear();
    };

    private static void mostra_user(){
        int tamanho_db = db.dados.size();
        if (tamanho_db <= 0){
            System.out.println("não há dados no banco");
        }
        else{
            List<String> nome = new ArrayList<>(db.dados.keySet());
            List<String> senha = new ArrayList<>(db.dados.values());

            System.out.println("Id | Nome | Senha");
            for(int i = 0; i < tamanho_db; i++){
                System.out.println(i+" | "+nome.get(i)+" | "+senha.get(i));
            }
        }
    }

    private static void criar_user(String nome, String senha){
        nome = nome.trim();
        senha = senha.trim();
        db.dados.put(nome, senha);
    }

    private static Boolean editar_senha(int Id, String senha){
        for(int i = 0; i < db.dados.size(); i++){
            if(i == Id){
                List<String> nome = new ArrayList<>(db.dados.keySet());
                System.out.println(nome);
                db.dados.put(nome.get(i), senha);
                System.out.println("dados alterados com suceeso");
                return true;
            }
        }
        System.out.println("o id do user não foi encontrado");
        return false;
    }

    private static boolean dell_user(int Id){
        for(int i = 0; i < db.dados.size(); i++){
            if(i == Id){
                List<String> nome = new ArrayList<>(db.dados.keySet());
                System.out.println(nome);
                db.dados.remove(nome.get(i));
                System.out.println("Conta Removida com Sucesso");
                return true;
            }
        }
        System.out.println("o id do user não foi encontrado");
        return false;
    }

    public static void main(String[] args) {
        
        db.popular_dados.run();
        System.out.println("Seja bem vindo");

        List<String> opecao = new ArrayList<>(Arrays.asList(
            "1 - cria conta",
            "2 - editar senha",
            "3 - mostra contas",
            "4 - deletar conta",
            "0 - sair da aplicação"));

        while (true) {
            clear.run();

            for (String i: opecao) {
                System.out.println(i);
            }

            String _input =  Utils.input("insira o número da opeção");
            
            //match case
            switch (_input) {
                //cria conta
                case "1":
                    clear.run();
                    String nome_conta = Utils.input("nome: ");
                    String senha_conta = Utils.input("senha: ");
                    criar_user(nome_conta, senha_conta);
                    mostra_user();
                    break;
                //editar senha
                case "2":
                    clear.run();
                    mostra_user();
                    String id_senha = Utils.input("id: ");
                    String senha_editar = Utils.input("senha: ");
                    int id_senha_int = Utils.str_int(id_senha);
                    if (id_senha_int >= 0){
                        editar_senha(id_senha_int, senha_editar);
                    }
                    break;
                //mostra contas
                case "3":
                    clear.run();
                    mostra_user();
                    break;
                //deletar conta
                case "4":
                    clear.run();
                    String id_dell= Utils.input("id: ");
                    int id_dell_int = Utils.str_int(id_dell);
                    if (id_dell_int >= 0){
                        dell_user(id_dell_int);
                    }
                    break;
                //sair do app
                case "0":
                    Utils.finalizar_programr.run();
                    break;
                //caso ele não digite uma opeção invalida
                default:
                    System.out.println("opeção invalida");
                    break;
            }
        }
    }
}
