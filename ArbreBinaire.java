import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class ArbreBinaire {

	//attributs
	String nomSommet;
	ArbreBinaire filsGauche;
	ArbreBinaire filsDroit;

	//constructeurs
	public ArbreBinaire(String nomSommet){
		this.nomSommet=nomSommet;
	}
	
	public ArbreBinaire(String nomSommet, ArbreBinaire filsGauche, ArbreBinaire filsDroit){
		this.nomSommet=nomSommet;
		this.filsGauche=filsGauche;
		this.filsDroit=filsDroit;
	}
	
	public static void AffichagePrefixe(ArbreBinaire Arbre){ 
		System.out.print(Arbre.nomSommet+" ");
		if (Arbre.filsGauche != null)
			AffichagePrefixe(Arbre.filsGauche);
		if (Arbre.filsDroit != null)
			AffichagePrefixe(Arbre.filsDroit);	
	}
	
	
	public static int profondeur(ArbreBinaire Arbre){ // Q 3.1
	    if(Arbre == null)
	        return 0;
	    else {
	        return 1+Math.max(profondeur(Arbre.filsGauche), profondeur(Arbre.filsDroit));
	    }
	}
	
	
	public static String heigth(ArbreBinaire Arbre, int prof) { // Q  3.2
	    String G, D;
	    if (Arbre == null) {
	    	return "";
	    }
	    if (prof > 0) {
	    	G = heigth(Arbre.filsGauche, prof-1);
	    	D = heigth(Arbre.filsDroit, prof-1);
	    	return G+D;
	    } else {
	    	return Arbre.nomSommet;
	    }
	}
	
	public static void afficheEnLargeur(ArbreBinaire racine) { // Q  3.2
	    int i = 0;
	    String s;
	    while (heigth(racine, i).length() > 0){
	    	s = heigth(racine, i);
	    	System.out.print("("+s+") ");
	    	i++;
	    }
	}
	
	public static void parcoursAleatoire(ArbreBinaire a){
		Random r = new Random();
		if (a!=null){
			System.out.print(a.nomSommet);
			if (r.nextInt()%2==0){
				parcoursAleatoire(a.filsGauche);
				parcoursAleatoire(a.filsDroit);
			}else{
				parcoursAleatoire(a.filsDroit);
				parcoursAleatoire(a.filsGauche);
			}
		}
	}
	
	public static void parcoursAleatoire2(ArbreBinaire a){
		Random r = new Random();
		int rr=r.nextInt()%3;
		if (a!=null){
			if(rr==0){
				System.out.print(a.nomSommet);
				parcoursAleatoire2(a.filsDroit);
				parcoursAleatoire2(a.filsGauche);
			} else if (rr==1){
				parcoursAleatoire2(a.filsDroit);
				System.out.print(a.nomSommet);
				parcoursAleatoire2(a.filsGauche);
			}else{
				parcoursAleatoire2(a.filsDroit);
				parcoursAleatoire2(a.filsGauche);
				System.out.print(a.nomSommet);
			}
		}
	}
	
	
	//main
	public static void main(String[] args) {
		//ARBRE1
		
			//Création
		ArbreBinaire H = new ArbreBinaire("H");
		ArbreBinaire G = new ArbreBinaire("G");
		ArbreBinaire D = new ArbreBinaire("D");
		ArbreBinaire F = new ArbreBinaire("F");
		ArbreBinaire E = new ArbreBinaire("E", G, H);
		ArbreBinaire B=new ArbreBinaire("B", D, E);
		ArbreBinaire C=new ArbreBinaire("C", F, null);
		ArbreBinaire arbre1 =new ArbreBinaire("A", B, C);
		
			//Affichage
		System.out.print("Affichage préfixe :  ");
		AffichagePrefixe(arbre1);
		System.out.println("");
		System.out.println("Pronfondeur : " + profondeur(arbre1));
		System.out.print("Affichage en largeur :  ");
		afficheEnLargeur(arbre1);
		
		System.out.println("");
		System.out.println("");

		
		//ARBRE 2
			//Création
		ArbreBinaire filsGauchetest = new ArbreBinaire("B");
		ArbreBinaire filsDroittest = new ArbreBinaire("C");
		ArbreBinaire arbre2 =new ArbreBinaire("A", filsGauchetest, filsDroittest);
			//Affichage
		System.out.print("Affichage préfixe :  ");
		AffichagePrefixe(arbre2);
		System.out.println("");
		System.out.println("Pronfondeur : " +profondeur(arbre2));
		System.out.print("Affichage en largeur :  ");
		afficheEnLargeur(arbre2);
		
		System.out.println("");
		System.out.println("");
		System.out.println("Random1 arbre1 : ");
		parcoursAleatoire(arbre1);

		System.out.println("");
		System.out.println("");
		System.out.println("Random2 arbre1 : ");
		parcoursAleatoire2(arbre1);
	}
}

