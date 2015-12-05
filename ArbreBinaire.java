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
		System.out.println(Arbre.nomSommet);
		if (Arbre.filsGauche != null)
			AffichagePrefixe(Arbre.filsGauche);
		if (Arbre.filsDroit != null)
			AffichagePrefixe(Arbre.filsDroit);	
	}
	
	
	public static int profondeur(ArbreBinaire Arbre){
	    if(Arbre == null)
	        return 0;
	    else {
	        return 1+Math.max(profondeur(Arbre.filsGauche), profondeur(Arbre.filsDroit));
	    }
	}
	
	//main
	public static void main(String[] args) {
		//création de l'arbre de la figure 1.
		ArbreBinaire H = new ArbreBinaire("H");
		ArbreBinaire G = new ArbreBinaire("G");
		ArbreBinaire D = new ArbreBinaire("D");
		ArbreBinaire F = new ArbreBinaire("F");
		ArbreBinaire E = new ArbreBinaire("E", G, H);
		ArbreBinaire B=new ArbreBinaire("B", D, E);
		ArbreBinaire C=new ArbreBinaire("C", F, null);
		ArbreBinaire arbre1 =new ArbreBinaire("A", B, C);
		AffichagePrefixe(arbre1);
		System.out.println("Pronfondeur de l'arbre 1 : " + profondeur(arbre1));
		
		System.out.println("");
		System.out.println("");

		ArbreBinaire filsGauchetest = new ArbreBinaire("B");
		ArbreBinaire filsDroittest = new ArbreBinaire("C");
		ArbreBinaire arbre2 =new ArbreBinaire("A", filsGauchetest, filsDroittest);
		AffichagePrefixe(arbre2);
		System.out.println("Pronfondeur de l'arbre 2 : " +profondeur(arbre2));


	//	System.out.println(profondeur(arbre2));

		
	}
}

// Q 3.1.1 : 
//   Pour ABC
// 		affichage préfixé : on visite A en premier, puis B puis C,
// 		affichage postfixé : on visite B, ensuite C et enfin A,
// 		affichage infixé : on visite B, puis A et enfin C.

//Pseudo code affichage préfixé :
//   Pour ABC
// 		System.out.println(arbre1.nomSommet); 
//   	System.out.println(arbre1.filsGauche.nomSommet);
//		System.out.println(arbre1.filsDroit.nomSommet);