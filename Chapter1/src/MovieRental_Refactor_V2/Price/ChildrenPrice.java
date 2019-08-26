package MovieRental_Refactor_V2.Price;

import MovieRental_Refactor_V2.MovieType;

public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return MovieType.CHILDRENS;
    }

    @Override
    public double getCharged(int daysRented) {
        double rentalAmount = CHILDREN_BASEPRICE;
        if (daysRented > CHILDREN_BASEDAYS) {
            rentalAmount += (daysRented - CHILDREN_BASEDAYS) * BONUS_PRICE;
        }
        return rentalAmount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }


}
