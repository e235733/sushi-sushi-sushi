package game.sushiGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import game.GameManager.SushiType;
import game.character.sushi.rolledSushi.CucumberRoll;
import game.character.sushi.Sushi;
import game.character.sushi.nigiriSushi.Tuna;

public class SushiGenerator {

    private int numWaves;
    private List<Map<SushiType, Integer>> waves;

    WaveLoader waveLoader = new WaveLoader();

    public SushiGenerator() {

        this.waves = waveLoader.load();
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
                return new Tuna(0);
            case CUCUMBER_ROLL:
                return new CucumberRoll(0);
            default:
                throw new IllegalArgumentException("unknown sushi: " + sushiType);
        }
    }

    // ウェーブ数の getter
    public int getNumWaves() {
        return this.numWaves;
    }
}
