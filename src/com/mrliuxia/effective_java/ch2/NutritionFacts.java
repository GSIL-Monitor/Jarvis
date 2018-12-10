package com.mrliuxia.effective_java.ch2;

/**
 * Created by Poker on 2017/2/4.
 */
public class NutritionFacts {

    private final int servingSize;  // ml               required
    private final int servings;     // per container    required
    private final int calories;     //                  optional
    private final int fat;          // g                optional

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
    }
}
