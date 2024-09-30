package vizualizacao;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Aberturas;

public class EntradaSaida {
    public static int solicitaOpcao() {
        String[] opcoes = {"Construir casa", "Movimentar portas ou janelas", "Ver informações da casa", "Sair do programa"};
        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Seleciona a opção desejada", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedIndex();
    }

    public static String solicitaDescricao(String descricao, int ordem) {
        if (ordem == 0) {
            return JOptionPane.showInputDialog(null, "Informe a descrição da "+descricao);
        } else {
            return JOptionPane.showInputDialog(null, "Qual é a descrição da "+ordem+" "+descricao+"?");
        }
    }

    public static String solicitaCor() {
        return JOptionPane.showInputDialog(null, "Qual é a cor da casa?");
    }

    public static int solicitaQtdAberturas(String abertura) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de "+abertura+": "));
    }

    public static int solicitaEstado(String tipoAbertura) {
        String[] opcoes = {"Aberta", "Fechada"};

        return JOptionPane.showOptionDialog(null, 
        "Qual é o estado da " + tipoAbertura + "?", 
        "Estado",
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, 
        null, 
        opcoes, 
        opcoes[1]);
    
    }

    public static String solicitaTipoAbertura(){
        String[] opcoes = {"Porta", "Janela"};

        int tipoAbertura = JOptionPane.showOptionDialog(null, 
        "Qual é o tipo de abertura?", 
        "Tipo de abertura",
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, 
        null, 
        opcoes, 
        opcoes[0]);
        
        if(tipoAbertura == 0){
            return "Porta";
        } else {
            return "Janela";
        }
    }

    public static int solicitaAberturaMover(ArrayList<Aberturas> listaDeAberturas) {
        String tipoAbertura = listaDeAberturas.get(0).getClass().getName();
        tipoAbertura = tipoAbertura.replace("modelo.", "");
        int qtdeAbertura = listaDeAberturas.size();
        String[] descricoesAberturas = new String[qtdeAbertura];

        for (int i = 0; i < qtdeAbertura; i++) {
            descricoesAberturas[i]=listaDeAberturas.get(i).getDescricao();
        }

        String msg = "Escolha a "+tipoAbertura+" que deseja mover:";
        JComboBox<String> exibicaoAberturas = new JComboBox<>(descricoesAberturas);
        int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoAberturas, msg, JOptionPane.OK_CANCEL_OPTION);

        if(confirmacao == 0){
            return exibicaoAberturas.getSelectedIndex();
        }
        else{
            return -1;
        }
    }

    public static void exibeInfoCasa(String informacoes) {
        JOptionPane.showMessageDialog(null, informacoes, "Informações da casa: ", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exibeMsgCasaNaoCriada() {
        JOptionPane.showMessageDialog(null, "Casa não foi construída!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void exibeMsgEncerraPrograma() {
        JOptionPane.showMessageDialog(null, "O programa será encerrado!");
    }
}
