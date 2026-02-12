import java.util.HashMap;
import java.util.Map;

public class db {
    //equivalende há um dicionario
    public static Map<String, String> dados = new HashMap<>();
    
    //o "dicionbario" não pode ser criado com valores
    public static Runnable popular_dados = () -> {
        dados.put("test","123");
    };
}
