package game.character.player;

import java.util.List;

import game.character.sushi.Sushi;

public abstract class Attack {

    protected Player player;
    protected int power;

    public Attack(int power, Player player) {
        this.player = player;
        this.power = power;
    }

    // 攻撃メソッド
    public abstract void attack(List<Sushi> sushiList);
}
