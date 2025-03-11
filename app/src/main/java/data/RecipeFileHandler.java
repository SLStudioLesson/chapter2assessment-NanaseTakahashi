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
    // [後で消す]
    public String getFileHandler() {
        return this.filePath;
    }// [ここまで]

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        //try {

        //} catch (IOException e) {
            //System.out.println("Error reading file:" + e.getMessage());
        //}
        return null;
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
        // [途中] ファイル名 RecipeFileHandlerを利用していない
        String filename = this.filePath;
        // [途中] 書き込む内容（ユーザから入力させる）
        String contentToWrite = "testtesttest";
        // [途中] 既存のレシピに追加で書き込む
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println(contentToWrite);
            //writer.write(contentToWrite);
            //writer.newLine(); // 書き込み後に改行
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try {
        

        // } catch (IOException e) {

        // }
    }
}
