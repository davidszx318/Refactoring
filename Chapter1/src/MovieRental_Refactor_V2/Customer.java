package MovieRental_Refactor_V2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private final Iterator rentalsIterator = rentals.iterator();
    public Customer(String name) {
        this.name = name;
    }

    public void addRental (Rental newRental) {
        rentals.add(newRental);
    }

    public String getName () {
        return name;
    }

    public String statement () {
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsIterator.hasNext()) {
            Rental each = (Rental) rentalsIterator.next();

            //determine amounts for each line
            double thisAmount = each.getCharged();

            //show figures for this rental;
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    //after refactor, we can easily add htmlStatement() for customer.
    public String htmlStatement () {
        String result = "<H1>Rental Record for " + getName() + "</H1>\n";
        while (rentalsIterator.hasNext()) {
            Rental each = (Rental) rentalsIterator.next();

            //determine amounts for each line
            double thisAmount = each.getCharged();

            //show figures for this rental;
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private int getFrequentRenterPoints () {
        int frequentRenterPoints = 0;

        while (rentalsIterator.hasNext()) {
            Rental each = (Rental) rentalsIterator.next();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    private double getTotalAmount () {
        int totalAmount = 0;

        while (rentalsIterator.hasNext()) {
            Rental each = (Rental) rentalsIterator.next();
            totalAmount += each.getCharged();
        }

        return totalAmount;
    }
}
