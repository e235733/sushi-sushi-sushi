package game.character.player;

import java.util.List;

import game.InputManager;
import game.character.Character;
import game.character.sushi.Sushi;

public class Player extends Character {

    private Attack knifeAttack, teaAttack;
    
    public Player(String name, int maxHp, InputManager inputManager) {
        super(name, maxHp);
        this.knifeAttack = new KnifeAttack(60, this, inputManager);
        this.teaAttack = new TeaAttack(10, this, 40);
    }

    public void attack(List<Sushi> sushiList) {
        this.knifeAttack.attack(sushiList);
        this.teaAttack.attack(sushiList);
    }

    // 回復するメソッド
    public void healed(int healAmount) {
        System.out.println(this.name + " は HP が " + healAmount + " 回復した！");
        // 最大 HP は超えないようにする
        this.hp = Math.min(this.hp + healAmount, maxHp);
        System.out.println(this.name + " の HP は " + this.hp + " になった！");
    }

}
