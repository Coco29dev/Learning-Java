public class Main {

    public static void main(String[] args) {

        Poisson poisson1 = new Poisson("Poisson", "Rivière", false, "Carpe", 56, 7);
        Oiseau oiseau1 = new Oiseau("Oiseau", "Jungle", true, "Ara", 78, 4);

        System.out.println(poisson1.toString());
        System.out.println();
        System.out.println(oiseau1.toString());

    }
}