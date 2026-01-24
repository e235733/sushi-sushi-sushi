package game.character.player;

import game.SushiList;

public abstract class Attack {

    protected Player player;
    protected int power;

    public Attack(int power, Player player) {
        this.player = player;
        this.power = power;
    }

    // 攻撃メソッド
    public abstract void attack(SushiList sushiList);
}
