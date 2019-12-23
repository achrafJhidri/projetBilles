package exodecorateur_angryballs.maladroit.modele.outilsModele;

public class Color {
	
	public int r,g,b;
	
	
public final static Color RED=new Color(255,0,0);
public final static Color GREEN=new Color(0,255,0);
public final static Color BLUE=new Color(0,0,255);
public final static Color DARK=new Color(0,0,0);
public final static Color YELLOW=new Color(255,255,0);

	public Color(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}
	

}
