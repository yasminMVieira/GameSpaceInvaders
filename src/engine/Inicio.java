package engine;

import input.Input;
import ob.ObInimigo;
import ob.ObInimigo2;
import ob.ObInimigo3;
import ob.ObNave;
import ui.UIJogo;
import ui.UILayout;

public class Inicio {

    private final int largura = 480, altura = 840;

    private Jogo jogo;
    private UIJogo janela;
    private Thread thread;
    private boolean ativo = false;
    private Processador proces;

    public static void main(String[] args) {
        new UILayout(new Inicio());
    }

    public Inicio() {
        this.proces = new Processador();
        this.jogo = new Jogo(largura, altura, ativo, proces);
        jogo.addKeyListener(new Input(proces));
    }

    public void start() {
        thread = new Thread(jogo);
        thread.start();
        ativo = true;
    }

    public void stop() {
        try {
            if (thread != null && thread.isAlive()) {
                thread.join();
            }
            ativo = false;
        } catch (InterruptedException e) {
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void insereInimigos1() {
        for (int x = 300; x >= 50; x = x-50){
            proces.addObjeto(new ObInimigo(x, 50, 2, 0, 0, 5, proces, largura, altura));
        }
    }

    public void insereInimigos2() {
        //linha 1
        for (int x = 300; x >= 50; x = x-50){
            proces.addObjeto(new ObInimigo2(x, 50, 2, 0, 0, 5, proces, largura, altura));
        }

        //linha 2
        for (int x = 300; x >= 50; x = x-50){
            proces.addObjeto(new ObInimigo2(x, 100, 2, 0, 0, 5, proces, largura, altura));
        }
    }

    public void insereInimigos3() {
        //linha 1
        for (int x = 300; x >= 50; x = x-50){
            proces.addObjeto(new ObInimigo3(x, 50, 2, 0, 0, 5, proces, largura, altura));
        }

        //linha 2
        for (int x = 300; x >= 50; x = x-50){
            proces.addObjeto(new ObInimigo3(x, 100, 2, 0, 0, 5, proces, largura, altura));
        }

        //linha 3
        for (int x = 300; x >= 50; x = x-50){
            proces.addObjeto(new ObInimigo3(x, 150, 2, 0, 0, 5, proces, largura, altura));
        }
    }

    public void comecar() {

        this.janela = new UIJogo(largura, altura, jogo, this);
        proces.setJanela(janela);

        proces.addObjeto(new ObNave((largura / 2) + 32, altura - 64, 1, 6, proces, largura, altura));

        insereInimigos1();
        start();
    }

}
