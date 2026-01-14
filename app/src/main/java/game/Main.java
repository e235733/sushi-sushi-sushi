package game;
import game.sushi.CucumberRoll;
import game.sushi.RolledSushi;
import game.sushi.Sushi;
import game.sushi.Tuna;

public class Main {
    public static void main(String[] args) {
        Sushi tuna = new Tuna("Maguro", 100, 10);
        tuna.greeting();

        RolledSushi cucumberRoll = new CucumberRoll("Kappa", 50, 50);
        cucumberRoll.roll();
    }
}
