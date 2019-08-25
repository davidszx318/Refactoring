package MovieRental_Refactor;

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

    double getCharged () {
        double rentalAmount = 0;
        int priceCode = this.getMovie().getPriceCode();

        if (priceCode == Movie.REGULAR) {
            rentalAmount += 2;
            if (this.getDaysRented() > 2) {
                rentalAmount += (this.getDaysRented() - 2) * 1.5;
            }
        } else if (priceCode == Movie.NEW_RELEASE) {
            rentalAmount += this.getDaysRented() * 3;
        } else if (priceCode == Movie.CHILDRENS) {
            rentalAmount += 1.5;
            if (this.getDaysRented() > 3) {
                rentalAmount += (this.getDaysRented() - 3) * 1.5;
            }
        }

        return rentalAmount;
    }


    int getFrequentRenterPoints () {
        //add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1){
            return 2;
        } else {
            return 1;
        }
    }
}
