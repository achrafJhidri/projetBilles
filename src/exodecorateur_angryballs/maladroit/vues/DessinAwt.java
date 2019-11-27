package exodecorateur_angryballs.maladroit.vues;

import exodecorateur_angryballs.maladroit.modele.balls.Bille;

import java.awt.Color;
import java.awt.Graphics;

public class DessinAwt extends Dessinateur {
	private Graphics graphics;
	
	
	public DessinAwt(Graphics g) {
		super();
		this.graphics=g;
	}
	@Override
	public void visite(Bille bille) {

        int width, height;
        int xMin, yMin;

        xMin = (int)Math.round(bille.getPosition().x-bille.getRayon());
        yMin = (int)Math.round(bille.getPosition().y-bille.getRayon());

        width = height = 2*(int)Math.round(bille.getRayon());

        graphics.setColor(new Color(bille.getCouleur().r,bille.getCouleur().g,bille.getCouleur().b));
        graphics.fillOval( xMin, yMin, width, height);
        graphics.setColor(Color.CYAN);
        graphics.drawOval(xMin, yMin, width, height);
		
	}

}
