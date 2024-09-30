package controle;
import java.util.ArrayList;

import vizualizacao.EntradaSaida;
import modelo.*;

public class Controladora {
    
    private Casa casa = null;

    public void exibeMenu(){
        int opcao;
        do{
            opcao = EntradaSaida.solicitaOpcao();

            switch(opcao){
                case 0:
                    this.casa = new Casa();
                    
                    String descricao = EntradaSaida.solicitaDescricao("casa", 0);
                    String cor = EntradaSaida.solicitaCor();
                    int qtdPortas = EntradaSaida.solicitaQtdAberturas("portas");
                    while (qtdPortas <= 0){
                        qtdPortas = EntradaSaida.solicitaQtdAberturas("portas");
                    }
                    int qtdJanelas = EntradaSaida.solicitaQtdAberturas("janelas");
                    while (qtdJanelas <= 0) {
                        qtdJanelas = EntradaSaida.solicitaQtdAberturas("janelas");
                    }

                    ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
                    for(int i = 0; i < qtdPortas; i++){
                        Porta porta = new Porta();
                        porta.setDescricao(EntradaSaida.solicitaDescricao("porta", i+1));
                        porta.setEstado(EntradaSaida.solicitaEstado("porta"));

                        listaDePortas.add(porta);
                    }

                    ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();
                    for(int i = 0; i < qtdJanelas; i++){
                        Janela janela = new Janela();
                        janela.setDescricao(EntradaSaida.solicitaDescricao("janela", i+1));
                        janela.setEstado(EntradaSaida.solicitaEstado("janela"));   

                        listaDeJanelas.add(janela);
                    }
                    
                    this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);
                    break;
                case 1:
                    if(this.casa == null){
                        EntradaSaida.exibeMsgCasaNaoCriada();
                        break;
                    }
                    String tipoAbertura = EntradaSaida.solicitaTipoAbertura();

                    ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();
                    if(tipoAbertura.equals("Porta")){
                        listaDeAberturas = this.casa.getListaDePortas();
                    } else {
                        listaDeAberturas = this.casa.getListaDeJanelas();
                    }

                    int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
                    int novoEstado=0;

                    if(posicao != -1){
                        novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
                        Aberturas abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
                        this.casa.moverAbertura(abertura, novoEstado);
                    }else{
                        EntradaSaida.exibeMsgEncerraPrograma();
                    }
                    break;
                case 2:
                    if(this.casa == null){
                        EntradaSaida.exibeMsgCasaNaoCriada();
                        break;
                    }
                    String informacoes = this.casa.geraInfoCasa();
                    EntradaSaida.exibeInfoCasa(informacoes);
                    break;
            }
        }while(opcao != 3);

        EntradaSaida.exibeMsgEncerraPrograma();

        System.exit(0);
    }
}
