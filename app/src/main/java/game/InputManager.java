package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    
    Scanner scanner = new Scanner(System.in);

    // プレイヤーからの数値入力を受け取る。引数で上限を指定
    public int getNumericInput(int range) {
        int inputNumber;
        // 入力処理
        while (true) {
            System.out.print(" > ");
            try {
                int playerInput = this.scanner.nextInt();
                // 範囲外ならもう一度
                if (playerInput < 0 || playerInput >= range) {
                    System.out.println("エラー : 範囲内の値を入力してください");
                    continue;
                }
                inputNumber = playerInput;
                break;
            } catch (InputMismatchException e) {
                // int 以外が入力された際の処理
                System.out.println("エラー : 整数を入力してください");
                this.scanner.next();
            }
        }
        return inputNumber;
    }

    //　プレイヤーからの文字列入力を受け取る
    public String getStringInput() {
        return this.scanner.nextLine();
    }
}
