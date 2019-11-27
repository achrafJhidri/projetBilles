package exodecorateur_angryballs.maladroit.vues;

import exodecorateur_angryballs.maladroit.modele.balls.Bille;

import java.util.Vector;


public class TestCadreAngryBallsSeul
{

/**
 * @param args
 */
public static void main(String[] args)
{
Vector<Bille> billes = new Vector<Bille>();
CadreAngryBalls cadre =new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
cadre.montrer();
}

}
