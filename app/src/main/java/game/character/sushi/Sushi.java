package game.character.sushi;

import java.util.Random;

import game.character.Character;
import game.character.player.Player;

public abstract class Sushi extends Character{

    Random random = new Random();

    // 攻撃を発動する確率(%)
    private int probability;

    public Sushi(String name, int maxHp, int power, int probability) {
        super(name, maxHp, power);
        this.probability = probability;
    }

    // 寿司の毎ターンの行動を定める
    public void act(Player target) {
        // 設定した確率で攻撃する
        if (random.nextInt(100) < probability) {
            this.attack(target);
        }
    };

    protected abstract void attack(Player target);
}
