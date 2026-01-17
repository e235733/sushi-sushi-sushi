package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.GameManager.SushiType;
import game.character.sushi.rolledSushi.CucumberRoll;
import game.character.sushi.Sushi;
import game.character.sushi.nigiriSushi.Tuna;

public class SushiGenerator {

    private int numWaves;
    private List<Map<SushiType, Integer>> waves = new ArrayList<>();

    public SushiGenerator() {
        // ウェーブ 0
        Map<SushiType, Integer> wave0 = new HashMap<>();
        wave0.put(SushiType.CUCUMBER_ROLL, 1);
        this.waves.add(wave0);
        // ウェーブ 1
        Map<SushiType, Integer> wave1 = new HashMap<>();
        wave1.put(SushiType.TUNA, 1);
        wave1.put(SushiType.CUCUMBER_ROLL, 3);
        this.waves.add(wave1);
        // ウェーブ 2 (空)
        Map<SushiType, Integer> wave2 = new HashMap<>();
        this.waves.add(wave2);
        // ウェーブ 3
        Map<SushiType, Integer> wave3 = new HashMap<>();
        wave3.put(SushiType.TUNA, 3);
        wave3.put(SushiType.CUCUMBER_ROLL, 2);
        this.waves.add(wave3);

        this.numWaves = waves.size();
    }

    // ウェーブで出現する寿司を作成するメソッド
    public List<Sushi> createWave(int turnId) {
        List<Sushi> sushiWave = new ArrayList<Sushi>();
        Map<SushiType, Integer> wave = this.waves.get(turnId);
        for (SushiType sushiType : wave.keySet()) {
            // 種類ごとの寿司の数だけ生成する
            for (int i=0; i<wave.get(sushiType); i++) {
                sushiWave.add(generate(sushiType));
            }
        }
        return sushiWave;
    }

    // 寿司を生成するメソッド
    private Sushi generate(SushiType sushiType) {
        switch (sushiType) {
            case TUNA:
                return new Tuna(100, 10, 50);
            case CUCUMBER_ROLL:
                return new CucumberRoll(50, 50, 30);
            default:
                throw new IllegalArgumentException("unknown sushi: " + sushiType);
        }
    }

    // ウェーブ数の getter
    public int getNumWaves() {
        return this.numWaves;
    }
}
