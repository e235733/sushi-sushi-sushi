package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.character.player.Player;
import game.character.sushi.CucumberRoll;
import game.character.sushi.RolledSushi;
import game.character.sushi.Sushi;
import game.character.sushi.Tuna;

public class GameManager {

    private Player player;

    Scanner scanner = new Scanner(System.in);
    
    public void gameStart() {

        this.initialSet();
        // sushi の生成
        Sushi tuna = new Tuna(100, 10);
        RolledSushi cucumberRoll = new CucumberRoll(50, 50);
        // sushi list の作成
        List<Sushi> sushiList = new ArrayList<>();
        sushiList.add(tuna);
        sushiList.add(cucumberRoll);

        cucumberRoll.roll(this.player);

        this.player.knifeAttack(tuna);
        this.player.knifeAttack(tuna);
        
        this.player.teaAttack(sushiList);
        this.player.nattoAttack(sushiList);
        this.player.healed(10);
    }

    // ユーザが初期設定を行う
    private void initialSet() {
        System.out.print("Sushi Sushi Sushi !!\n" + "プレイヤー名を入力してください。\n" + " > ");
        // 名前の入力
        String playerName = scanner.nextLine();
        scanner.close();
        // プレイヤーの作成
        player = new Player(playerName, 100, 10);
    }
}
