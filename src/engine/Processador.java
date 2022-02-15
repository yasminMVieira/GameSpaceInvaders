package engine;

import ob.InimigosFase2;
import ob.ObInimigo;
import ob.ObNave;
import ob.ObObjeto;
import ui.UIJogo;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Processador {

    ArrayList<ObObjeto> objeto = new ArrayList<ObObjeto>();
    private int p = 1;
    private boolean e = false;
    private UIJogo janela;

    public void tick() {
        for (int i = 0; i < objeto.size(); i++) {
            ObObjeto tempObjeto = objeto.get(i);
            if (tempObjeto instanceof ObInimigo) {
                e = true;
            }
            if (tempObjeto instanceof InimigosFase2) {
                e = true;
            }
            tempObjeto.tick();
        }

        if (p == 0) {
            derrota();
        }
        if (!e) {
            vitoria();
        }
        e = false;
    }

    public Processador() {
    }

    public void render(Graphics g) {
        for (int i = 0; i < objeto.size(); i++) {
            ObObjeto tempObjeto = objeto.get(i);
            if (tempObjeto instanceof ObNave) {
                for (int i2 = 0; i2 < tempObjeto.getVida(); i2++) {
                    g.setColor(Color.green);
                    g.fillRect((25 * i2) + 25, 30, 10, 10);
                }
                g.setColor(Color.white);
                g.drawString("VIDA: ", 25, 25);
                g.drawString("FASE: " + (janela.getFase()+1), janela.getLargura()-100, 25);
            }
            tempObjeto.render(g);
        }
    }

    public void addObjeto(ObObjeto objeto) {
        this.objeto.add(objeto);
    }

    public void removeObjeto(ObObjeto objeto) {
        this.objeto.remove(objeto);
    }

    public ArrayList<ObObjeto> getObjeto() {
        return objeto;
    }

    public void vitoria() {
        janela.vitoria();
    }

    public void derrota() {
        janela.derrota();
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setJanela(UIJogo janela) {
        this.janela = janela;
    }

}
