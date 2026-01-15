package game.character.sushi;

import game.character.player.Player;

public abstract class NigiriSushi extends Sushi {

    public NigiriSushi(String name, int maxHp, int power) {
        super(name, maxHp, power);
    }

    // 握り寿司の攻撃、slap は相手にダメージを与える
    public void slap(Player target) {
        System.out.println(this.name + " slapped!");
        target.damaged(this.power);
    }
}
