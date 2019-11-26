package exodecorateur_angryballs.maladroit.vues;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.DessinAwt;
import exodecorateur_angryballs.maladroit.modele.Dessinateur;


import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends Canvas
{
Vector<Bille> billes;



    public Billard(Vector<Bille> billes)
    {
    	this.billes = billes;
    }
    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics)
    {
    int i;
    Dessinateur visiteur=new DessinAwt(graphics);
    
    for ( i = 0; i < this.billes.size(); ++i)
        this.billes.get(i).dessine(visiteur);
    
    //System.out.println("billes dans le billard = " + billes);
    }

    
    
    
    
 
}
