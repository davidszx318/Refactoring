package MovieRental_Refactor_V2;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental (Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    int getFrequentRenterPoints () {
        return movie.getFrequentRenterPoints(daysRented);
    }

    double getCharged() {
        return movie.getCharged(daysRented);
    }
}
