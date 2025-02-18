import java.util.ArrayList;
import java.util.List;

// MealPlan interface
interface MealPlan {
    String getMealName();
}

// Concrete MealPlan implementations
class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String toString() {
        return "Vegetarian Meal: " + mealName;
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String toString() {
        return "Vegan Meal: " + mealName;
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String toString() {
        return "Keto Meal: " + mealName;
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String toString() {
        return "High Protein Meal: " + mealName;
    }
}

// Generic Meal Plan class
class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

// Utility class with generic method
class MealPlanner {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> mealPlan) {
        System.out.println("Generating Meal Plan:");
        for (MealPlan meal : mealPlan.getMeals()) {
            System.out.println(meal);
        }
    }
}

// Main Class
public class MealPlanGenerator {
    public static void main(String[] args) {
        // Create different meal plans
        Meal<VegetarianMeal> vegetarianPlan = new Meal<>();
        Meal<VeganMeal> veganPlan = new Meal<>();
        Meal<KetoMeal> ketoPlan = new Meal<>();
        Meal<HighProteinMeal> highProteinPlan = new Meal<>();

        // Add meals
        vegetarianPlan.addMeal(new VegetarianMeal("Grilled Veggie Salad"));
        vegetarianPlan.addMeal(new VegetarianMeal("Mushroom Risotto"));

        veganPlan.addMeal(new VeganMeal("Quinoa & Chickpea Bowl"));
        veganPlan.addMeal(new VeganMeal("Tofu Stir-Fry"));

        ketoPlan.addMeal(new KetoMeal("Avocado & Egg Salad"));
        ketoPlan.addMeal(new KetoMeal("Grilled Salmon with Asparagus"));

        highProteinPlan.addMeal(new HighProteinMeal("Chicken Breast with Brown Rice"));
        highProteinPlan.addMeal(new HighProteinMeal("Protein Smoothie with Almond Butter"));

        // Generate meal plans
        System.out.println("Vegetarian Meal Plan:");
        MealPlanner.generateMealPlan(vegetarianPlan);

        System.out.println("\nVegan Meal Plan:");
        MealPlanner.generateMealPlan(veganPlan);

        System.out.println("\nKeto Meal Plan:");
        MealPlanner.generateMealPlan(ketoPlan);

        System.out.println("\nHigh Protein Meal Plan:");
        MealPlanner.generateMealPlan(highProteinPlan);
    }
}
