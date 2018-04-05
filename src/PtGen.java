/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libclass)            *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compile, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valNb = valeur du dernier nombre entier lu (item nbentier)    *
 *     int UtilLex.numId = code du dernier identificateur lu (item ident)        *
 *                                                                               *
 *                                                                               *
 *   methodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arret compilation       *
 *     String UtilLex.repId(int nId) delivre l'ident de codage nId               *
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/


import java.io.*;

// classe de mise en oeuvre du compilateur
// =======================================
// (verifications semantiques + production du code objet)

public class PtGen {

    // constantes manipulees par le compilateur
    // ----------------------------------------

	private static final int 
	
	// taille max de la table des symboles
	MAXSYMB=300,

	// codes MAPILE :
	RESERVER=1,EMPILER=2,CONTENUG=3,AFFECTERG=4,OU=5,ET=6,NON=7,INF=8,
	INFEG=9,SUP=10,SUPEG=11,EG=12,DIFF=13,ADD=14,SOUS=15,MUL=16,DIV=17,
	BSIFAUX=18,BINCOND=19,LIRENT=20,LIREBOOL=21,ECRENT=22,ECRBOOL=23,
	ARRET=24,EMPILERADG=25,EMPILERADL=26,CONTENUL=27,AFFECTERL=28,
	APPEL=29,RETOUR=30,

	// codes des valeurs vrai/faux
	VRAI=1, FAUX=0,

    // types permis :
	ENT=1,BOOL=2,NEUTRE=3,

	// cat�gories possibles des identificateurs :
	CONSTANTE=1,VARGLOBALE=2,VARLOCALE=3,PARAMFIXE=4,PARAMMOD=5,PROC=6,
	DEF=7,REF=8,PRIVEE=9,

    //valeurs possible du vecteur de translation 
    TRANSDON=1,TRANSCODE=2,REFEXT=3;


    // utilitaires de controle de type
    // -------------------------------
    
	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}

	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

    // pile pour gerer les chaines de reprise et les branchements en avant
    // -------------------------------------------------------------------

    private static TPileRep pileRep;  


    // production du code objet en memoire
    // -----------------------------------

    private static ProgObjet po;
    
    
    // COMPILATION SEPAREE 
    // -------------------
    //
    // modification du vecteur de translation associe au code produit 
    // + incrementation attribut nbTransExt du descripteur
    // NB: effectue uniquement si c'est une reference externe ou si on compile un module
    private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}
    
    // descripteur associe a un programme objet
    private static Descripteur desc;

     
    // autres variables fournies
    // -------------------------
    public static String trinome="MARTIN_RAZA_PHAM"; // MERCI de renseigner ici un nom pour le trinome, constitue de exclusivement de lettres
    
    private static int tCour; // type de l'expression compilee
    private static int vCour; // valeur de l'expression compilee le cas echeant
  
    // Variables du trin�me
    
    static int tabSymb_nombreVars, tabSymb_nombreParams, tabSymb_iCour, tabSymb_iAffouappel, tabSymb_iParam,
    	nbParamsFixes, nbParamsMods,
    	iDef;
   
    // D�finition de la table des symboles
    //
    private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];
    
    // it = indice de remplissage de tabSymb
    // bc = bloc courant (=1 si le bloc courant est le programme principal)
	private static int it, bc;
	
	// utilitaire de recherche de l'ident courant (ayant pour code UtilLex.numId) dans tabSymb
	// rend en resultat l'indice de cet ident dans tabSymb (O si absence)
	private static int presentIdent(int binf) {
		int i = it;
		while (i >= binf && tabSymb[i].code != UtilLex.numId)
			i--;
		if (i >= binf)
			return i;
		else
			return 0;
	}

	// utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	//
	private static void placeIdent(int c, int cat, int t, int v) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(c, cat, t, v);
	}

	// utilitaire d'affichage de la table des symboles
	//
	private static void afftabSymb() { 
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" r�f�rence NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}
    

	// initialisations A COMPLETER SI BESOIN
	// -------------------------------------
	public static void initialisations() {
	
		// indices de gestion de la table des symboles
		it = 0;
		bc = 1;
		
		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep(); 
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();
		
		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();
	
		// initialisation du type de l'expression courante
		tCour = NEUTRE;
		
		tabSymb_nombreVars = 0;
	} // initialisations

	// code des points de generation A COMPLETER
	// -----------------------------------------
	public static void pt(int numGen) {
		switch (numGen) {
			case 0: // initialisation
				initialisations();
				break;
				
			// unite
				
			case 10: // apr�s programme
				desc.setTailleCode(po.getIpo());
				
				afftabSymb();
				po.constObj();
				po.constGen();
				desc.ecrireDesc(UtilLex.nomSource);
				
				System.out.println("succes, arret de la compilation ");
				break;
				
			// unitprog
			
			case 60: // apr�s ident programme
				desc.setUnite("programme");
				break;
				
			case 80:
				po.produire(ARRET);
				break;
				
			// unitmodule
			
			case 120: // apr�s ident module
				desc.setUnite("module");
				break;
				
			// partiedef
				
			case 210:
				desc.ajoutDef(UtilLex.repId(UtilLex.numId));
				break;

			// specif
			
			case 270:
				desc.ajoutRef(UtilLex.repId(UtilLex.numId));
				placeIdent(UtilLex.numId, PROC, NEUTRE, desc.getNbRef());
				placeIdent(-1, REF, NEUTRE, -1);
				
				tabSymb_nombreParams = 0;
				break;
			
			case 271:
				placeIdent(-1, PARAMFIXE, tCour, tabSymb_nombreParams++);
				break;
				
			case 280:
				placeIdent(-1, PARAMMOD, tCour, tabSymb_nombreParams++);
				break;
				
			case 281:
				tabSymb[it-tabSymb_nombreParams].info = tabSymb_nombreParams;
				desc.modifRefNbParam(desc.getNbRef(), tabSymb_nombreParams);
				break;
				
			// consts
				
			case 310: // d�claration de constante
				if (presentIdent(bc) != 0)
					UtilLex.messErr("D�claration incorrecte : identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" d�j� utilis�");
				placeIdent(UtilLex.numId, CONSTANTE, tCour, vCour);
				break;
				
			// vars
				
			case 340: // d�claration de variable
				if (presentIdent(bc) != 0)
					UtilLex.messErr("D�claration incorrecte : identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" d�j� utilis�");
				if (bc == 1)
					placeIdent(UtilLex.numId, VARGLOBALE, tCour, tabSymb_nombreVars);
				else
					placeIdent(UtilLex.numId, VARLOCALE, tCour, tabSymb_nombreParams + 2 + tabSymb_nombreVars);
				tabSymb_nombreVars++;
				break;
				
			case 341: // apr�s d�clarations de variables
				if (desc.getUnite().equals("programme")) {
					po.produire(RESERVER);
					po.produire(tabSymb_nombreVars);
				}
				desc.setTailleGlobaux(tabSymb_nombreVars);
				break;
				
			// type
				
			case 370: // type entier
				tCour = ENT;
				break;
				
			case 380: // type bool�en
				tCour = BOOL;
				break;
				
			// decprocs
				
			case 410: // avant d�clarations de proc�dures
				if (desc.getUnite().equals("programme")) {
					po.produire(BINCOND);
					po.produire(0);
					pileRep.empiler(po.getIpo());
					modifVecteurTrans(TRANSCODE);
				}
				break;
				
			case 411: // apr�s d�clarations de proc�dures
				if (desc.getUnite().equals("programme"))
					po.modifier(pileRep.depiler(), po.getIpo() + 1);
				
				//pour chaque def dans desc
				//	si pas dans tabsymb
				//		erreur
				
				for (int i411 = 1; i411 <= desc.getNbDef(); i411++) {
					boolean est_present = false;
					for (int j411 = bc; j411 <= it && !est_present; j411++) {
						if (tabSymb[j411].code != -1 && desc.getDefNomProc(i411).equals(UtilLex.repId(tabSymb[j411].code)))
							est_present = true;
					}
					if (!est_present)
						UtilLex.messErr("D�finition incorrecte : Proc�dure \"" + desc.getDefNomProc(i411) +"\" non impl�ment�e");
				}
				break;
				
			// decproc
				
			case 440: // d�claration de proc�dure : identificateur de proc�dure				
				if (presentIdent(1) != 0)
					UtilLex.messErr("D�claration incorrecte : Identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" d�j� utilis�");
				placeIdent(UtilLex.numId, PROC, NEUTRE, po.getIpo() + 1);
				
				if ((iDef = desc.presentDef(UtilLex.repId(UtilLex.numId))) != 0) {
					desc.modifDefAdPo(iDef, po.getIpo() + 1);
					placeIdent(-1, DEF, NEUTRE, 0);
				} else placeIdent(-1, PRIVEE, NEUTRE, 0);
				
				bc = it + 1;
				tabSymb_nombreParams = 0;
				tabSymb_nombreVars = 0;
				break;
				
			case 441: // d�claration de proc�dure : apr�s param�tres
				tabSymb[bc-1].info = tabSymb_nombreParams;

				if (iDef != 0)
					desc.modifDefNbParam(iDef, tabSymb_nombreParams);
				break;
				
			case 442: // apr�s d�claration de proc�dure
				po.produire(RETOUR);
				po.produire(tabSymb[bc-1].info);
				
				it = bc - 1 + tabSymb[bc-1].info;
				for (int i442 = bc; i442 <= it; i442++)
					tabSymb[i442].code = -1;
				bc = 1;
				break;
				
			// pf
				
			case 570: // d�claration de param�tre fixe
				placeIdent(UtilLex.numId, PARAMFIXE, tCour, tabSymb_nombreParams++);
				break;
				
			// pm
				
			case 630: // d�claration de param�tre mod
				placeIdent(UtilLex.numId, PARAMMOD, tCour, tabSymb_nombreParams++);
				break;

			// inssi
				
			case 800: // instruction si : expression
				verifBool();
				po.produire(BSIFAUX);
				po.produire(0);
				pileRep.empiler(po.getIpo());
				modifVecteurTrans(TRANSCODE);
				break;

			case 801: // instruction si : sinon
				po.produire(BINCOND);
				po.produire(0);
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				pileRep.empiler(po.getIpo());
				modifVecteurTrans(TRANSCODE);
				break;
				
			case 802: // instruction si : fsi
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				break;
				
			// inscond
				
			case 830: // instruction cond : avant cond
				pileRep.empiler(0);
				break;
			
			case 831: // instruction cond : expression
				po.produire(BSIFAUX);
				po.produire(0);
				pileRep.empiler(po.getIpo());
				modifVecteurTrans(TRANSCODE);
				break;
				
			case 840: // instruction cond : branchement inconditionnel
				po.modifier(pileRep.depiler(), po.getIpo() + 3);
				po.produire(BINCOND);
				po.produire(pileRep.depiler());
				pileRep.empiler(po.getIpo());
				modifVecteurTrans(TRANSCODE);
				break;
				
			case 850: // instruction cond : pas de aut
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				break;
				
			case 860: // instruction cond : fcond
				int positionPile = pileRep.depiler();
				int nouvelleValeur = po.getIpo() + 1;
				int positionTemporaire;
				while (positionPile > 0) {
					positionTemporaire = po.getElt(positionPile);
					po.modifier(positionPile, nouvelleValeur);
					positionPile = positionTemporaire;
				}
				break;
				
			// boucle
				
			case 890: // instruction tant que : avant tant que
				pileRep.empiler(po.getIpo() + 1);
				break;
				
			case 891: // instruction tant que : expression
				verifBool();
				po.produire(BSIFAUX);
				po.produire(0);
				pileRep.empiler(po.getIpo());
				modifVecteurTrans(TRANSCODE);
				break;
				
			case 892: // instruction tant que : apr�s tant que
				po.modifier(pileRep.depiler(), po.getIpo() + 3);
				po.produire(BINCOND);
				po.produire(pileRep.depiler());
				modifVecteurTrans(TRANSCODE);
				break;
				
			// lecture
				
			case 920: // lecture
				tabSymb_iCour = presentIdent(bc);
				if (tabSymb_iCour == 0)
					UtilLex.messErr("Lecture incorrecte : identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" non d�clar�");
				
				switch (tabSymb[tabSymb_iCour].type) {
					case BOOL:
						po.produire(LIREBOOL);
						break;
					case ENT:
						po.produire(LIRENT);
						break;
					case NEUTRE:
					default:
						UtilLex.messErr("Lecture incorrecte : type d'identificateur invalide");
						break;
				}
				
				switch (tabSymb[tabSymb_iCour].categorie) {
					case VARGLOBALE:
						po.produire(AFFECTERG);
						po.produire(tabSymb[tabSymb_iCour].info);
						modifVecteurTrans(TRANSDON);
						break;
					case VARLOCALE:
						po.produire(AFFECTERL);
						po.produire(tabSymb[tabSymb_iCour].info);
						po.produire(0);
						break;
					case PARAMMOD:
						po.produire(AFFECTERL);
						po.produire(tabSymb[tabSymb_iCour].info);
						po.produire(1);
						break;
					case CONSTANTE:
					case PARAMFIXE:
					case PROC:
					case DEF:
					case REF:
					case PRIVEE:
						UtilLex.messErr("Lecture incorrecte : variable attendue");
						break;
					default:
						UtilLex.messErr("Lecture incorrecte : cat�gorie d'identificateur invalide");
				}
				break;
				
			// ecriture
				
			case 950: // �criture
				switch (tCour) {
					case BOOL:
						po.produire(ECRBOOL);
						break;
					case ENT:
						po.produire(ECRENT);
						break;
					case NEUTRE:
					default:
						UtilLex.messErr("Ecriture incorrecte : type d'expression invalide");
						break;
				}
				break;
				
			// affouappel
				
			case 990: // affectation : premier identificateur
				tabSymb_iAffouappel = presentIdent(1);
				if (tabSymb_iAffouappel == 0)
					UtilLex.messErr("Affectation incorrecte : identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" non d�clar�");
				
				switch (tabSymb[tabSymb_iAffouappel].categorie) {
					case VARGLOBALE:
					case VARLOCALE:
					case PARAMMOD:
						break;
					case CONSTANTE:
					case PARAMFIXE:
					case PROC:
					case DEF:
					case REF:
					case PRIVEE:
						UtilLex.messErr("Affectation incorrecte : variable attendue");
						break;
					default:
						UtilLex.messErr("Affectation incorrecte : cat�gorie d'identificateur invalide");
				}
				break;
				
			case 991: // affectation : expression
				switch (tabSymb[tabSymb_iAffouappel].type) {
					case BOOL:
						verifBool();
						break;
					case ENT:
						verifEnt();
						break;
					case NEUTRE:
					default:
						UtilLex.messErr("Affectation incorrecte : type d'identificateur invalide");
						break;
				}
				
				switch (tabSymb[tabSymb_iAffouappel].categorie) {
					case VARGLOBALE:
						po.produire(AFFECTERG);
						po.produire(tabSymb[tabSymb_iAffouappel].info);
						modifVecteurTrans(TRANSDON);
						break;
					case VARLOCALE:
						po.produire(AFFECTERL);
						po.produire(tabSymb[tabSymb_iAffouappel].info);
						po.produire(0);
						break;
					case PARAMMOD:
						po.produire(AFFECTERL);
						po.produire(tabSymb[tabSymb_iAffouappel].info);
						po.produire(1);
						break;
					case CONSTANTE:
					case PARAMFIXE:
					case PROC:
					case DEF:
					case REF:
					case PRIVEE:
						UtilLex.messErr("Affectation incorrecte : variable attendue");
						break;
					default:
						UtilLex.messErr("Affectation incorrecte : cat�gorie d'identificateur invalide");
				}
				break;
				
			case 1000: // appel : premier identificateur
				tabSymb_iAffouappel = presentIdent(1);
				if (tabSymb_iAffouappel == 0)
					UtilLex.messErr("Appel incorrect : identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" non d�clar�");
				if (tabSymb[tabSymb_iAffouappel].categorie != PROC)
					UtilLex.messErr("Appel incorrect : proc�dure attendue");

				nbParamsFixes = 0;
				nbParamsMods = 0;
				break;
				
			case 1001: // appel : apr�s appel
				if (tabSymb[tabSymb_iAffouappel + 1].info != nbParamsFixes + nbParamsMods)
					UtilLex.messErr("Appel incorrect : " + tabSymb[tabSymb_iAffouappel + 1].info + " param�tre(s) attendu(s)");
				
				po.produire(APPEL);
				po.produire(tabSymb[tabSymb_iAffouappel].info);
				if (tabSymb[tabSymb_iAffouappel + 1].categorie == REF)
					modifVecteurTrans(REFEXT);
				else
					modifVecteurTrans(TRANSCODE);
				po.produire(tabSymb[tabSymb_iAffouappel+1].info);
				break;
				
			// effixes
				
			case 1040: // param�tres fixes
				tabSymb_iParam = tabSymb_iAffouappel + 1 + ++nbParamsFixes;
				if (tabSymb[tabSymb_iParam].categorie != PARAMFIXE)
					UtilLex.messErr("Param�tre " + nbParamsFixes + " incorrect : fixe attendu");
				if (tabSymb[tabSymb_iParam].type != tCour)
					UtilLex.messErr("Param�tre " + nbParamsFixes + " incorrect : mauvais type");
				break;
				
			// effmods
				
			case 1070: // param�tres mods
				tabSymb_iCour = presentIdent(1);
				if (tabSymb_iCour == 0)
					UtilLex.messErr("Param�tre " + (nbParamsFixes + nbParamsMods) + " incorrect : identificateur \"" + UtilLex.repId(UtilLex.numId) + "\" non d�clar�");

				switch (tabSymb[tabSymb_iCour].categorie) {
					case VARGLOBALE:
						po.produire(EMPILERADG);
						po.produire(tabSymb[tabSymb_iCour].info);
						modifVecteurTrans(TRANSDON);
						break;
					case VARLOCALE:
						po.produire(EMPILERADL);
						po.produire(tabSymb[tabSymb_iCour].info);
						po.produire(0);
						break;
					case PARAMMOD:
						po.produire(EMPILERADL);
						po.produire(tabSymb[tabSymb_iCour].info);
						po.produire(1);
						break;
					case CONSTANTE:
					case PARAMFIXE:
					case PROC:
					case DEF:
					case REF:
					case PRIVEE:
						UtilLex.messErr("Param�tre " + (nbParamsFixes + nbParamsMods) + " incorrect : variable attendue");
						break;
					default:
						UtilLex.messErr("Param�tre " + (nbParamsFixes + nbParamsMods) + " incorrect : cat�gorie d'identificateur invalide");
				}
				
				tabSymb_iParam = tabSymb_iAffouappel + 1 + nbParamsFixes + ++nbParamsMods;
				if (tabSymb[tabSymb_iParam].categorie != PARAMMOD)
					UtilLex.messErr("Param�tre " + (nbParamsFixes + nbParamsMods) + " incorrect : mod attendu");
				if (tabSymb[tabSymb_iParam].type != tabSymb[tabSymb_iCour].type)
					UtilLex.messErr("Param�tre " + (nbParamsFixes + nbParamsMods) + " incorrect : mauvais type");
				break;
				
			// expression
				
			case 1110: // v�rification type expressions bool�ennes
				verifBool();
				break;
			case 1111: // apr�s expression ou
				po.produire(OU);
				break;
				
			// exp1
				
			case 1131: // expression et
				po.produire(ET);
				break;
				
			// exp 2
				
			case 1160: // expression non
				verifBool();
				po.produire(NON);
				break;
				
			// exp 3
				
			case 1200: // v�rification type expressions enti�re
				verifEnt();
				break;
				
			case 1201: // chargement type expressions enti�res
				tCour = BOOL;
				break;
				
			case 1211: // expression =
				po.produire(EG);
				break;
			case 1221: // expression <>
				po.produire(DIFF);
				break;
			case 1231: // expression >
				po.produire(SUP);
				break;
			case 1241: // expression >=
				po.produire(SUPEG);
				break;
			case 1251: // expression <
				po.produire(INF);
				break;
			case 1261: // expression <=
				po.produire(INFEG);
				break;
				
			// exp 4

			case 1310: // expression +
				po.produire(ADD);
				break;
			case 1320: // expression -
				po.produire(SOUS);
				break;
				
			// exp 5

			case 1370: // expression *
				po.produire(MUL);
				break;
			case 1380: // expression div
				po.produire(DIV);
				break;
				
			// primaire
				
			case 1420: // primaire constante
				po.produire(EMPILER);
				po.produire(vCour);
				break;
				
			case 1430: // primaire identificateur
				tabSymb_iCour = presentIdent(1);
				if (tabSymb_iCour == 0)
					UtilLex.messErr("Expression incorrecte : " + UtilLex.repId(UtilLex.numId) + " non d�clar�");
				tCour = tabSymb[tabSymb_iCour].type;

				switch (tabSymb[tabSymb_iCour].categorie) {
					case CONSTANTE:
						po.produire(EMPILER);
						po.produire(tabSymb[tabSymb_iCour].info);
						break;
					case VARGLOBALE:
						po.produire(CONTENUG);
						po.produire(tabSymb[tabSymb_iCour].info);
						modifVecteurTrans(TRANSDON);
						break;
					case VARLOCALE:
					case PARAMFIXE:
						po.produire(CONTENUL);
						po.produire(tabSymb[tabSymb_iCour].info);
						po.produire(0);
						break;
					case PARAMMOD:
						po.produire(CONTENUL);
						po.produire(tabSymb[tabSymb_iCour].info);
						po.produire(1);
						break;
					case PROC:
					case DEF:
					case REF:
					case PRIVEE:
						UtilLex.messErr("Expression incorrecte : variable ou constante attendue");
						break;
					default:
						UtilLex.messErr("Expression incorrecte : cat�gorie d'identificateur invalide");
				}
				break;
				
			// valeur
				
			case 1470: // valeur enti�re positive
				tCour = ENT;
				vCour = UtilLex.valNb;
				break;
			case 1490: // valeur enti�re n�gative
				tCour = ENT;
				vCour = - UtilLex.valNb;
				break;
				
			case 1500: // valeur bool�enne vraie 
				tCour = BOOL;
				vCour = VRAI;
				break;
			case 1510: // valeur bool�enne fausse 
				tCour = BOOL;
				vCour = FAUX;
				break;
			
			default:
				System.out.println("Point de generation non prevu dans votre liste");
				break;
		}
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
 