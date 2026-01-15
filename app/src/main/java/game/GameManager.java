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
    
        // player の生成
        Player player = new Player("ムラサキ", 200, 50);
        // sushi の生成
        Sushi tuna = new Tuna(100, 10);
        RolledSushi cucumberRoll = new CucumberRoll(50, 50);
        // sushi list の作成
        List<Sushi> sushiList = new ArrayList<>();
        sushiList.add(tuna);
        sushiList.add(cucumberRoll);

        tuna.greeting();
        cucumberRoll.roll(player);

        player.greeting();
        player.knifeAttack(tuna);
        player.teaAttack(sushiList);
        player.nattoAttack(sushiList);
        player.healed(10);
    }
}
