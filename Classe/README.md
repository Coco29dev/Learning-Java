# Documentation Java : Les Fondamentaux des Classes

## Introduction aux classes

En Java, une classe est un modèle (blueprint) qui définit les caractéristiques et comportements d'un type d'objet. C'est l'élément fondamental de la programmation orientée objet (POO).

Une classe en Java peut être considérée comme un plan architectural qui définit :
- Des attributs (variables d'instance) qui représentent l'état de l'objet
- Des méthodes (fonctions) qui représentent le comportement de l'objet
- Des constructeurs pour initialiser les objets
- Des blocs d'initialisation
- Des classes et interfaces imbriquées

Conceptuellement, si nous prenons l'exemple d'une voiture :
- La **classe** serait le plan de conception général d'une voiture
- Les **attributs** seraient les caractéristiques comme la couleur, la marque, le modèle
- Les **méthodes** seraient les actions qu'une voiture peut effectuer comme démarrer, accélérer, freiner
- Un **objet** serait une voiture spécifique créée selon ce plan

```java
// Exemple simple d'une classe Voiture
public class Voiture {
    // Des attributs et méthodes seront définis ici
}
```

## Déclaration d'une classe

La syntaxe de base pour déclarer une classe en Java est la suivante :

```java
[modificateurs] class NomDeLaClasse [extends ClasseParent] [implements Interface1, Interface2, ...] {
    // Corps de la classe
    // Attributs, méthodes, constructeurs, etc.
}
```

Où :
- `[modificateurs]` : peut être `public`, `protected`, `private`, `abstract`, `final`, etc.
- `NomDeLaClasse` : doit commencer par une majuscule (convention)
- `[extends ClasseParent]` : facultatif, pour l'héritage
- `[implements Interface1, Interface2, ...]` : facultatif, pour implémenter des interfaces

Exemples de déclarations de classes :

```java
// Classe publique simple
public class Utilisateur {
    // Corps de la classe
}

// Classe finale (ne peut pas être étendue)
public final class Configuration {
    // Corps de la classe
}

// Classe abstraite (ne peut pas être instanciée directement)
public abstract class Forme {
    // Corps de la classe
}

// Classe avec héritage et implémentation d'interface
public class CompteCourant extends CompteBancaire implements Comparable<CompteCourant> {
    // Corps de la classe
}
```

Un fichier Java peut contenir plusieurs classes, mais une seule classe publique qui doit avoir le même nom que le fichier.

## Attributs (variables d'instance)

Les attributs sont des variables déclarées à l'intérieur de la classe mais en dehors des méthodes. Ils définissent l'état ou les propriétés des objets créés à partir de la classe.

```java
public class Personne {
    // Attributs
    private String nom;
    private String prenom;
    private int age;
    private double taille;  // en mètres
    private boolean estMarie;
    
    // Attribut statique (partagé par tous les objets de la classe)
    private static int nombrePersonnes = 0;
    
    // Constante de classe
    public static final String ESPECE = "Humain";
}
```

### Types de modificateurs d'accès pour les attributs

1. `public` : accessible depuis n'importe où
2. `protected` : accessible dans la classe, ses sous-classes et le même package
3. `private` : accessible uniquement dans la classe
4. (default/package) : accessible dans le même package (si aucun modificateur n'est spécifié)

### Autres modificateurs pour les attributs

1. `static` : attribut de classe (partagé par tous les objets)
2. `final` : valeur qui ne peut pas être modifiée après initialisation
3. `transient` : attribut qui ne sera pas sérialisé
4. `volatile` : utilisé dans les environnements multi-thread

### Bonnes pratiques pour les attributs

- Déclarer les attributs en `private` (encapsulation)
- Utiliser des getters et setters pour accéder aux attributs
- Initialiser les attributs avec des valeurs par défaut
- Utiliser des noms significatifs en camelCase

```java
public class Etudiant {
    private String numeroEtudiant; // Bon : nom significatif
    private int age; // Bon : simple et clair
    private double m_moyenne; // À éviter : style de nommage incohérent
    public String adresse; // À éviter : attribut public
}
```

## Méthodes

Les méthodes définissent le comportement des objets de la classe. Elles représentent les actions qu'un objet peut effectuer.

### Syntaxe de base

```java
[modificateurs] typeRetour nomMethode([paramètres]) [throws exceptions] {
    // Corps de la méthode
    [return valeur;]
}
```

### Types de méthodes

1. **Méthodes d'instance** : opèrent sur un objet spécifique
2. **Méthodes statiques** : appartiennent à la classe et non à l'instance
3. **Méthodes d'accesseur** (getters) : retournent la valeur d'un attribut
4. **Méthodes de mutateur** (setters) : modifient la valeur d'un attribut

```java
public class CompteBancaire {
    private String numero;
    private double solde;
    private static double tauxInteret = 0.02; // 2%
    
    // Méthode d'instance
    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Dépôt de " + montant + "€ effectué");
        }
    }
    
    // Méthode avec valeur de retour
    public boolean retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + "€ effectué");
            return true;
        }
        System.out.println("Retrait impossible");
        return false;
    }
    
    // Getter (accesseur)
    public double getSolde() {
        return solde;
    }
    
    // Setter (mutateur)
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    // Méthode statique
    public static double getTauxInteret() {
        return tauxInteret;
    }
    
    // Méthode qui calcule les intérêts annuels
    public double calculerInterets() {
        return solde * tauxInteret;
    }
}
```

### Signature de méthode

La signature d'une méthode comprend :
- Le nom de la méthode
- Le nombre, le type et l'ordre des paramètres

Le type de retour ne fait pas partie de la signature.

### Surcharge de méthode

La surcharge permet de définir plusieurs méthodes avec le même nom mais des paramètres différents.

```java
public class Calculatrice {
    // Surcharge de la méthode additionner
    public int additionner(int a, int b) {
        return a + b;
    }
    
    public double additionner(double a, double b) {
        return a + b;
    }
    
    public int additionner(int a, int b, int c) {
        return a + b + c;
    }
}
```

## Constructeurs

Les constructeurs sont des méthodes spéciales utilisées pour initialiser les objets lors de leur création avec l'opérateur `new`.

### Caractéristiques des constructeurs

- Même nom que la classe
- Pas de type de retour (même pas `void`)
- Peuvent être surchargés (plusieurs constructeurs avec différents paramètres)
- Si aucun constructeur n'est défini, Java fournit un constructeur par défaut sans paramètres

```java
public class Personne {
    private String nom;
    private String prenom;
    private int age;
    
    // Constructeur par défaut
    public Personne() {
        // Initialisation par défaut
        this.nom = "Inconnu";
        this.prenom = "Inconnu";
        this.age = 0;
        System.out.println("Création d'une personne avec valeurs par défaut");
    }
    
    // Constructeur avec paramètres
    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        
        // Validation des données
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
        
        System.out.println("Création de " + prenom + " " + nom);
    }
    
    // Constructeur avec moins de paramètres, réutilisant un autre constructeur
    public Personne(String nom, String prenom) {
        this(nom, prenom, 0); // Appelle le constructeur avec 3 paramètres
    }
}
```

### Utilisation des constructeurs

```java
// Création d'objets avec différents constructeurs
Personne p1 = new Personne(); // Utilise le constructeur par défaut
Personne p2 = new Personne("Dupont", "Jean", 30); // Constructeur avec 3 paramètres
Personne p3 = new Personne("Martin", "Sophie"); // Constructeur avec 2 paramètres
```

### Bloc d'initialisation

En plus des constructeurs, Java permet de définir des blocs d'initialisation qui sont exécutés lors de la création d'un objet.

```java
public class Exemple {
    private int x;
    
    // Bloc d'initialisation (exécuté avant le constructeur)
    {
        x = 10;
        System.out.println("Bloc d'initialisation exécuté");
    }
    
    // Bloc d'initialisation statique (exécuté une seule fois lors du chargement de la classe)
    static {
        System.out.println("Bloc statique exécuté");
    }
    
    public Exemple() {
        System.out.println("Constructeur exécuté");
    }
}
```

## L'objet `this`

Le mot-clé `this` fait référence à l'instance courante de la classe. Il est particulièrement utile pour distinguer les variables d'instance des paramètres de méthode qui portent le même nom.

### Utilisations de `this`

1. **Référencer des variables d'instance**
   ```java
   public class Point {
       private int x, y;
       
       public void setCoordonnees(int x, int y) {
           this.x = x; // this.x fait référence à la variable d'instance
           this.y = y; // y seul ferait référence au paramètre
       }
   }
   ```

2. **Appeler un autre constructeur**
   ```java
   public class Rectangle {
       private int longueur, largeur;
       
       public Rectangle() {
           this(1, 1); // Appelle le constructeur avec deux paramètres
       }
       
       public Rectangle(int longueur, int largeur) {
           this.longueur = longueur;
           this.largeur = largeur;
       }
   }
   ```

3. **Passer l'instance courante en paramètre**
   ```java
   public class Utilisateur {
       private String nom;
       
       public void enregistrer(RegistreUtilisateurs registre) {
           registre.ajouter(this); // Passe l'instance courante
       }
   }
   ```

4. **Retourner l'instance courante pour permettre le chaînage de méthodes**
   ```java
   public class Builder {
       private String valeur1;
       private int valeur2;
       
       public Builder setValeur1(String valeur) {
           this.valeur1 = valeur;
           return this; // Retourne l'instance pour permettre le chaînage
       }
       
       public Builder setValeur2(int valeur) {
           this.valeur2 = valeur;
           return this;
       }
       
       // Utilisation :
       // Builder b = new Builder().setValeur1("test").setValeur2(42);
   }
   ```

## Encapsulation

L'encapsulation est l'un des principes fondamentaux de la programmation orientée objet. Elle consiste à regrouper les données (attributs) et les méthodes qui les manipulent dans une même unité (la classe) tout en restreignant l'accès direct aux attributs.

### Avantages de l'encapsulation

1. **Protection des données** : empêche l'accès direct et la modification inappropriée
2. **Abstraction** : masque les détails d'implémentation
3. **Maintenance facilitée** : permet de modifier l'implémentation sans affecter les utilisateurs de la classe
4. **Validation des données** : permet de contrôler les valeurs attribuées aux attributs

### Mise en œuvre de l'encapsulation

1. **Déclarer les attributs comme private**
2. **Fournir des méthodes publiques (getters et setters) pour accéder aux attributs**
3. **Implémenter une validation dans les setters si nécessaire**

```java
public class CompteBancaire {
    // Attributs privés
    private String numero;
    private String titulaire;
    private double solde;
    
    // Constructeur
    public CompteBancaire(String numero, String titulaire) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = 0.0;
    }
    
    // Getters (accesseurs)
    public String getNumero() {
        return numero;
    }
    
    public String getTitulaire() {
        return titulaire;
    }
    
    public double getSolde() {
        return solde;
    }
    
    // Setter avec validation
    public void setTitulaire(String titulaire) {
        if (titulaire != null && !titulaire.trim().isEmpty()) {
            this.titulaire = titulaire;
        }
    }
    
    // Pas de setter pour solde car il doit être modifié via des méthodes spécifiques
    
    // Méthodes métier (comportement)
    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Dépôt de " + montant + "€ effectué");
        } else {
            System.out.println("Le montant du dépôt doit être positif");
        }
    }
    
    public boolean retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + "€ effectué");
            return true;
        }
        System.out.println("Retrait impossible");
        return false;
    }
    
    // Méthode pour afficher les informations du compte
    public void afficherInfos() {
        System.out.println("Compte n° " + numero);
        System.out.println("Titulaire : " + titulaire);
        System.out.println("Solde : " + solde + "€");
    }
}
```

### Exemple d'utilisation

```java
public class TestCompteBancaire {
    public static void main(String[] args) {
        // Création d'un compte
        CompteBancaire compte = new CompteBancaire("FR7612345", "Marie Dupont");
        
        // Utilisation des méthodes pour manipuler les données
        compte.deposer(1000);
        compte.retirer(200);
        
        // Accès aux attributs via les getters
        System.out.println("Titulaire : " + compte.getTitulaire());
        System.out.println("Solde actuel : " + compte.getSolde() + "€");
        
        // Modification du titulaire via le setter
        compte.setTitulaire("Marie Martin");
        
        // Affichage des informations
        compte.afficherInfos();
        
        // Impossible d'accéder directement aux attributs privés
        // compte.solde = -1000; // Erreur de compilation
    }
}
```

L'encapsulation permet ainsi de créer des classes robustes, faciles à maintenir et qui protègent leurs données contre les modifications involontaires ou incorrectes.
