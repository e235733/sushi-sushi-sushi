package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.character.player.Player;
import game.character.sushi.Sushi;

public class SushiList {
    
    private List<Sushi> sushiList = new ArrayList<Sushi>();
    private Random random = new Random();

    // sushi の追加
    public void add(Sushi sushi) {
        this.sushiList.add(sushi);
    }

    // 全ての sushi の id, 名前, HP を出力
    public void showInfo() {
        for (int i=0; i<sushiList.size(); i++) {
            Sushi sushi = sushiList.get(i);
            System.out.println(i + ". " + sushi.getName() + ", HP: " + sushi.getHp());
        }
    }

    // sushi の数を取得
    public int getNumSushi() {
        return this.sushiList.size();
    }

    // 全ての sushi による行動
    public void attack(Player player) {
        for (Sushi sushi : sushiList) {
            sushi.act(player);
        }
        // rolledSushi は自滅するので死亡確認
        removeDead();
    }

    // 特定の sushi にダメージを与える
    public void damaged(int sushiId, int power) {
        Sushi targetSushi = sushiList.get(sushiId);
        targetSushi.damaged(power);
        // 死亡していれば sushiList から除外する
        if (targetSushi.isDead()) {
            sushiList.remove(sushiId);
        }
    }

    // 全ての sushi に確率的にダメージを与える
    public void damagedAll(int probability, int power) {
        // ヒットしたか
        boolean isHit = false;
        for (int sushiId=0; sushiId<this.sushiList.size(); sushiId++) {
            Sushi targetSushi = this.sushiList.get(sushiId);
            // 一定の確率でヒットする
            if (random.nextInt(100) < probability) {
                System.out.println(targetSushi.getName() + " にお茶がかかった！");
                targetSushi.damaged(power);
                isHit = true;
            }
        }
        // ヒットしたら死亡確認をして sushiList　から除去する
        if (isHit) {
            this.removeDead();
        }
        //　しなければヒットなしのメッセージを表示する
        else {
            System.out.println("しかし、ヒットしなかった...");
        }
    } 

    // 特定の sushi の名前を取得
    public String getName(int sushiId) {
        return sushiList.get(sushiId).getName();
    }

    // 死亡した sushi の除外
    private void removeDead() {
        this.sushiList.removeIf(sushi -> sushi.isDead());
    }
}
