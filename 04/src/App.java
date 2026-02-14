//biblioteca nativa para interface minima   
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) {
        //caixa de dialogo basico
        JOptionPane.showMessageDialog(null, 
            //mensagem na tela
            "hello word, tela!!",
            //titulo da caixa
            "caixa de dialogo",
            //icone ao lado da mensagem
            JOptionPane.PLAIN_MESSAGE
        );

        //caixa de dialogo para o user(input)
        String txtinput = JOptionPane.showInputDialog(null,
            //mensagem na tela
            "Digite o seu nome",
            //titulo da caixa
            "caixa de input",
            //icone ao lado da mensagem
            JOptionPane.PLAIN_MESSAGE
        );

        JOptionPane.showMessageDialog(null, 
            //mensagem na tela
            "Olá: \" "+txtinput+" \"",
            "caixa de dialogo",JOptionPane.PLAIN_MESSAGE
        );
    }

    //classe no java
    public class a {
        
    }

    //classe que herda da class a
    public class b extends a {
        
    }

}
            