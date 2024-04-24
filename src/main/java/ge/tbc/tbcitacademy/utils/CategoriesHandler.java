package ge.tbc.tbcitacademy.utils;

import java.util.Random;

public class CategoriesHandler {
    static Random random = new Random();
    public static int mainCategoryIndex;

    public static int chooseMainCategoryWithSubCategories(int mainCategoriesSize){
        // რენდომი 1დან 10ის ჩათვლით გვაძლევს ინტეჯერს, რომ არ დავაბრუნოთ კინოს კატეგორია(რომელიც 0 ინდექსზეა)
        // კინოს კატეგორიას არ ვაბრუნებთ, რადგან კინოს კატეგორიაში შემოთავაზებებს არ აქვთ ფავორიტებში დამატება და ვაუჩერები, შესაბამისად ჩვენი ტესტისთვის უსარგებლოა
        mainCategoryIndex = random.nextInt(mainCategoriesSize - 1) + 1; // ცვლადში იმისთვის ჩავსვით რომ სტეპ კლასშიც გამოვიყენოთ ეს ინდექსი
        return mainCategoryIndex;
    }

    public static int chooseSubCategory(int subCategoriesSize){
        return random.nextInt(subCategoriesSize);
    }

    public static int chooseMainCategory(int mainCategoriesSize){
        // აქ რენდომი 2დან 12ის ჩათვლით გვაძლევს ინტეჯერს, რომ არ დავაბრუნოთ კინოს კატეგორია(რომელიც 2 ცალი გვაქვს და 0 და 1 ინდექსებზეა)
        // კინოს კატეგორიას არ ვაბრუნებთ, რადგან კინოს კატეგორიაში შემოთავაზებებს არ უწერიათ გაყიდულების რაოდენობა და ვაუჩერები, შესაბამისად ჩვენი ტესტისთვის უსარგებლოა
        return random.nextInt(mainCategoriesSize - 2) + 2;
    }
}
