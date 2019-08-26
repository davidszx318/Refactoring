package MovieRental_Refactor_V2.Price;

import MovieRental_Refactor_V2.MovieType;

/** replace conditional with Polymorphism **/
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return MovieType.REGULAR;
    }

    @Override
    public double getCharged(int daysRented) {
        double rentalAmount = REGULAR_BASEPRICE;
        if (daysRented > REGULAR_BASEDAYS) {
            rentalAmount += (daysRented - REGULAR_BASEDAYS) * BONUS_PRICE;
        }
        return rentalAmount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
