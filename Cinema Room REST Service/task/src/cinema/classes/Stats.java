package cinema.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Stats {
    @JsonIgnore
    private String super_secret;
    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    public Stats() {
    }

    public Stats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public Stats(int current_income, int number_of_available_seats, int number_of_purchased_tickets) {
        this.current_income = current_income;
        this.number_of_available_seats = number_of_available_seats;
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public String getSuper_secret() {
        return super_secret;
    }

    public void setSuper_secret(String super_secret) {
        this.super_secret = super_secret;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "current_income=" + current_income +
                ", number_of_available_seats=" + number_of_available_seats +
                ", number_of_purchased_tickets=" + number_of_purchased_tickets +
                '}';
    }
}
