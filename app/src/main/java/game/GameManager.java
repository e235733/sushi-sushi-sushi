package game;

import java.util.List;

import game.character.player.Player;
import game.character.sushi.Sushi;
import game.sushiGenerator.SushiGenerator;

public class GameManager {

    private int turnId = 0;
    // プレイヤーが敵の不在を認識しているか
    private boolean isRecognizedSushiAbsence = false;
    private boolean isPlayerWinning = false;

    private Player player;
    private SushiList sushiList = new SushiList();
    private SushiGenerator sushiGenerator = new SushiGenerator();
    private InputManager inputManager = new InputManager();

    public enum SushiType{
        TUNA,
        CUCUMBER_ROLL
    }
    
    public void gameStart() {

        this.initialSet();

        // ターンをループさせる
        while (true) {
            // sushi の生成
            this.generateSushi();
            // プレイヤーのターン
            this.player.attack(this.sushiList);
            // 勝利判定
            this.checkPlayerWinning();
            if (this.isPlayerWinning) {
                break;
            }
            // sushi のターン
            this.sushiList.attack(this.player);
            // sushi の攻撃後にプレイヤーが死亡していれば敗北
            if (this.player.isDead()) {
                System.out.println("You Lose...");
                break;
            }
            // rolledSushi は自滅するのでもう一度勝利判定
            this.checkPlayerWinning();
            if (this.isPlayerWinning) {
                break;
            }
            // player にナイフを与える
            player.incrementNumKnife();
            // ターンをインクリメント
            this.turnId++;
        }
    }

    // ユーザが初期設定を行う
    private void initialSet() {
        System.out.print("Sushi Sushi Sushi !!\n" + "プレイヤー名を入力してください。\n" + " > ");
        // 名前の入力
        String playerName = inputManager.getStringInput();
        // プレイヤーの作成
        player = new Player(playerName, 200, this.inputManager);

        System.out.println("名前 : " + player.getName() + " , HP : " + player.getHp());
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

    // 勝利判定
    private void checkPlayerWinning() {
        // 敵の全滅確認
        if (this.sushiList.getNumSushi() == 0) {
            // これ以上のウェーブが存在しない場合、勝利
            if (this.turnId + 1 >= this.sushiGenerator.getNumWaves()) {
                System.out.println("全てのsushi を倒した。" + this.player.getName() + "の勝利である！");
                this.isPlayerWinning = true;
            }
            // 継続の場合もある
            // そのターンに敵が存在しないことがわかっているときは出力しない
            else if (!this.isRecognizedSushiAbsence){
                System.out.println("sushi を一掃したが、まだ終わりではないようだ。");
                this.isRecognizedSushiAbsence = true;
            }
        }
        else {
            this.isRecognizedSushiAbsence = false;
        }
    }
}
