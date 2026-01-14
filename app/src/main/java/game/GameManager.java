package game;

import java.util.ArrayList;
import java.util.List;

import game.character.player.Player;
import game.character.sushi.CucumberRoll;
import game.character.sushi.RolledSushi;
import game.character.sushi.Sushi;
import game.character.sushi.Tuna;

public class GameManager {
    
    public void gameStart() {
        Sushi tuna = new Tuna(100, 10);
        tuna.greeting();

        RolledSushi cucumberRoll = new CucumberRoll(50, 50);
        cucumberRoll.roll();

        List<Sushi> sushiList = new ArrayList<>();
        sushiList.add(tuna);
        sushiList.add(cucumberRoll);

        Player player = new Player("ムラサキ", 200, 50);
        player.greeting();
        player.knifeAttack(tuna);
        player.teaAttack(sushiList);
        player.nattoAttack(sushiList);
        player.healed(10);
    }
}
