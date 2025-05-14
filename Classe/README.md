# Documentation Java : Les Fondamentaux des Classes

## Introduction aux classes

En Java, une classe est un modèle (blueprint) qui définit la structure et le comportement d'un type d'objet. Les classes sont le fondement de la programmation orientée objet (POO) en Java.

Une classe encapsule :
- Des données (attributs/variables d'instance)
- Des comportements (méthodes)
- Des constructeurs pour initialiser les objets

Dans notre exemple, la classe `User` représente un utilisateur avec des caractéristiques comme son prénom, son nom, son âge, et son statut d'étudiant. Elle fournit également des méthodes pour accéder et modifier ces informations.

```java
public class User {
    // Contenu de la classe...
}
```

Lorsque nous créons une classe, nous créons essentiellement un nouveau type de données. Nous pouvons ensuite créer des instances (objets) de cette classe, chacune avec ses propres valeurs pour les attributs définis dans la classe.

```java
// Création d'un objet de type User
User user1 = new User("Jean", "Dupont", 25, false);
```

## Déclaration d'une classe

La syntaxe de base pour déclarer une classe en Java est la suivante :

```java
[modificateurs] class NomDeLaClasse [extends ClasseParent] [implements Interface1, Interface2, ...] {
    // Corps de la classe
}
```

Dans notre exemple, la classe `User` est déclarée comme suit :

```java
/*
 * Création d'une classe User avec :
 * Différents attributs 
 * Un constructeur 
 * Getter/Setter
 * Méthode
 */
public class User {
    // Corps de la classe...
}
```

Éléments à noter :
- Le modificateur `public` indique que la classe est accessible depuis n'importe où dans le programme.
- Le nom de la classe (`User`) suit la convention Java : il commence par une majuscule et utilise le style PascalCase.
- Les commentaires au-dessus de la déclaration documentent le but et la structure de la classe.

D'autres modificateurs possibles pour les classes incluent :
- `abstract` : La classe ne peut pas être instanciée directement.
- `final` : La classe ne peut pas être étendue (héritée).
- `static` : Uniquement pour les classes internes.

## Attributs (variables d'instance)

Les attributs sont des variables qui appartiennent à la classe et représentent l'état des objets créés à partir de cette classe. Dans notre classe `User`, nous avons quatre attributs :

```java
// Initialisation des attributs de la classe User
private String firstName;
private String lastName;
private int age;
private boolean student;
```

Analyse de ces attributs :
- Tous les attributs sont déclarés avec le modificateur `private`, ce qui signifie qu'ils ne sont accessibles que depuis l'intérieur de la classe `User`. C'est un principe fondamental de l'encapsulation.
- Les types de données utilisés sont variés : `String` pour les chaînes de caractères, `int` pour un nombre entier, et `boolean` pour une valeur vrai/faux.
- La convention de nommage utilisée est le camelCase (première lettre en minuscule, puis majuscule pour chaque nouveau mot).

Autres points importants concernant les attributs :
- Les attributs peuvent avoir des modificateurs supplémentaires comme `final` (valeur non modifiable après initialisation), `static` (appartient à la classe plutôt qu'aux instances), ou `transient` (exclu de la sérialisation).
- Les attributs peuvent être initialisés lors de leur déclaration ou dans un constructeur.
- Par défaut, les attributs primitifs sont initialisés à leurs valeurs par défaut (0 pour `int`, `false` pour `boolean`, etc.) et les objets à `null`.

## Méthodes

Les méthodes définissent le comportement des objets d'une classe. Notre classe `User` comporte plusieurs types de méthodes :

### Getters (Accesseurs)

Les getters permettent d'accéder aux valeurs des attributs privés :

```java
// Getter attributs de la classe User
public String getFirstName() {
    return this.firstName;
}

public String getLastName() {
    return this.lastName;
}

public int getAge() {
    return this.age;
}

public boolean isStudent() {
    return this.student;
}
```

Notez que pour les attributs booléens, la convention est d'utiliser `is` plutôt que `get` comme préfixe.

### Setters (Mutateurs)

Les setters permettent de modifier les valeurs des attributs privés :

```java
// Setter attributs de la classe User
public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public void setAge(int age) {
    this.age = age;
}

public void setStudent(boolean student) {
    this.student = student;
}
```

Chaque setter :
- A un type de retour `void` (ne retourne rien)
- Prend un paramètre du même type que l'attribut correspondant
- Utilise `this` pour distinguer l'attribut de la classe du paramètre de la méthode

### Méthode toString()

La méthode `toString()` est une méthode spéciale qui retourne une représentation sous forme de chaîne de caractères de l'objet :

```java
// Méthode toString pour retourner les informations d'un User
public String toString() {
    return "Prénom: " + this.firstName + "\n" +
            " Nom de famille: " + this.lastName + "\n" +
            " Age: " + this.age + "\n" +
            " Etudiant: " + (this.student ? "Oui" : "Non");
}
```

Cette méthode :
- Redéfinit la méthode `toString()` héritée de la classe `Object`
- Retourne une chaîne formatée contenant les valeurs des attributs
- Utilise une expression ternaire (`condition ? valeurSiVrai : valeurSiFaux`) pour convertir la valeur booléenne en texte

Les méthodes peuvent également :
- Être `static` (appartenant à la classe plutôt qu'aux instances)
- Être `final` (ne peuvent pas être redéfinies dans les sous-classes)
- Être `abstract` (déclaration sans implémentation, à définir dans les sous-classes)
- Lever des exceptions avec `throws`
- Être surchargées (plusieurs méthodes avec le même nom mais des paramètres différents)

## Constructeurs

Les constructeurs sont des méthodes spéciales utilisées pour initialiser les objets lors de leur création. Notre classe `User` possède un constructeur qui initialise tous les attributs :

```java
// Initialisation du constructeur de la classe User
public User(final String firstName, final String lastName, final int age, final boolean student) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.student = student;
}
```

Caractéristiques de ce constructeur :
- Il porte le même nom que la classe (`User`)
- Il n'a pas de type de retour (pas même `void`)
- Il utilise le modificateur `public` pour être accessible depuis d'autres classes
- Il prend quatre paramètres correspondant aux quatre attributs
- Le mot-clé `final` sur les paramètres indique qu'ils ne peuvent pas être modifiés à l'intérieur du constructeur
- Il utilise `this` pour faire référence aux attributs de l'instance

Utilisation du constructeur pour créer un objet :

```java
User user = new User("Marie", "Durand", 30, true);
```

Si aucun constructeur n'est défini, Java fournit un constructeur par défaut sans paramètres. Cependant, dès qu'un constructeur avec paramètres est défini, le constructeur par défaut n'est plus fourni automatiquement. Si vous voulez toujours pouvoir créer des objets sans paramètres, vous devez définir explicitement un constructeur sans paramètres.

Une classe peut avoir plusieurs constructeurs (surcharge de constructeurs) pour offrir différentes façons d'initialiser les objets :

```java
// Exemple de constructeurs supplémentaires que nous pourrions ajouter
public User() {
    this("", "", 0, false);
}

public User(String firstName, String lastName) {
    this(firstName, lastName, 0, false);
}
```

## L'objet `this`

Le mot-clé `this` fait référence à l'instance courante de la classe. Dans notre classe `User`, `this` est utilisé à plusieurs endroits :

### Dans le constructeur

```java
public User(final String firstName, final String lastName, final int age, final boolean student) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.student = student;
}
```

Ici, `this.firstName` fait référence à l'attribut `firstName` de l'instance, tandis que `firstName` (sans `this`) fait référence au paramètre du constructeur. Cette distinction est nécessaire car les noms des paramètres sont identiques aux noms des attributs.

### Dans les getters

```java
public String getFirstName() {
    return this.firstName;
}
```

Dans ce cas, l'utilisation de `this` est facultative car il n'y a pas d'ambiguïté avec un paramètre local. La méthode aurait pu être écrite comme suit :

```java
public String getFirstName() {
    return firstName;
}
```

### Dans les setters

```java
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
```

Ici, `this` est nécessaire pour distinguer l'attribut `firstName` du paramètre `firstName`. Sans `this`, le paramètre serait simplement assigné à lui-même, ce qui n'aurait aucun effet sur l'attribut de la classe.

### Dans la méthode toString()

```java
public String toString() {
    return "Prénom: " + this.firstName + "\n" +
            " Nom de famille: " + this.lastName + "\n" +
            " Age: " + this.age + "\n" +
            " Etudiant: " + (this.student ? "Oui" : "Non");
}
```

Comme dans les getters, l'utilisation de `this` est facultative ici.

Autres utilisations de `this` (non présentes dans l'exemple) :
- Pour appeler un autre constructeur : `this(param1, param2);`
- Pour passer l'instance courante comme argument à une méthode : `autreObjet.methode(this);`
- Pour retourner l'instance courante (utile pour les méthodes chaînées) : `return this;`

## Encapsulation

L'encapsulation est l'un des principes fondamentaux de la programmation orientée objet. Elle consiste à masquer l'état interne d'un objet et à n'autoriser l'accès que via des méthodes publiques contrôlées.

Notre classe `User` illustre parfaitement ce principe :

1. **Données privées** : Tous les attributs sont déclarés comme `private`, ce qui signifie qu'ils ne sont pas directement accessibles depuis l'extérieur de la classe.

```java
private String firstName;
private String lastName;
private int age;
private boolean student;
```

2. **Interface publique** : Des méthodes publiques (getters et setters) sont fournies pour accéder et modifier ces attributs de manière contrôlée.

```java
// Getter
public String getFirstName() {
    return this.firstName;
}

// Setter
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
```

Avantages de l'encapsulation démontrés par notre classe `User` :

### Protection des données

Les attributs étant privés, ils ne peuvent pas être modifiés directement par d'autres classes. Toute modification doit passer par les setters, ce qui permet de contrôler comment les modifications sont effectuées.

### Validation des données

Bien que notre exemple n'implémente pas de validation, les setters pourraient être étendus pour valider les données avant de les assigner aux attributs :

```java
public void setAge(int age) {
    if (age >= 0) {
        this.age = age;
    } else {
        throw new IllegalArgumentException("L'âge ne peut pas être négatif");
    }
}
```

### Flexibilité d'implémentation

L'implémentation interne peut être modifiée sans affecter le code qui utilise la classe, tant que l'interface publique reste la même.

Par exemple, si nous décidions de stocker l'âge sous forme de date de naissance plutôt que de nombre d'années, nous pourrions modifier l'attribut en interne tout en conservant la même interface pour les utilisateurs de la classe :

```java
// Modification interne
private LocalDate dateOfBirth; // au lieu de int age

// L'interface publique reste la même
public int getAge() {
    return Period.between(dateOfBirth, LocalDate.now()).getYears();
}

public void setAge(int age) {
    this.dateOfBirth = LocalDate.now().minusYears(age);
}
```

### Exemple d'utilisation de la classe User

```java
public class Main {
    public static void main(String[] args) {
        // Création d'un utilisateur
        User user = new User("Jean", "Dupont", 25, false);
        
        // Affichage des informations
        System.out.println(user.toString());
        
        // Modification via les setters
        user.setAge(26);
        user.setStudent(true);
        
        // Accès via les getters
        System.out.println("Nouvel âge : " + user.getAge());
        System.out.println("Étudiant : " + (user.isStudent() ? "Oui" : "Non"));
    }
}
```

En résumé, la classe `User` illustre parfaitement les concepts fondamentaux des classes Java : déclaration de classe, attributs privés, méthodes publiques incluant getters et setters, constructeur avec paramètres, utilisation de `this`, et encapsulation. Ces principes forment la base de la programmation orientée objet en Java et permettent de créer des applications robustes et maintenables.
