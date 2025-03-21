package Generics;

import java.util.ArrayList;
import java.util.List;

// MealPlan Interface
interface MealPlan {
    String getMealType();
}

// Specific Meal Types
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private String name;
    private T mealType;

    public Meal(String name, T mealType) {
        this.name = name;
        this.mealType = mealType;
    }

    public String getName() {
        return name;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return "Meal: " + name + ", Type: " + mealType.getMealType();
    }
}

// Meal Plan Generator
class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(List<Meal<T>> meals) {
        System.out.println("Generated Meal Plan:");
        for (Meal<T> meal : meals) {
            System.out.println(meal);
        }
    }
}

public class MealPlanner {
    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();

        mealPlans.add(new Meal<>("Grilled Paneer", new VegetarianMeal()));
        mealPlans.add(new Meal<>("Avocado Salad", new VeganMeal()));
        mealPlans.add(new Meal<>("Keto Chicken", new KetoMeal()));
        mealPlans.add(new Meal<>("Protein Shake", new HighProteinMeal()));

        System.out.println("Personalized Meal Plan:");
        for (Meal<?> meal : mealPlans) {
            System.out.println(meal);
        }
    }
}

