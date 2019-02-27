package model;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private int id;
    private String date;
    private String paymentStatus;
    private Drugstore drugstore;
    private int recipeId;
    private List<DrugInPurchase> purchasedDrugs;
    private String patientPassport;

    // without purchase id
    public Purchase(String date, String paymentStatus, Drugstore drugstore, int recipeId, String patientPassport) {
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.drugstore = drugstore;
        this.recipeId = recipeId;
        this.patientPassport = patientPassport;

        purchasedDrugs = new ArrayList<>();
    }

    // with purchase id
    public Purchase(int id, String date, String paymentStatus, Drugstore drugstore, int recipeId, String patientPassport) {
        this.id = id;
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.drugstore = drugstore;
        this.recipeId = recipeId;
        this.patientPassport = patientPassport;

        purchasedDrugs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getPatientPassport() {
        return patientPassport;
    }

    public List<DrugInPurchase> getPurchasedDrugs() {
        return purchasedDrugs;
    }

    public void setPurchasedDrugs(List<DrugInPurchase> purchasedDrugs) {
        this.purchasedDrugs = purchasedDrugs;
    }

    public String toString() {
        return "#" + id + ", пацієнт " + patientPassport;
    }

    public String detailedToString() {
        String res = "# " + id + "\nДата: " + date + "\nПацієнт: " + patientPassport + "\nНомер рецепту: " + recipeId + "\nЛіки: ";

        double overallPrice = 0;

        for (DrugInPurchase d: purchasedDrugs) {
            Drug drug = d.getDrug();
            List<DrugInDrugstore> drugstoresList = drug.getDrugstoresSelling();

            double onePurchasePrice = 0;

            for(DrugInDrugstore did : drugstoresList) {
                if (did.getDrugstore().equals(drugstore)) {
                    onePurchasePrice += did.getPrice() * d.getAmount();
                }
            }

            overallPrice += onePurchasePrice;

            res += "\n  Назва: " + drug.getName() + "\n  К-сть: " + d.getAmount() + "\n  Виробник: " + drug.getProducer() + "\n  Номер ліків: " + drug.getId() + "\n  Вартість: " + onePurchasePrice + " грн\n";
        }

        res += "\nАптека: " + drugstore + "\nСтатус оплати: " + paymentStatus + "\nЗагальна вартість: " + overallPrice + " грн";
        return res;
    }
}
