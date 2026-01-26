package game.character.player;

import game.InputManager;
import game.SushiList;

public class KnifeAttack extends Attack {

    private InputManager inputManager;

    public KnifeAttack(int power, Player player, InputManager inputManager) {
        super(power, player);
        this.inputManager = inputManager;
    }
    
    /**
     * 攻撃対象を選んでダメージを与えることができる knifeAttack
     * 倒したら経験値を獲得する
     */
    public int attack(SushiList sushiList) {
        int gotXp = 0;
        // sushi が存在する場合のみ実行
        if (sushiList.getNumSushi() != 0) {
            // 入力を要求してターゲットを特定
            System.out.println("攻撃対象を選んでください");
            sushiList.showInfo();
            int numSushi = sushiList.getNumSushi();
            int targetId = inputManager.getNumericInput(numSushi);

            // ターゲットにダメージを与える
            System.out.println(this.player.getName() + " は " + sushiList.getName(targetId) + " をナイフで切りつけた！");
            gotXp += sushiList.damagedAndGetXp(targetId, this.power);
        }
        return gotXp;
    }
}
