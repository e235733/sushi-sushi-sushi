package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import game.character.player.Player;
import game.character.sushi.Sushi;

public class GameManager {

    private Player player;
    private List<Sushi> sushiList = new ArrayList<Sushi>();
    private SushiGenerator sushiGenerator = new SushiGenerator();

    public enum SushiType{
        TUNA,
        CUCUMBER_ROLL
    }

    Scanner scanner = new Scanner(System.in);
    
    public void gameStart() {

        this.initialSet();

        this.generateSushi();

        // ターンをループさせる
        while (true) {
            this.playerTern();
            // 敵の死亡確認をし、死亡していたらリストから外す
            this.sushiList.removeIf(sushi -> sushi.isDead());
            // プレイヤーの攻撃後に敵が全滅していれば勝利
            if (this.sushiList.size() == 0) {
                System.out.println("You Win!");
                break;
            }
            this.sushiTern();
            // 寿司の攻撃後にプレイヤーが死亡していれば敗北
            if (this.player.isDead()) {
                System.out.println("You Lose...");
                break;
            }
            // 巻き寿司は自滅するのでもう一度死亡確認、全滅していれば勝利
            this.sushiList.removeIf(sushi -> sushi.isDead());
            if (this.sushiList.size() == 0) {
                System.out.println("You Win!");
                break;
            }
        }

        this.scanner.close();
    }

    // ユーザが初期設定を行う
    private void initialSet() {
        System.out.print("Sushi Sushi Sushi !!\n" + "プレイヤー名を入力してください。\n" + " > ");
        // 名前の入力
        String playerName = this.scanner.nextLine();
        // プレイヤーの作成
        player = new Player(playerName, 200, 60);

        System.out.println("名前 : " + player.getName() + " , HP : " + player.getHp() + " , 攻撃力 : " + player.getPower());
        
    }

    // 敵を生成する
    private void generateSushi() {
        // sushi の生成
        for (int i=0; i<3; i++) {
            Sushi tuna = sushiGenerator.generate(SushiType.TUNA);
            this.sushiList.add(tuna);
        }
        for (int i=0; i<2; i++) {
            Sushi cucumberRoll = sushiGenerator.generate(SushiType.CUCUMBER_ROLL);
            this.sushiList.add(cucumberRoll);
        }
    }

    // シンプルに、プレイヤーとマグロで戦わせる
    private void playerTern() {
        int targetId;
        // プレイヤーに攻撃対象を選択させる
        System.out.println("攻撃対象を選んでください");
        int numSushi = this.sushiList.size();
        for (int i=0; i<numSushi; i++) {
            System.out.println(i + ". " + this.sushiList.get(i).getName() + " , HP : " + this.sushiList.get(i).getHp());
        }
        // 入力処理
        while (true) {
            System.out.print(" > ");
            try {
                int inputNumber = this.scanner.nextInt();
                // 範囲外ならもう一度
                if (inputNumber < 0 || inputNumber >= numSushi) {
                    System.out.println("エラー : 範囲内の値を入力してください");
                    continue;
                }
                targetId = inputNumber;
                break;
            } catch (InputMismatchException e) {
                // int 以外が入力された際の処理
                System.out.println("エラー : 整数を入力してください");
                scanner.next();
            }
        }

        this.player.knifeAttack(this.sushiList.get(targetId));
    }

    private void sushiTern() {
        for (Sushi sushi : sushiList) {
            sushi.act(this.player);
        }
    }
}
