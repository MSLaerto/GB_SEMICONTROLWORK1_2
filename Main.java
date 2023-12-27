package ToyShop;
public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        Toy toy1 = new Toy(1, "Barbie", 10, 20);
        Toy toy2 = new Toy(2, "Lego", 15, 30);
        Toy toy3 = new Toy(3, "Teddy Bear", 5, 50);

        toyShop.addToy(toy1);
        toyShop.addToy(toy2);
        toyShop.addToy(toy3);

        toyShop.updateWeight(1, 40);

        Toy prizeToy = toyShop.selectPrizeToy();

        if (prizeToy != null) {
            toyShop.savePrizeToyToFile(prizeToy, "prizes.txt");
            System.out.println("Prize Toy saved to file");
        } else {
            System.out.println("No toys available for selection");
        }
    }
}