package com.mrliuxia.effective_java.ch2;

/**
 * Created by Poker on 2017/2/4.
 */
public class NutritionFacts1 {

    private int servingSize = -1;
    private int servings = -1;
    private int calories = 0;
    private int fat = 0;

    public NutritionFacts1() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }
}
