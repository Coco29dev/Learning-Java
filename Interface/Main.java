public class Main {

    public static void main(String[] args) {

        Poisson poisson1 = new Poisson("Poisson", "Rivière", false, "Carpe", 45, 3);
        Oiseau oiseau1 = new Oiseau("Oiseau", "Jungle", true, "Ara", 34, 3);

        System.out.println(poisson1.toString());
        System.out.println();
        System.out.println(oiseau1.toString());
        System.out.println();
        oiseau1.voler();
        poisson1.nager();
        oiseau1.vitesseVol();
        poisson1.vitesseNage();
        oiseau1.altitude();
        poisson1.profondeurNage();

    }
}