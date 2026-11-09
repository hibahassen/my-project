import java.util.Scanner;

public class Produit {

    // Encapsulation des attributs (private)
    private String reference;
    private String designation;
    private double prixHT;
    private int quantiteStock;

    // Constructeur
    public Produit(String reference, String designation, double prixHT, int quantiteStock) {
        this.reference = reference;
        this.designation = designation;
        this.prixHT = prixHT;
        this.quantiteStock = quantiteStock;
    }

    // Getters
    public String getReference() {
        return reference;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    // Setters
    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrixHT(double prixHT) {
        if (prixHT > 0) {
            this.prixHT = prixHT;
        }
    }

    public void setQuantiteStock(int quantiteStock) {
        if (quantiteStock >= 0) {
            this.quantiteStock = quantiteStock;
        }
    }

    // Calcul direct à partir des attributs de l'instance
    public double calculerValeurStock() {
        return this.prixHT * this.quantiteStock;
    }

    // Méthode d'affichage unique
    public void afficher() {
        System.out.println("\n--- Détails du Produit ---");
        System.out.println("Référence      : " + reference);
        System.out.println("Désignation    : " + designation);
        System.out.println("Prix HT        : " + prixHT + " DT");
        System.out.println("Quantité stock : " + quantiteStock);
        System.out.println("Valeur du stock: " + calculerValeurStock() + " DT");
    }

    // Correction du calcul de la remise
    public void appliquerRemise(double pourcentage) {
        if (pourcentage > 0 && pourcentage <= 100) {
            this.prixHT = this.prixHT * (1 - pourcentage / 100.0);
        }
    }

    public static void main(String[] args) {
        Produit p = new Produit("Ref1", "ordinateur", 850.000, 7);
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Afficher les détails du produit");
            System.out.println("2. Calculer la valeur du stock");
            System.out.println("3. Appliquer une remise");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    p.afficher();
                    break;

                case 2:
                    System.out.println("Valeur totale du stock : " + p.calculerValeurStock() + " DT");
                    break;

                case 3:
                    System.out.print("Entrez le pourcentage de remise (ex: 20) : ");
                    double remise = sc.nextDouble();
                    p.appliquerRemise(remise);
                    System.out.println("Remise appliquée ! Nouveau prix HT : " + p.getPrixHT() + " DT");
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix incorrect, veuillez choisir entre 1 et 4.");
            }

        } while (choix != 4);

        sc.close();
    }
}