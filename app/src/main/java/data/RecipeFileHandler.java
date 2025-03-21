package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipeDatas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                recipeDatas.add(line); // ArrrayListに要素を追加
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return recipeDatas;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
    // テキストファイルに新しいレシピを書き込みする。
        // ファイル名
        String filename = this.filePath;
        // 引数で受け取ったレシピ名・材料を文字列結合
        String contentToWrite = recipeName + "," + ingredients;
        // 既存のレシピに追加で書き込む
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // 書き込み実行
            writer.write(contentToWrite);
            writer.newLine(); // 書き込み後に改行
                //System.out.println(contentToWrite);
            // 書き込み完了後のメッセージを出力
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
