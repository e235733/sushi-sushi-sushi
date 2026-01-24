package game.character.player;

import java.util.List;

import game.InputManager;
import game.character.sushi.Sushi;

public class KnifeAttack extends Attack {

    private InputManager inputManager;

    public KnifeAttack(int power, Player player, InputManager inputManager) {
        super(power, player);
        this.inputManager = inputManager;
    }
    
    // 攻撃対象を選んでダメージを与えることができる knifeAttack
    public void attack(List<Sushi> sushiList) {
        // 入力を要求してターゲットを特定
        System.out.println("攻撃対象を選んでください");

        int numSushi = sushiList.size();
        for (int i=0; i<numSushi; i++) {
            Sushi sushi = sushiList.get(i);
            System.out.println(i + ". " + sushi.getName() + ", HP: " + sushi.getHp());
        }
        int targetId = inputManager.getNumericInput(numSushi);
        Sushi target = sushiList.get(targetId);

        // ターゲットにダメージを与える
        System.out.println(this.player.getName() + " は " + target.getName() + " をナイフで切りつけた！");
        target.damaged(this.power);
    }
}
