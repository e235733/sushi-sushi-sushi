package game.character.player;

import java.util.Random;

import game.SushiList;

public class NattoAttack extends Attack {
    
    private int probability;
    private Random random = new Random();

    public NattoAttack(int power, Player player, int probability) {
        super(power, player);
        this.probability = probability;
    }

    // 複数の敵を鈍化させるメソッド nattoAttack
    public int attack(SushiList sushiList) {

        System.out.println(this.player.getName() + " は納豆を仕掛けた!");

        for (int targetId=0; targetId<sushiList.getNumSushi(); targetId++) {
            // 乱数を生成し、ヒットを確率的にする
            if (random.nextInt(100) < probability) {
                System.out.println(sushiList.getName(targetId) + " がネバネバにかかった！");
                // ここに鈍化させるメソッドを書く
            }
        }

        return 0;
    }
}
