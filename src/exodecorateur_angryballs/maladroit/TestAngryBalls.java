package exodecorateur_angryballs.maladroit;


import java.io.File;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.controllers.StateManager;
import exodecorateur_angryballs.maladroit.modele.balls.*;
import exodecorateur_angryballs.maladroit.vues.MakeSound;
import exodecorateur_angryballs.maladroit.modele.outilsModele.Color;
import exodecorateur_angryballs.maladroit.vues.SoundCollisionBB;
import exodecorateur_angryballs.maladroit.vues.SoundCollisionContour;
import mesmaths.geometrie.base.Vecteur;

import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;


/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement différent
 * 
 * Idéal pour mettre en place le DP decorator
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



    SoundCollisionContour scc = SoundCollisionContour.getInstance();
    SoundCollisionBB sbb = SoundCollisionBB.getInstance();
    scc.addObservateur(ms2);
    sbb.addObservateur(ms);
//------------------- création de la liste (pour l'instant vide) des billes -----------------------

Vector<Bille> billes = new Vector<Bille>();

//---------------- création de la vue responsable du dessin des billes -------------------------

CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements différents. Situation idéale pour mettre en place le DP Decorator",
                                        billes);

    StateManager stateManager = new StateManager(cadre.billard.billes);
    cadre.billard.addMouseListener(stateManager);
    cadre.billard.addMouseMotionListener(stateManager);
cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();
    System.out.println(xMax);// abscisse maximal
yMax = cadre.hauteurBillard();      // ordonnée maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le même rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au démarrage. 
                                                    // Elles vont être choisies aléatoirement

//------------------- création des vecteurs position des billes ---------------------------------

p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- création des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie à changer ---------------------------------
/*billes.add(new      BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
billes.add(new         BilleMvtRURebond(p0, rayon, v0, Color.red));
billes.add(new              BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
billes.add(new              BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
billes.add(new BilleMvtNewtonArret(p4, rayon, v4,  Color.black));
*/


    Bille bille2 = new BilleNormal(p2,rayon,v2, Color.BLUE);
    bille2 = new RebondWrapper(bille2);
    bille2 = new NewtonWrapper(bille2);
    billes.add(bille2);


    Bille bille3 = new BilleNormal(p3,rayon,v3,Color.DARK);
  //  bille3 = new RebondWrapper(bille3);
    bille3 = new PasseMuraille(bille3);
    billes.add(bille3);

    Bille bille4 = new BilleNormal(p4,rayon,v4,Color.YELLOW);
    bille4 = new RebondWrapper(bille4);
    bille4 = new PesanteurWrapper(bille4,new Vecteur(0,0.001));
    billes.add(bille4);

    Bille bille5 = new BilleNormal(p0,rayon,v0,Color.GREEN);
    bille5 = new RebondWrapper(bille5);

    billes.add(bille5);



 /**/
//---------------------- ici finit la partie à changer -------------------------------------------------------------


System.out.println("billes = " + billes);


//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------
    MyAnimation monAnimation = new MyAnimation(animationBilles);
//EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
//EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------


cadre.lancerBilles.addObservateur(monAnimation);             // maladroit : à changer
cadre.arrêterBilles.addObservateur(monAnimation);           // maladroit : à changer




}

}
