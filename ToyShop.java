package ToyShop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Toy with id " + toyId + " not found!");
    }

    public Toy selectPrizeToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomNumber = new Random().nextDouble() * totalWeight;
        double currentWeight = 0;
        for (Toy toy : toys) {
            if(toy.getQuantity() != 0 ){
                currentWeight += toy.getWeight();
                if (currentWeight >= randomNumber) {
                    toy.reduceQuantity();
                    return toy;
                }
            }
        }

        return null;
    }

    public void savePrizeToyToFile(Toy toy, String file) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("Prize Toy: " + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}