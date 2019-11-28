package exodecorateur_angryballs.maladroit;


import java.io.File;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.vues.MakeSound;
import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import exodecorateur_angryballs.maladroit.modele.balls.BilleNormal;
import exodecorateur_angryballs.maladroit.modele.balls.RebondWrapper;
import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;
import exodecorateur_angryballs.maladroit.modele.outilsModele.Color;
import exodecorateur_angryballs.maladroit.modele.outilsModele.OutilsBille2;
import mesmaths.geometrie.base.Vecteur;

import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;


/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement diff�rent
 * 
 * Id�al pour mettre en place le DP decorator
 * */
public class TestAngryBalls
{

/**
 * @param args
 */
public static void main(String[] args)
{

    File racine = new File("");
    File ici = new File(racine.getAbsoluteFile(),File.separatorChar+"assets");
    String billebille = ici.getAbsolutePath()+File.separatorChar+"chocBilleBille.wav";
    String billeMur = ici.getAbsolutePath()+File.separatorChar+"chocBilleMur.wav";

    MakeSound ms = new MakeSound(new File(billebille));

    MakeSound ms2 = new MakeSound(new File(billeMur));


    OutilsBille2 outilsBille2 = OutilsBille2.getInstance();
    outilsBille2.addObservateur(ms);

    Collisions2 collision2 = Collisions2.getInstance();
    collision2.addObservateur(ms2);
//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------

Vector<Bille> billes = new Vector<Bille>();

//---------------- cr�ation de la vue responsable du dessin des billes -------------------------

CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements diff�rents. Situation id�ale pour mettre en place le DP Decorator",
                                        billes);

cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();
    System.out.println(xMax);// abscisse maximal
yMax = cadre.hauteurBillard();      // ordonn�e maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au d�marrage. 
                                                    // Elles vont �tre choisies al�atoirement

//------------------- cr�ation des vecteurs position des billes ---------------------------------

p0 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);

//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie � changer ---------------------------------
/*billes.add(new      BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
billes.add(new         BilleMvtRURebond(p0, rayon, v0, Color.red));
billes.add(new              BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
billes.add(new              BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
billes.add(new BilleMvtNewtonArret(p4, rayon, v4,  Color.black));
*/


    Bille bille2 = new BilleNormal(p2,rayon,v2, Color.BLUE);
    bille2 = new RebondWrapper(bille2);

    billes.add(bille2);


    Bille bille3 = new BilleNormal(p3,rayon,v3,Color.DARK);
    bille3 = new RebondWrapper(bille3);

    billes.add(bille3);

//    Bille bille4 = new BilleNormal(p4,rayon,v4,Color.YELLOW);
//    bille4 = new RebondWrapper(bille4);
//    bille4 = new NewtonWrapper(bille4);
//    billes.add(bille4);
//
//    Bille bille5 = new BilleNormal(p0,rayon,v0,Color.GREEN);
//    bille5 = new RebondWrapper(bille5);
//    bille5 = new NewtonWrapper(bille5);
//    billes.add(bille5);



 /**/
//---------------------- ici finit la partie � changer -------------------------------------------------------------


System.out.println("billes = " + billes);


//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des �couteurs de boutons qui permettent de contr�ler (un peu...) l'application -----------------
    MyAnimation monAnimation = new MyAnimation(animationBilles);
//EcouteurBoutonLancer �couteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
//EcouteurBoutonArreter �couteurBoutonArr�ter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des �couteurs des boutons et �a tourne tout seul ------------------------------


cadre.lancerBilles.addObservateur(monAnimation);             // maladroit : � changer
cadre.arr�terBilles.addObservateur(monAnimation);           // maladroit : � changer




}

}
