package game.character.player;

import game.InputManager;
import game.SushiList;
import game.character.Character;

public class Player extends Character {

    private Attack knifeAttack, teaAttack, nattoAttack = null;
    private int numKnife = 1;
    
    public Player(String name, int maxHp, InputManager inputManager) {
        super(name, maxHp);
        // 最初は knifeAttack 1回のみ
        this.knifeAttack = new KnifeAttack(60, this, inputManager);
    }

    // 攻撃を全て実行するメソッド
    public void attack(SushiList sushiList) {
        // 設定回数分 knifeAttack
        for (int i=0; i<this.numKnife; i++) {
            this.knifeAttack.attack(sushiList);
        }
        // 存在すれば teaAttack, nattoAttack
        if (teaAttack != null) {
            this.teaAttack.attack(sushiList);
        }
        if (nattoAttack != null) {
            this.nattoAttack.attack(sushiList);
        }
    }

    // knifeAttack の実行回数を増やす
    public void incrementNumKnife() {
        this.numKnife++;
    }
    // teaAttack を有効にする
    public void enableTeaAttack() {
        this.teaAttack = new TeaAttack(10, this, 40);
    }
    // nattoAttack を有効にするxc
    public void enableNattoAttack() {
        this.nattoAttack = new NattoAttack(10, this, 30);
    }

    // knifeAttack の実行回数を調べる
    public int getNumKnife() {
        return this.numKnife;
    }
    // teaAttack が有効か調べる
    public boolean hasTeaAttack() {
        return teaAttack != null;
    }
    // nattoAttack が有効か調べる
    public boolean hasNattoAttack() {
        return nattoAttack != null;
    }

    // 回復するメソッド
    public void healed(int healAmount) {
        System.out.println(this.name + " は HP が " + healAmount + " 回復した！");
        // 最大 HP は超えないようにする
        this.hp = Math.min(this.hp + healAmount, maxHp);
        System.out.println(this.name + " の HP は " + this.hp + " になった！");
    }

}
