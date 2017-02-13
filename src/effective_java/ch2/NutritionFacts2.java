package effective_java.ch2;

/**
 * Created by Poker on 2017/2/4.
 */
public class NutritionFacts2 {

    private final int servingSize;  // ml               required
    private final int servings;     // per container    required
    private final int calories;     //                  optional
    private final int fat;          // g                optional

    public static class Builder {
        // required paras
        private final int servingSize;
        private final int servings;
        // optional paras
        private int calories;
        private int fat;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public NutritionFacts2 build() {
            return new NutritionFacts2(this);
        }
    }

    private NutritionFacts2(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

}
