package game;

import java.util.ArrayList;
import java.util.List;

import game.character.player.Player;
import game.character.sushi.Sushi;

public class SushiList {
    
    private List<Sushi> sushiList = new ArrayList<Sushi>();

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
        sushiList.get(sushiId).damaged(power);
        removeDead();
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
