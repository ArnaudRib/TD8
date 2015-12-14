

public class ArbreBinaire {

	//attributs
	private String nomSommet;
	private ArbreBinaire filsGauche;
	private ArbreBinaire filsDroit;

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
	
	
	public static ArbreBinaire inserer(String str, ArbreBinaire a){
	      if (a == null)
	        return new ArbreBinaire(str, null, null);
	      if (str.compareTo(a.nomSommet) <= 0)
	        a.filsGauche = inserer(str, a.filsGauche);
	      else if (str.compareTo(a.nomSommet) >= 0)
		     a.filsDroit = inserer(str, a.filsDroit);
	      return a;
	    }

	public static boolean contient(String str,ArbreBinaire a){
		boolean test=false;
			if (a.filsGauche != null){
				if (str.compareTo(a.filsGauche.nomSommet)!=0){
					test=contient(str, a.filsGauche);
				}else{
					test=true;
				}
			}
			if (a.filsDroit != null && test==false){
				if (str.compareTo(a.filsDroit.nomSommet)!=0){
					test=contient(str, a.filsDroit);
				}else{
					test=true;
				}
			}
		return test;
	}
	
	public static int i;
	
	public static int compteRecherche(String str,ArbreBinaire a, boolean test){
		if (a.filsGauche != null){
			if (str.compareTo(a.filsGauche.nomSommet)!=0){
				i++;
				i=compteRecherche(str, a.filsGauche, test);
			}else{
				test=true;
			}
		}
		if (a.filsDroit != null && test==false){
			if (str.compareTo(a.filsDroit.nomSommet)!=0){
				i=compteRecherche(str, a.filsDroit, test);	
			}else{
				test=true;
			}
		}
		return i;
	}
	
	//main
	public static void main(String[] args) {
		ArbreBinaire arbre2 =new ArbreBinaire("the", null, null);
		inserer("quick",arbre2);
		inserer("brown",arbre2);
		inserer("fox",arbre2);
		inserer("jumps",arbre2);
		inserer("over",arbre2);
		inserer("the",arbre2);
		inserer("lazy",arbre2);
		inserer("dog",arbre2);
		System.out.println("affichage préfixe: ");
		AffichagePrefixe(arbre2);
		System.out.println("affichage en largeur: ");
		afficheEnLargeur(arbre2);
		System.out.println("");
		String mot ="dog";
		System.out.println("Le mot "+mot+" est-il dans l'arbre? "+contient(mot, arbre2));
		System.out.println("Le mot 'lapin' est-il dans l'arbre? "+contient("lapin", arbre2));
		boolean test=false;

		System.out.println("Nombre de recherche : "+compteRecherche("lazy", arbre2, test)+".");
	}
}
