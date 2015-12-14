import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.security.auth.kerberos.KerberosKey;


public class Dictionnaire {

	public static int k=0;
	
	public static boolean find(String mot){
		Charset charset=Charset.forName("UTF-8");
		Path path= Paths.get("/home/eleves/2018/aribeyrolles/workspace/TP8/src/dico1.txt");
		boolean test=false;
		try (BufferedReader reader=Files.newBufferedReader(path, charset)){
			String line=null;
			while ((line=reader.readLine())!=null){
				if (mot.equals(line)){
					test=true;
				}
			}
			return test;
		}catch (IOException x){
			System.err.format("IOException: %s%n", x);
			return test;
		}
	}
	
	public static String chose(){
		Charset charset=Charset.forName("UTF-8");
		Path path= Paths.get("/home/eleves/2018/aribeyrolles/workspace/TP8/src/dico1.txt");
		String motaleatoire="f";
		int k=0, compteur=0;
		try (BufferedReader reader=Files.newBufferedReader(path, charset)){
			String line=null;
			while ((line=reader.readLine())!=null){
				k++;
				}
			
			int i= (int)(Math.random()*(k-1)); //random un chiffre dans la range du fichier
			
			BufferedReader reader1=Files.newBufferedReader(path, charset);
			
			while ((line=reader1.readLine())!=null){
				compteur++;
				if (compteur==i){
					return line;
				}
			}				
			System.out.println("nombre de lignes : "+k);
			System.out.println("ligne aléatoire :"+i);
			System.out.println(motaleatoire);
			return line;
		}catch (IOException x){
			System.err.format("IOException: %s%n", x);
			return motaleatoire;
		}
	}
	
	public static String evaluer(String motgenere, String motvoulu){
		String code="";

		if (motvoulu.length()==motgenere.length()){
			for (int i=0; i<motvoulu.length(); i++){
				if (motvoulu.charAt(i)==motgenere.charAt(i)){
					code+= "o";
				}
				if (motvoulu.charAt(i)!=motgenere.charAt(i) && motgenere.indexOf(motvoulu.charAt(i))!=-1){
					code+= "-";
				}
				if (motgenere.indexOf(motvoulu.charAt(i))==-1){
					code+="x";
				}
			}	
		}

		return code;
	}
	
	public static void main(String[] args) {
		String motdemande="lapin";
		System.out.println("Le mot '"+motdemande+ "' est-il dans le dico?  :  "+find(motdemande));
		String test = chose();
		System.out.println("Le mot généré aléatoirement est : "+test);
		boolean egal=false;
		Scanner sc = new Scanner(System.in);

		while (!egal){
			System.out.println("");
			System.out.println("> A quel mot pensez-vous?");
			String motvoulu=sc.nextLine();

			if (motvoulu.length() == test.length()) {
				if (find(motvoulu)) {
					k++;
					System.out.print(evaluer(test, motvoulu));
				} else {
					System.out.println("");
					System.out.println("Le mot demandé n'est pas dans le dictionnaire.");
				}
				if (motvoulu.equals(test)) {
					egal=true;
				}
			} else {
				System.out.println("");
				System.out.println("La taille du mot demandé n'est pas de taille 7.");
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Trouver le mot vous a pris " +k+" essais.");
		//evaluer(motvoulu, chose());
		
	}

}
