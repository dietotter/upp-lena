package com.company;

import model.*;

public class DemoLogic {

    // ALL DRUGSTORES
    private Drugstore[] drugstoresArr = {
            new Drugstore(0, "Аптека низьких цін", "Сковороди, 2"),
            new Drugstore(1, "Аптека Бджілка", "Хрещатик, 79")
    };

    private Drug[] drugsArr;
    private Recipe[] recipesArr = {
            new Recipe(0, "20.02.2019", "Вася", "Якийсь-чувак"),
            new Recipe(1, "13.01.2019", "Петя", "Побігайчик"),
            new Recipe(2, "31.12.2018", "Вася", "Побігайчик")
    };

    private Doctor[] doctorsArr;

    private Patient[] patientsArr = {
            new Patient("AS123456", "Якийсь-чувак", "11.12.1990"),
            new Patient("QW789012", "Побігайчик", "01.05.1965")
    };

    private Purchase[] purchasesArr = {
            new Purchase(0, "21.02.2019", "сплачено", drugstoresArr[0], recipesArr[0].getId(), patientsArr[0].getPassport()),
            new Purchase(1, "14.01.2019", "сплачено", drugstoresArr[0], recipesArr[1].getId(), patientsArr[1].getPassport()),
            new Purchase(2, "01.01.2019", "відмінено", drugstoresArr[1], recipesArr[2].getId(), patientsArr[1].getPassport())
    };

    public DemoLogic() {
        drugsArr = prepareDrugs();
        prepareRecipes();
        doctorsArr = prepareDoctors();
        preparePatients();
        preparePurchases();
    }

    // ALL PURCHASES
    public void preparePurchases() {

        purchasesArr[0].getPurchasedDrugs().add(new DrugInPurchase(drugsArr[0], 2));
        purchasesArr[0].getPurchasedDrugs().add(new DrugInPurchase(drugsArr[1], 1));

        purchasesArr[1].getPurchasedDrugs().add(new DrugInPurchase(drugsArr[1], 1));
        purchasesArr[1].getPurchasedDrugs().add(new DrugInPurchase(drugsArr[2], 3));

        purchasesArr[2].getPurchasedDrugs().add(new DrugInPurchase(drugsArr[2], 1));
        purchasesArr[2].getPurchasedDrugs().add(new DrugInPurchase(drugsArr[3], 2));

    }

    // ALL DRUGS
    public Drug[] prepareDrugs() {
        Drug[] arr = {
                new Drug(0, "Ібупрофен", "ВОЛЯ ТОВ", 1000),
                new Drug(1, "Парацетамол", "Дарниця", 1100),
                new Drug(2, "Аспірін", "ВОЛЯ ТОВ", 900),
                new Drug(3, "Йод", "Чернігівниця", 535.6)
        };

        arr[0].getDrugstoresSelling().add(new DrugInDrugstore(drugstoresArr[0], "18.10.2018", 20.5));

        arr[1].getDrugstoresSelling().add(new DrugInDrugstore(drugstoresArr[0], "18.10.2018", 30));
        arr[1].getDrugstoresSelling().add(new DrugInDrugstore(drugstoresArr[1], "18.10.2018", 32));

        arr[2].getDrugstoresSelling().add(new DrugInDrugstore(drugstoresArr[1], "18.10.2018", 12.95));
        arr[2].getDrugstoresSelling().add(new DrugInDrugstore(drugstoresArr[0], "18.10.2018", 12.4));

        arr[3].getDrugstoresSelling().add(new DrugInDrugstore(drugstoresArr[1], "18.10.2018", 9));

        return arr;
    }

    // ALL RECIPES
    public void prepareRecipes() {
        recipesArr[0].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[0], 2));
        recipesArr[0].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[1], 1));

        recipesArr[1].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[1], 1));
        recipesArr[1].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[2], 3));

        recipesArr[2].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[2], 1));
        recipesArr[2].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[3], 2));
    }

    // ALL DOCTORS
    public Doctor[] prepareDoctors() {
        Doctor[] arr = {
                new Doctor(0, "Вася", "Онколог", 2),
                new Doctor(1, "Петя", "Дерматолог", 3)
        };

        arr[0].getWrittenRecipes().add(recipesArr[0]);
        arr[0].getWrittenRecipes().add(recipesArr[2]);

        arr[1].getWrittenRecipes().add(recipesArr[1]);
        return arr;

        // DefaultListModel<>
    }

    // ALL PATIENTS
    public void preparePatients() {

        patientsArr[0].getPurchases().add(purchasesArr[0]);

        patientsArr[1].getPurchases().add(purchasesArr[1]);
        patientsArr[1].getPurchases().add(purchasesArr[2]);
    }

    public Drug[] getDrugsArr() {
        return drugsArr;
    }

    public Drugstore[] getDrugstoresArr() {
        return drugstoresArr;
    }

    public Recipe[] getRecipesArr() {
        return recipesArr;
    }

    public Doctor[] getDoctorsArr() {
        return doctorsArr;
    }

    public Patient[] getPatientsArr() {
        return patientsArr;
    }

    public Purchase[] getPurchasesArr() {
        return purchasesArr;
    }
}
