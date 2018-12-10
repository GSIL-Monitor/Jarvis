package effective_java.ch2;

/**
 * Created by Poker on 2017/2/4.
 */
public class NutritionFacts_Better {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private NutritionFacts_Better(Builder builder){
        servingSize		= builder.servingSize;
        servings 		= builder.servings;
        calories		= builder.calories;
        fat 			= builder.fat;
        sodium 			= builder.sodium;
        carbohydrate		= builder.carbohydrate;
    }

    public static class Builder {
        //Required parameters
        private final int servingSize;

        private final int servings;
        //Optional parameters - initialized to default values
        private int calories		= 0;
        private int fat 			= 0;
        private int carbohydrate 	= 0;

        private int sodium 			= 0;

        public Builder (int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories (int val) {
            calories = val;
            return this;
        }

        public Builder fat (int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate (int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium (int val) {
            sodium = val;
            return this;
        }
        public NutritionFacts_Better build(){
            return new NutritionFacts_Better(this);
        }

    }

    public static void main(String[] args) {
        NutritionFacts_Better cocaCola = new NutritionFacts_Better
                .Builder(240,8)
                .calories(100)
                .fat(27)
                .carbohydrate(100)
                .sodium(50)
                .build();
    }

}
