package game;
import game.character.sushi.CucumberRoll;
import game.character.sushi.RolledSushi;
import game.character.sushi.Sushi;
import game.character.sushi.Tuna;

public class Main {
    public static void main(String[] args) {
        Sushi tuna = new Tuna(100, 10);
        tuna.greeting();

        RolledSushi cucumberRoll = new CucumberRoll(50, 50);
        cucumberRoll.roll();
    }
}
