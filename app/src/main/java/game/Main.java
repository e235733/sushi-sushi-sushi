package game;
import game.sushi.CucumberRoll;
import game.sushi.Tuna;

public class Main {
    public static void main(String[] args) {
        Tuna tuna = new Tuna("maguro", 100, 10);
        tuna.slap();

        CucumberRoll cucumberRoll = new CucumberRoll("kappa", 50, 50);
        cucumberRoll.roll();
    }
}
