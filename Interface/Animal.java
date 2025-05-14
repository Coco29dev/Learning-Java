/*
 * Création d'une classe parente Animal avec :
 * Différents attributs
 * Constructeur
 * Getter / Setter
 * Méthode
 */

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

    // Getter des attributs de la classe animal
    public String getOrdre() {
        return this.ordre;
    }

    public String getHabitat() {
        return this.habitat;
    }

    public boolean isMenacé() {
        return this.menacé;
    }

    // Setter des attributs de la classe animal
    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setMenacé(boolean menacé) {
        this.menacé = menacé;
    }

    // Méthode avec utilisation de l'héritage signalé par @Override
    @Override
    public String toString() {
        return " Ordre: " + this.ordre + "\n" +
                " Habitat: " + this.habitat + "\n" +
                " Menacé: " + this.menacé + "\n";
    }
}