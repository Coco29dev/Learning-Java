/*
 * Création d'une classe enfant Oiseau qui hérite de la classe Animal et implémente l'interface Volant
 * Différents attributs
 * Constructeur de la classe Oiseau et héritage des attributs de la classe Animal avec super()
 * Getter / Setter
 * Méthode toString avec l'héritage de la méthode toString de la classe Animal
 * Méthode de l'interface Volant
 */

public class Oiseau extends Animal implements Volant {

    // Attributs
    private String name;
    private int taille;
    private int poids;

    // Constructeur de la classe enfant avec héritage des attributs de la classe
    // parente
    public Oiseau(final String ordre, final String habitat, final boolean menacé, final String name, final int taille,
            final int poids) {
        super(ordre, habitat, menacé);
        this.name = name;
        this.taille = taille;
        this.poids = poids;

    }

    // Getter
    public String getName() {
        return this.name;
    }

    public int getTaille() {
        return this.taille;
    }

    public int getPoids() {
        return this.poids;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    // Méthode avec utilisation de l'héritage
    @Override
    public String toString() {
        return super.toString() +
                " Nom: " + this.name + "\n" +
                " Taille: " + this.taille + " cm\n" +
                " Poids: " + this.poids + " kg";
    }

    // Méthode avec utilisation de l'interface
    @Override
    public void voler() {
        System.out.println(this.name + " vole en battant des ailes\n");
    }

    @Override
    public void vitesseVol() {
        if (this.taille > 50) {
            System.out.println(this.name + " vole rapidement\n");
        } else {
            System.out.println(this.name + " vole lentement\n");
        }
    }

    @Override
    public void altitude() {
        if (this.poids > 4) {
            System.out.println(this.name + " vole à haute altitude\n");
        } else {
            System.out.println(this.name + " vole à basse altitude\n");
        }

    }
}