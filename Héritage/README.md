# Documentation Java : Le Principe de l'Héritage

## Table des matières
1. [Introduction à l'héritage](#introduction-à-lhéritage)
2. [Syntaxe et mise en œuvre](#syntaxe-et-mise-en-œuvre)
3. [La relation "est un"](#la-relation-est-un)
4. [La classe parente (superclasse)](#la-classe-parente-superclasse)
5. [Les classes enfants (sous-classes)](#les-classes-enfants-sous-classes)
6. [Le mot-clé `super`](#le-mot-clé-super)
7. [Redéfinition de méthodes (Override)](#redéfinition-de-méthodes-override)
8. [L'héritage et les constructeurs](#lhéritage-et-les-constructeurs)
9. [Hiérarchie d'héritage](#hiérarchie-dhéritage)
10. [Polymorphisme](#polymorphisme)
11. [Limitations de l'héritage en Java](#limitations-de-lhéritage-en-java)
12. [Bonnes pratiques](#bonnes-pratiques)
13. [Cas pratique complet](#cas-pratique-complet)

## Introduction à l'héritage

L'héritage est l'un des principes fondamentaux de la programmation orientée objet (POO). Il permet à une classe d'hériter des attributs et des méthodes d'une autre classe. Ce mécanisme favorise la réutilisation du code et établit une relation hiérarchique entre les classes.

En Java, l'héritage se traduit par la capacité d'une classe (appelée sous-classe ou classe enfant) à hériter des caractéristiques et comportements d'une autre classe (appelée superclasse ou classe parente).

**Avantages de l'héritage :**
- Réutilisation du code
- Organisation hiérarchique des classes
- Extension des fonctionnalités existantes
- Spécialisation des comportements
- Support du polymorphisme

## Syntaxe et mise en œuvre

En Java, l'héritage est implémenté à l'aide du mot-clé `extends` :

```java
public class ClasseEnfant extends ClasseParente {
    // Contenu de la classe enfant
}
```

Dans notre exemple, les classes `Poisson` et `Oiseau` héritent de la classe `Animal` :

```java
public class Poisson extends Animal {
    // Contenu spécifique à la classe Poisson
}

public class Oiseau extends Animal {
    // Contenu spécifique à la classe Oiseau
}
```

Cette syntaxe établit une relation d'héritage où `Poisson` et `Oiseau` sont des sous-classes d'`Animal`, et héritent donc de ses attributs et méthodes.

## La relation "est un"

L'héritage établit une relation "est un" (is-a) entre la sous-classe et la superclasse. Dans notre exemple :
- Un `Poisson` est un `Animal`
- Un `Oiseau` est un `Animal`

Cette relation signifie que tout objet d'une sous-classe peut être traité comme un objet de sa superclasse. Par exemple, un objet `Poisson` peut être assigné à une variable de type `Animal` :

```java
Animal monAnimal = new Poisson("Poisson", "Rivière", false, "Carpe", 56, 7);
```

Cette relation "est un" est fondamentale pour comprendre l'héritage et ses implications en terme de polymorphisme.

## La classe parente (superclasse)

Dans notre exemple, `Animal` est la classe parente. Elle définit les caractéristiques communes à tous les animaux :

```java
public class Animal {
    // Attributs de la classe animal
    private String ordre;
    private String habitat;
    private boolean menacé;

    // Constructeur de la classe animal
    public Animal(final String ordre, final String habitat, final boolean menacé) {
        this.ordre = ordre;
        this.habitat = habitat;
        this.menacé = menacé;
    }

    // Getters et setters...

    // Méthode avec utilisation de l'héritage signalé par @Override
    @Override
    public String toString() {
        return " Ordre: " + this.ordre + "\n" +
                " Habitat: " + this.habitat + "\n" +
                " Menacé: " + this.menacé + "\n";
    }
}
```

La classe `Animal` définit :
- Des attributs privés (`ordre`, `habitat`, `menacé`)
- Un constructeur qui initialise ces attributs
- Des getters et setters pour accéder et modifier ces attributs
- Une méthode `toString()` qui fournit une représentation textuelle de l'animal

Notez que la méthode `toString()` est annotée avec `@Override`. Cela indique que cette méthode redéfinit une méthode héritée de la classe `Object`, qui est la superclasse implicite de toutes les classes en Java.

## Les classes enfants (sous-classes)

Les classes `Poisson` et `Oiseau` sont des sous-classes d'`Animal`. Elles héritent des attributs et méthodes de la classe `Animal`, tout en ajoutant leurs propres spécificités.

### Classe Poisson

```java
public class Poisson extends Animal {
    // Attribut de la classe enfant
    private String name;
    private int taille;
    private int poids;

    // Constructeur de la classe enfant avec héritage des attributs de la classe parente
    public Poisson(final String ordre, final String habitat, final boolean menacé, final String name, final int taille,
            final int poids) {
        super(ordre, habitat, menacé);
        this.name = name;
        this.taille = taille;
        this.poids = poids;
    }

    // Getters et setters...

    // Méthode avec utilisation de l'héritage signalé par @Override
    @Override
    public String toString() {
        return super.toString() +
                " Nom: " + this.name + "\n" +
                " Taille: " + this.taille + " cm\n" +
                " Poids: " + this.poids + " kg";
    }
}
```

### Classe Oiseau

```java
public class Oiseau extends Animal {
    // Attributs
    private String name;
    private int taille;
    private int poids;

    // Constructeur de la classe enfant avec héritage des attributs de la classe parente
    public Oiseau(final String ordre, final String habitat, final boolean menacé, final String name, final int taille,
            final int poids) {
        super(ordre, habitat, menacé);
        this.name = name;
        this.taille = taille;
        this.poids = poids;
    }

    // Getters et setters...

    // Méthode avec utilisation de l'héritage
    @Override
    public String toString() {
        return super.toString() +
                " Name: " + this.name + "\n" +
                " Taille: " + this.taille + " cm\n" +
                " Poids: " + this.poids + " kg";
    }
}
```

Les deux sous-classes :
- Ajoutent leurs propres attributs (`name`, `taille`, `poids`)
- Définissent un constructeur qui initialise à la fois leurs propres attributs et ceux hérités de la classe parente
- Fournissent des getters et setters pour leurs attributs spécifiques
- Redéfinissent la méthode `toString()` pour inclure leurs informations spécifiques

## Le mot-clé `super`

Le mot-clé `super` en Java est utilisé pour faire référence à la superclasse. Il est utilisé de deux façons principales dans notre exemple :

### 1. Appel au constructeur de la superclasse

```java
super(ordre, habitat, menacé);
```

Cette ligne dans les constructeurs de `Poisson` et `Oiseau` appelle le constructeur de la classe parente `Animal` pour initialiser les attributs hérités. Cet appel doit être la première instruction du constructeur de la sous-classe.

### 2. Appel à une méthode de la superclasse

```java
@Override
public String toString() {
    return super.toString() +
            " Nom: " + this.name + "\n" +
            " Taille: " + this.taille + " cm\n" +
            " Poids: " + this.poids + " kg";
}
```

Ici, `super.toString()` appelle la méthode `toString()` de la classe parente `Animal`. Cela permet à la sous-classe d'étendre le comportement de la méthode parente plutôt que de la remplacer complètement.

## Redéfinition de méthodes (Override)

La redéfinition de méthodes (ou override) permet à une sous-classe de fournir une implémentation spécifique d'une méthode déjà définie dans sa superclasse. Dans notre exemple, les classes `Poisson` et `Oiseau` redéfinissent la méthode `toString()` héritée de la classe `Animal`.

```java
@Override
public String toString() {
    return super.toString() +
            " Nom: " + this.name + "\n" +
            " Taille: " + this.taille + " cm\n" +
            " Poids: " + this.poids + " kg";
}
```

Points importants sur la redéfinition de méthodes :

1. **Annotation `@Override`** : Cette annotation est facultative mais recommandée. Elle permet au compilateur de vérifier que la méthode redéfinit bien une méthode de la superclasse.

2. **Signature identique** : La méthode redéfinie doit avoir la même signature (nom, paramètres) que la méthode de la superclasse.

3. **Type de retour covariant** : Le type de retour peut être le même ou un sous-type du type de retour de la méthode de la superclasse.

4. **Visibilité** : La méthode redéfinie ne peut pas être moins accessible que la méthode de la superclasse.

5. **Extension vs remplacement** : Une méthode redéfinie peut étendre le comportement de la méthode parente (en utilisant `super`) ou le remplacer complètement.

## L'héritage et les constructeurs

Les constructeurs ne sont pas hérités par les sous-classes, mais les sous-classes doivent appeler un constructeur de la superclasse. Si la superclasse n'a pas de constructeur sans argument ou si la sous-classe souhaite appeler un constructeur spécifique de la superclasse, l'appel à `super(...)` doit être explicite.

Dans notre exemple, les constructeurs des classes `Poisson` et `Oiseau` appellent explicitement le constructeur de la classe `Animal` :

```java
public Poisson(final String ordre, final String habitat, final boolean menacé, final String name, final int taille,
        final int poids) {
    super(ordre, habitat, menacé); // Appel au constructeur de la superclasse
    this.name = name;
    this.taille = taille;
    this.poids = poids;
}
```

Règles importantes :
1. L'appel à `super(...)` doit être la première instruction du constructeur de la sous-classe.
2. Si aucun appel à `super(...)` n'est explicite, le compilateur insère automatiquement un appel à `super()` (constructeur sans argument) au début du constructeur de la sous-classe.
3. Si la superclasse n'a pas de constructeur sans argument, les sous-classes doivent obligatoirement appeler un autre constructeur explicitement.

## Hiérarchie d'héritage

En Java, l'héritage crée une hiérarchie de classes. Au sommet de cette hiérarchie se trouve la classe `Object`, qui est la superclasse implicite de toutes les classes.

Dans notre exemple, la hiérarchie est la suivante :
```
      Object
        |
      Animal
      /    \
Poisson    Oiseau
```

Une classe peut avoir plusieurs sous-classes, mais en Java, une classe ne peut hériter directement que d'une seule superclasse (héritage simple).

## Polymorphisme

Le polymorphisme est un concept étroitement lié à l'héritage. Il permet de traiter un objet d'une sous-classe comme un objet de sa superclasse. Le comportement réel dépendra de la classe concrète de l'objet à l'exécution.

Dans notre exemple, nous pouvons utiliser le polymorphisme comme suit :

```java
// Création d'objets des sous-classes
Animal animal1 = new Poisson("Poisson", "Rivière", false, "Carpe", 56, 7);
Animal animal2 = new Oiseau("Oiseau", "Jungle", true, "Ara", 78, 4);

// Appel de la méthode toString() - le comportement dépend de la classe réelle
System.out.println(animal1.toString()); // Utilise la méthode toString() de Poisson
System.out.println(animal2.toString()); // Utilise la méthode toString() de Oiseau
```

Ce code montre que même si `animal1` et `animal2` sont déclarés comme des variables de type `Animal`, leurs comportements réels (la méthode `toString()` appelée) dépendent de leurs classes concrètes respectives.

## Limitations de l'héritage en Java

1. **Héritage simple** : Une classe ne peut hériter directement que d'une seule superclasse. Pour pallier cette limitation, Java propose le mécanisme des interfaces.

2. **Héritage des attributs privés** : Les attributs privés de la superclasse sont hérités par la sous-classe, mais ils ne sont pas directement accessibles. Ils sont accessibles uniquement via les méthodes publiques ou protégées de la superclasse.

3. **Constructeurs non hérités** : Les constructeurs ne sont pas hérités, mais les sous-classes peuvent appeler les constructeurs de la superclasse avec `super(...)`.

4. **Finalité** : Les classes déclarées avec le modificateur `final` ne peuvent pas être étendues. De même, les méthodes déclarées `final` ne peuvent pas être redéfinies dans les sous-classes.

## Bonnes pratiques

1. **Utiliser l'héritage pour la relation "est un"** : L'héritage doit être utilisé uniquement lorsqu'il existe une relation "est un" réelle entre les classes.

2. **Favoriser la composition sur l'héritage** : Dans certains cas, la composition (avoir un objet comme attribut plutôt qu'hériter de sa classe) peut être préférable à l'héritage.

3. **Limiter la profondeur de la hiérarchie** : Une hiérarchie d'héritage trop profonde peut devenir difficile à comprendre et à maintenir.

4. **Documenter l'intention d'héritage** : Si une classe est conçue pour être étendue, documentez comment et pourquoi. Si une méthode est conçue pour être redéfinie, expliquez son contrat.

5. **Utiliser @Override** : Toujours utiliser l'annotation `@Override` lors de la redéfinition de méthodes pour éviter les erreurs.

6. **Respecter le principe de substitution de Liskov** : Une sous-classe doit pouvoir être utilisée partout où sa superclasse est attendue, sans altérer le comportement attendu du programme.

## Cas pratique complet

Voici un exemple complet qui illustre l'utilisation de l'héritage avec nos classes `Animal`, `Poisson` et `Oiseau` :

```java
public class Main {
    public static void main(String[] args) {
        // Création d'objets des sous-classes
        Poisson poisson1 = new Poisson("Poisson", "Rivière", false, "Carpe", 56, 7);
        Oiseau oiseau1 = new Oiseau("Oiseau", "Jungle", true, "Ara", 78, 4);

        // Affichage des informations
        System.out.println(poisson1.toString());
        System.out.println();
        System.out.println(oiseau1.toString());

        // Démonstration du polymorphisme
        Animal[] animaux = new Animal[2];
        animaux[0] = poisson1;
        animaux[1] = oiseau1;

        // Parcours du tableau et affichage des informations
        System.out.println("\nAffichage via polymorphisme :");
        for (Animal animal : animaux) {
            System.out.println(animal.toString());
            System.out.println("Habitat : " + animal.getHabitat());
            System.out.println();
        }

        // Utilisation des méthodes spécifiques aux sous-classes nécessite un casting
        if (animaux[0] instanceof Poisson) {
            Poisson p = (Poisson) animaux[0];
            System.out.println("Nom du poisson : " + p.getName());
        }
    }
}
```

Ce code illustre :
- La création d'objets des sous-classes `Poisson` et `Oiseau`
- L'affichage des informations via la méthode `toString()` redéfinie
- Le polymorphisme avec un tableau d'objets de type `Animal` contenant des instances de `Poisson` et `Oiseau`
- L'accès aux méthodes communes héritées via le type `Animal`
- L'accès aux méthodes spécifiques via un casting explicite

L'exécution de ce code produirait une sortie similaire à :

```
 Ordre: Poisson
 Habitat: Rivière
 Menacé: false
 Nom: Carpe
 Taille: 56 cm
 Poids: 7 kg

 Ordre: Oiseau
 Habitat: Jungle
 Menacé: true
 Name: Ara
 Taille: 78 cm
 Poids: 4 kg

Affichage via polymorphisme :
 Ordre: Poisson
 Habitat: Rivière
 Menacé: false
 Nom: Carpe
 Taille: 56 cm
 Poids: 7 kg
Habitat : Rivière

 Ordre: Oiseau
 Habitat: Jungle
 Menacé: true
 Name: Ara
 Taille: 78 cm
 Poids: 4 kg
Habitat : Jungle

Nom du poisson : Carpe
```

Cette sortie montre comment chaque objet, qu'il soit référencé par son type concret ou par le type de sa superclasse, conserve son comportement spécifique grâce au mécanisme de polymorphisme.
