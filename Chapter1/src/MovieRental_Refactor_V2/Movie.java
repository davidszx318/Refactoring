package MovieRental_Refactor_V2;

import MovieRental_Refactor_V2.Price.ChildrenPrice;
import MovieRental_Refactor_V2.Price.NewReleasePrice;
import MovieRental_Refactor_V2.Price.Price;
import MovieRental_Refactor_V2.Price.RegularPrice;

public class Movie {

    private String title;

    private Price price;

    public Movie(String title, int price) {
        this.title = title;
        //SelfEncapsulate Field
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPrice(int priceCode) {
        if (priceCode == MovieType.REGULAR) {
            price = new RegularPrice();
        } else if (priceCode == MovieType.NEW_RELEASE) {
            price = new NewReleasePrice();
        } else if (priceCode == MovieType.CHILDRENS) {
            price = new ChildrenPrice();
        } else {
            throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    double getCharged (int daysRented) {
        return price.getCharged(daysRented);
    }

    int getFrequentRenterPoints (int daysRented) {
       return price.getFrequentRenterPoints(daysRented);
    }
}
