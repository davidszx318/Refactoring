package MovieRental_Refactor_V1;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;

    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    //move getChraged() inside movie class to support adding new movie type.
    double getCharged (int daysRented) {
        double rentalAmount = 0;
        int priceCode = getPriceCode();

        if (priceCode == Movie.REGULAR) {
            rentalAmount += 2;
            if (daysRented > 2) {
                rentalAmount += (daysRented - 2) * 1.5;
            }
        } else if (priceCode == Movie.NEW_RELEASE) {
            rentalAmount += daysRented * 3;
        } else if (priceCode == Movie.CHILDRENS) {
            rentalAmount += 1.5;
            if (daysRented > 3) {
                rentalAmount += (daysRented - 3) * 1.5;
            }
        }

        return rentalAmount;
    }

    int getFrequentRenterPoints (int daysRented) {
        //add bonus for a two day new release rental
        if ((this.priceCode == Movie.NEW_RELEASE) && daysRented > 1){
            return 2;
        } else {
            return 1;
        }
    }
}
