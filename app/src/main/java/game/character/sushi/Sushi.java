package game.character.sushi;

import java.util.Random;

import game.character.Character;
import game.character.player.Player;

public abstract class Sushi extends Character{

    private Random random = new Random();

    // 攻撃を発動する確率(%)
    private int probability;
    protected int power;

    // intercept, slope は 一次関数の切片と傾き
    public Sushi(String name, int probability, int maxHpIntercept, int maxHpSlope, int powerIntercept, int powerSlope, int level) {

        // 最大 HP と攻撃力を計算して代入
        super(name, calculateMaxHp(level, maxHpIntercept, maxHpSlope));

        this.probability = probability;
        this.power = calculatePower(level, powerIntercept, powerSlope);
    }

    // 寿司の毎ターンの行動を定める
    public void act(Player target) {
        // 設定した確率で攻撃する
        if (this.random.nextInt(100) < probability) {
            this.attack(target);
        }
    };

    // レベルによる HP と攻撃力の設定メソッド
    private static int calculateMaxHp(int level, int maxHpIntercept, int maxHpSlope) {
        int maxHp = maxHpIntercept + maxHpSlope * level;
        return maxHp;
    }
    private static int calculatePower(int level, int powerIntercept, int powerSlope) {
        int power = powerIntercept + powerSlope * level;
        return power;
    }

    // 攻撃メソッド
    protected abstract void attack(Player target);
}
