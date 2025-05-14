/*
 * Création d'une classe enfant Poisson qui hérite de la classe Animal et implémente l'interface Nageur
 * Différents attributs
 * Constructeur de la classe poisson et héritage des attributs de la classe Animal avec super()
 * Getter / Setter
 * Méthode toString avec l'héritage de la méthode toString de la classe Animal
 * Méthode de l'interface Nageur
 */

public class Poisson extends Animal implements Nageur {

    // Attribut de la classe enfant
    private String name;
    private int taille;
    private int poids;

    // Constructeur de la classe enfant avec héritage des attributs de la classe
    // parente
    public Poisson(final String ordre, final String habitat, final boolean menacé, final String name, final int taille,
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

    // Méthode avec utilisation de l'héritage signalé par @Override
    @Override
    public String toString() {
        return super.toString() +
                " Nom: " + this.name + "\n" +
                " Taille: " + this.taille + " cm\n" +
                " Poids: " + this.poids + " kg";
    }

    // Méthode avec utilisation de l'interface
    @Override
    public void nager() {
        System.out.println(this.name + " nage avec ses nageoires\n");
    }

    @Override
    public void vitesseNage() {
        if (this.taille > 50) {
            System.out.println(this.name + " nage rapidement\n");
        } else {
            System.out.println(this.name + " nage lentement\n");
        }
    }

    @Override
    public void profondeurNage() {
        if (this.poids > 4) {
            System.out.println(this.name + " nage au fond\n");
        } else {
            System.out.println(this.name + " nage à la surface\n");
        }
    }
}
