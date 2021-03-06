package ob;

import engine.Processador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

    public class ObInimigo2 extends ObInimigo {

        public ObInimigo2(int x, int y, int velX, int velY, int id, int vida, Processador proces, int largura, int altura) {
            super(x, y, velX, velY, id, vida, proces, largura, altura);
        }

        @Override
        public void render(Graphics g) {
            Color corInimigo = new Color(220, 21, 0, 255);
            g.setColor(corInimigo);
            g.fillRect(x - 16, y + 18, 3, 6);
            g.fillRect(x - 13, y + 18, 3, 6);
            g.fillRect(x - 10, y + 12, 3, 12);
            g.fillRect(x - 7, y + 6, 3, 12);
            g.fillRect(x - 7, y + 21, 3, 3);
            g.fillRect(x - 4, y + 3, 9, 21);
            g.fillRect(x + 5, y + 6, 3, 12);
            g.fillRect(x + 5, y + 21, 3, 3);
            g.fillRect(x + 8, y + 12, 3, 12);
            g.fillRect(x + 11, y + 18, 3, 6);
            g.fillRect(x + 14, y + 18, 3, 6);


            g.fillRect(x - 10, y + 30, 3, 3);
            g.fillRect(x - 7, y + 27, 3, 3);
            g.fillRect(x - 4, y + 30, 3, 3);
            g.fillRect(x - 4, y + 24, 3, 3);
            g.fillRect(x - 1, y + 27, 3, 3);
            g.fillRect(x + 2, y + 30, 3, 3);
            g.fillRect(x + 2, y + 24, 3, 3);
            g.fillRect(x + 5, y + 27, 3, 3);
            g.fillRect(x + 8, y + 30, 3, 3);

        /*
        g.setColor(Color.white);
        g.drawRect(x - 17, y, 33, 33);

        g.drawRect(x - 75, y, 150, 150);
        */
        }

        @Override
        public void colisao() {
            if (this.getHitBox().intersects(new Rectangle(0, altura - 200, largura, altura))) {
                proces.setP(0);
            }
            if (this.getHitBox().intersectsLine(0, 0, 0, altura)) {
                this.setVelX((-1) * velX);
                this.setY(y + 100);
            }
            if (this.getHitBox().intersectsLine(largura - 16, 0, largura - 16, altura)) {
                this.setVelX((-1) * velX);
                this.setY(y + 100);
            }
            for (int i = 0; i < proces.getObjeto().size(); i++) {
                ObObjeto tempObjeto = proces.getObjeto().get(i);
                if (tempObjeto.getId() != this.id && tempObjeto.getId() != 4) {
                    if (tempObjeto.getHitBox().intersects(this.getHitBox())) {
                        this.vida--;
                    }
                }
            }
        }

        @Override
        public void atirar() {
            ObProjetil proj = new ObProjetil(x, y + 34, 0, 7, 4, 2, proces, largura, altura);
            proces.addObjeto(proj);
        }


    }


