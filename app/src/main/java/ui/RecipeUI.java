package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes(); // [設問1] レシピを表示させる
                        break;

                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe(); // [設問2] 新規レシピを追加
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        RecipeFileHandler display = new RecipeFileHandler(); // インスタンス生成
        ArrayList<String> recipeData = new ArrayList<>();
        recipeData = display.readRecipes();
            // ArrayList: recipeDataに {"1行目", "2行目", "3行目", ... }
        if (recipeData.size() != 0) {
            System.out.println("Recipes:");
            for (String recipe : recipeData) {
            // recipeDataの要素を1つずつ取り出す
                String[] datas = recipe.split(",", 2);
                // 配列: datasに X行目の { "レシピ名" , "材料" } が格納される
                
                // [0]レシピ名, [1]材料 をフォーマットにしたがって表示させる
                System.out.println("-----------------------------------");
                System.out.println("Recipe Name: " + datas[0]);
                System.out.println("Main Ingredients: " + datas[1]);
            }
        } else {
            System.out.println("No recipes available.");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        RecipeFileHandler addition = new RecipeFileHandler(); // インスタンス生成
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 2つの値を入力、変数に保存
        System.out.print("Enter recipe name: ");
        String input1 = reader.readLine();
        System.out.print("Enter main ingredients (comma separated): ");
        String input2 = reader.readLine();

        // 保存した値を、addRecipe(String recipeName, String ingredients)に渡して、書き込み実行
        addition.addRecipe(input1, input2);
    }
    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

