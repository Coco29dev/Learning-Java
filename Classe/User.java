/*
 * Création d'une classe User avec :
 * Différents attributs 
 * Un constructeur 
 * Getter/Setter
 * Méthode
 */

public class User {

    // Initialisation des attributs de la classe User
    private String firstName;
    private String lastName;
    private int age;
    private boolean student;

    // Initialisation du constructeur de la classe User
    public User(final String firstName, final String lastName, final int age, final boolean student) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.student = student;
    }

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

    public boolean getStudent() {
        return this.student;
    }

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

    // Méthode toString pour retourner les informations d'un User
    public String toString() {
        return "Prénom: " + this.firstName + " Nom de famille: " + this.lastName + " Age: " + this.age + " Etudiant: "
                + this.student;
    }

    public static void main(String[] args) {

        User user1 = new User("Jean", "Doe", 14, true);

        System.out.println(user1.toString());

    }
}
