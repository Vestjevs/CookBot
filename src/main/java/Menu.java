import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Menu {
    private JSONParser parser = new JSONParser();
    private File resources = new File("/mnt/a04a4060-e572-41b7-bafe-bfad457696d5/Files/Repositories/CookBot/resources/Recipes");
    private File[] menu = resources.listFiles();

    private Random random = new Random();


    public Menu() {
    }

    public String getFirstDish() {
        StringBuilder dish = new StringBuilder();
        try {
            JSONObject firstDishes = (JSONObject) parser.parse(new FileReader(menu[1]));
            JSONArray allFirstDishes = (JSONArray) firstDishes.get("Первые блюда");

            JSONArray spFirstDishes = (JSONArray) allFirstDishes.get(random.nextInt(allFirstDishes.size()));
            JSONObject othDish = (JSONObject) spFirstDishes.get(random.nextInt(spFirstDishes.size()));

            dish.append(othDish.get("name")).append("\n");
            dish.append("\n");

            dish.append("Ингредиенты\n");
            dish.append("\n");


            for (Object ob :
                    (JSONArray) othDish.get("ingredients")) {
                dish.append(ob.toString()).append("\n");
            }

            dish.append("Шаги приготовления\n");
            dish.append("\n");

            for (Object ob :
                    (JSONArray) othDish.get("steps")) {
                dish.append(ob.toString()). append("\n");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return dish.toString();
    }

    public String getSecondDish() {
        StringBuilder dish = new StringBuilder();
        try {
            JSONObject secondDishes = (JSONObject) parser.parse(new FileReader(menu[2]));
            JSONArray allSecondDishes = (JSONArray) secondDishes.get("Вторые блюда");

            JSONArray spSecondDishes = (JSONArray) allSecondDishes.get(random.nextInt(allSecondDishes.size()));
            JSONObject othDish = (JSONObject) spSecondDishes.get(random.nextInt(spSecondDishes.size()));

            dish.append(othDish.get("name")).append("\n");
            dish.append("\n");

            dish.append("Ингредиенты\n");
            dish.append("\n");


            for (Object ob :
                    (JSONArray) othDish.get("ingredients")) {
                dish.append(ob.toString()).append("\n");
            }

            dish.append("Шаги приготовления\n");
            dish.append("\n");

            for (Object ob :
                    (JSONArray) othDish.get("steps")) {
                dish.append(ob.toString()). append("\n");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return dish.toString();

    }

    public String getSalad() {
        StringBuilder dish = new StringBuilder();
        try {
            JSONObject salads = (JSONObject) parser.parse(new FileReader(menu[0]));
            JSONArray allSalads = (JSONArray) salads.get("Рецепты салатов");

            JSONArray spSalads = (JSONArray) allSalads.get(random.nextInt(allSalads.size()));
            JSONObject obSalad = (JSONObject) spSalads.get(random.nextInt(spSalads.size()));


            dish.append(obSalad.get("name")).append("\n");
            dish.append("\n");
            dish.append("Ингредиенты\n");
            dish.append("\n");

            for (Object ob :
                    (JSONArray) obSalad.get("ingredients")) {
                dish.append(ob.toString()).append("\n");
            }

            dish.append("Шаги приготовления\n");
            dish.append("\n");

            for (Object ob :
                    (JSONArray) obSalad.get("steps")) {
                dish.append(ob.toString()). append("\n");
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return dish.toString();
    }

    public String getRandomDish() {
        int choice = random.nextInt(3);

        if (choice == 0) {
            return getSalad();
        } else if (choice == 1) {
            return getFirstDish();
        } else {
            return getSecondDish();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println(menu.getRandomDish());

    }

}
