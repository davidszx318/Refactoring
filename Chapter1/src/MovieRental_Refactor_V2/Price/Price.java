package MovieRental_Refactor_V2.Price;

/**
 * Replace Type Code with State/Strategy
 */
public abstract class Price {
    public double CHILDREN_BASEPRICE = 1.5;
    public int CHILDREN_BASEDAYS = 3;

    public double NEW_RELEASE_BASEPRICE = 1.5;
    public int NEW_RELEASE_BASEDAYS = 1;

    public double REGULAR_BASEPRICE = 2;
    public int REGULAR_BASEDAYS = 2;

    public double BONUS_PRICE = 1.5;
    /**
     * @return priceCode based on different movie types
     */
    public abstract int getPriceCode();

    /**
     * @return price charged based on different movie types
     */
    public abstract double getCharged(int daysRented);

    public abstract int getFrequentRenterPoints (int daysRented);

}

