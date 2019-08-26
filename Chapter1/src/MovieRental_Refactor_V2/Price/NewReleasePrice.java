package MovieRental_Refactor_V2.Price;

import MovieRental_Refactor_V2.MovieType;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return MovieType.NEW_RELEASE;
    }

    @Override
    public double getCharged(int daysRented) {
        return daysRented * NEW_RELEASE_BASEPRICE;
    }

    @Override
    public int getFrequentRenterPoints (int daysRented) {
        //add bonus for a two day new release rental
       return (daysRented > NEW_RELEASE_BASEDAYS) ? 2 : 1;
    }
}
