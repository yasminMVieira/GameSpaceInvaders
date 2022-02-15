package engine;

import input.Input;
import ob.InimigosFase2;
import ob.ObInimigo;
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
        proces.addObjeto(new ObInimigo(300, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(250, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(200, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(150, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(100, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(50, 50, 2, 0, 0, 5, proces, largura, altura));
    }

    public void insereInimigos2() {
        proces.addObjeto(new InimigosFase2(300, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(250, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(200, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(150, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(100, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(50, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(300, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(250, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(200, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(150, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(100, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new InimigosFase2(50, 100, 2, 0, 0, 5, proces, largura, altura));
    }

    public void insereInimigos3() {
        proces.addObjeto(new ObInimigo(300, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(250, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(200, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(150, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(100, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(50, 50, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(300, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(250, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(200, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(150, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(100, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(50, 100, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(300, 150, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(250, 150, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(200, 150, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(150, 150, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(100, 150, 2, 0, 0, 5, proces, largura, altura));
        proces.addObjeto(new ObInimigo(50, 150, 2, 0, 0, 5, proces, largura, altura));
    }

    public void comecar() {

        this.janela = new UIJogo(largura, altura, jogo, this);
        proces.setJanela(janela);

        proces.addObjeto(new ObNave((largura / 2) + 32, altura - 64, 1, 5, proces, largura, altura));

        insereInimigos1();
        start();
    }

}
