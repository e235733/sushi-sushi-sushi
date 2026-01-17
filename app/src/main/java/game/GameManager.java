package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import game.character.player.Player;
import game.character.sushi.Sushi;
import game.sushiGenerator.SushiGenerator;

public class GameManager {

    private int turnId = 0;
    // プレイヤーが敵の不在を認識しているか
    private boolean isRecognizedSushiAbsence = false;
    private boolean isPlayerWinning = false;

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

        // ターンをループさせる
        while (true) {
            // 寿司の生成
            this.generateSushi();
            // プレイヤーのターン
            this.playerTern();
            // 勝利判定
            this.checkPlayerWinning();
            if (this.isPlayerWinning) {
                break;
            }
            // 寿司のターン
            this.sushiTern();
            // 寿司の攻撃後にプレイヤーが死亡していれば敗北
            if (this.player.isDead()) {
                System.out.println("You Lose...");
                break;
            }
            // 巻き寿司は自滅するのでもう一度勝利判定
            this.checkPlayerWinning();
            if (this.isPlayerWinning) {
                break;
            }
            // ターンをインクリメント
            this.turnId++;
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
        // 敵の発生ウェーブが残っているときのみ実行
        if (this.turnId < sushiGenerator.getNumWaves()) {
            // sushi の生成
            List<Sushi> generatedSushiList = this.sushiGenerator.createWave(this.turnId);
            int numGeneratedSushi = generatedSushiList.size();

            for (int i=0; i<numGeneratedSushi; i++) {
                Sushi generatedSushi = generatedSushiList.get(i);
                // 出現メッセージ
                System.out.println(generatedSushi.getName() + " が現れた！");
                // ゲームの sushiList に追加
                this.sushiList.add(generatedSushi);
            }
        }
    }

    // プレイヤーのターン
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

    // 寿司のターン
    private void sushiTern() {
        for (Sushi sushi : sushiList) {
            sushi.act(this.player);
        }
    }

    // 勝利判定
    private void checkPlayerWinning() {
        // 敵の死亡確認をし、死亡していたらリストから外す
        this.sushiList.removeIf(sushi -> sushi.isDead());
        // 敵の全滅確認
        if (this.sushiList.size() == 0) {
            // これ以上のウェーブが存在しない場合、勝利
            if (this.turnId + 1 >= this.sushiGenerator.getNumWaves()) {
                System.out.println("全ての寿司を倒した。" + this.player.getName() + "の勝利である！");
                this.isPlayerWinning = true;
            }
            // 継続の場合もある
            // そのターンに敵が存在しないことがわかっているときは出力しない
            else if (!this.isRecognizedSushiAbsence){
                System.out.println("寿司を一掃したが、まだ終わりではないようだ。");
                this.isRecognizedSushiAbsence = true;
            }
        }
        else {
            this.isRecognizedSushiAbsence = false;
        }
    }
}
