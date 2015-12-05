## Q 3.1.1 :

1. Exemple de parcours en profondeur préfixée, postfixée, et infixée : 
    -		affichage préfixé : on visite A en premier, puis B puis C,
    -		affichage postfixé : on visite B, ensuite C et enfin A,
    -		affichage infixé : on visite B, puis A et enfin C.

2. Pseudo code affichage préfixé pour l'arbre ABC :

```java
System.out.println(arbre1.nomSommet); 
System.out.println(arbre1.filsGauche.nomSommet);
System.out.println(arbre1.filsDroit.nomSommet);
```
PS : (extra) le code correspondant est la fonction AffichagePrefixe sur le ArbreBinaire.java.

## Q 3.2 :
Exemple de parcours en largeur de la figure 1 : 

* (A) (BC) (DEF) (GH)
* (A) (CB) (FED) (HG)

PS : (extra) le code correspondant est la fonction AffichagEnLargeur sur le ArbreBinaire.java.



Photo de la console après l'exécution du programme ArbreBinaire.java : 

![ArbreBinaire](https://github.com/ArnaudRib/TD6/blob/master/ArbreBinaire.png)
