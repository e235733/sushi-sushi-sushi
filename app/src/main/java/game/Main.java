package game;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        // ./gradlew -q run --console=plain でプレイ
        gameManager.gameStart();
    }
}
