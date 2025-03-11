package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

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
                        System.out.println("Recipes:");
                        displayRecipes(); // [設問1] レシピを表示させる
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        //System.out.println(fileHandler.getFileHandler());
                        addNewRecipe();

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
        ArrayList<String> recipeName = new ArrayList<>();
        ArrayList<String> ingredients = new ArrayList<>();
        recipeName.add("Tomato Soup");
        ingredients.add("Tomatoes, Onion, Garlic, Vegetable Stock");

        if (recipeName != null || ingredients != null) {
            // レシピデータの表示
            System.out.println("-----------------------------------");
            System.out.println("Recipe Name: " + recipeName.get(0));
            System.out.println("Main Ingredients: " + recipeName.get(0));
            System.out.println("-----------------------------------");
        } //else {
            // 読み込んだレシピデータが空の場合に、メッセージを出力
            //System.out.println("No recipes available.");
        //}

    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        // [途中] ファイル名 RecipeFileHandlerを利用していない
        String filename = fileHandler.getFileHandler();
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
        String recipeName = "";
        String ingredients = "";
        //addRecipe(recipeName, ingredients);

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

