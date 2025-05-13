public class Poisson extends Animal {

    // Attribut
    private String name;
    private int taille;
    private int poids;

    // Constructeur
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

    // Méthode avec utilisation de l'héritage
    @Override
    public String toString() {
        return super.toString() +
                " Nom: " + this.name + "\n" +
                " Taille: " + this.taille + " cm\n" +
                " Poids: " + this.poids + " kg";
    }

}
