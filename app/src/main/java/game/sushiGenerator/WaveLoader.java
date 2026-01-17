package game.sushiGenerator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.GameManager.SushiType;

public class WaveLoader {

    // 読み出すファイルの名前
    private static String filename = "waves.csv";
    // 読み出しツール
    private InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
    
    // 読み込んだ結果を返すメソッド
    public List<Map<SushiType, Integer>> load() {
        
        List<Map<SushiType, Integer>> waves = new ArrayList<>();

        // ファイルが存在しなかった場合
        if (is == null) {
            System.err.println("ファイルが見つかりません: " + filename);
            return waves;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String line;
            // 行がある限り読む
            while ((line = reader.readLine()) != null) {
                // "#" から始まるコメント行はスキップ
                if (line.startsWith("#")) {
                    continue;
                }
                // "," で分割する
                String[] parts = line.split(",");
                // データが 3つ存在しているかチェック
                if (parts.length != 3) {
                    System.err.println("データは waveId, sushiType, numSushi で構成されていなければなりません:" + line);
                    return waves;
                }

                try {
                    // 型付け
                    int waveId = Integer.parseInt(parts[0].trim());
                    String sushiName = parts[1].trim();
                    int count = Integer.parseInt(parts[2].trim());

                    // タイプを enum に変換
                    SushiType type = SushiType.valueOf(sushiName);

                    // 敵が発生しないウェーブは空の map で埋める
                    while (waves.size() <= waveId) {
                        waves.add(new HashMap<>());
                    }

                    // ウェーブを waves に追加
                    waves.get(waveId-1).put(type, count);

                } catch (IllegalArgumentException e) {
                    System.err.println("不正なデータ形式です: " + filename);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return waves;
    }
}
