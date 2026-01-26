package game;

import java.util.ArrayList;
import java.util.Iterator;
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

    // 特定の sushi にダメージを与え、経験値を得る
    public int damagedAndGetXp(int sushiId, int power) {
        Sushi targetSushi = sushiList.get(sushiId);
        // ダメージを与える
        targetSushi.damaged(power);
        // 死亡していれば経験値を獲得し、 sushiList から除外する
        int xp = 0;
        if (targetSushi.isDead()) {
            xp += targetSushi.getXp();
            this.sushiList.remove(sushiId);
        }
        return xp;
    }

    // 全ての sushi に確率的にダメージを与え、経験値を得る
    public int damagedAllAndGetSumXp(int probability, int power) {

        int sumXp = 0;
        boolean isHit = false;

        // イテレータで走査する
        Iterator<Sushi> it = sushiList.iterator();
        while(it.hasNext()) {
            Sushi targetSushi = it.next();

            // 一定の確率でヒットする
            if (random.nextInt(100) < probability) {
                System.out.println(targetSushi.getName() + " にお茶がかかった！");
                targetSushi.damaged(power);
                // 死亡していたら、経験値獲得
                if (targetSushi.isDead()) {
                    sumXp += targetSushi.getXp();
                }
                isHit = true;
            }
        }
        //　ヒットしなければヒットなしのメッセージを表示する
        if (!isHit) {
            System.out.println("しかし、ヒットしなかった...");
        }

        return sumXp;
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
