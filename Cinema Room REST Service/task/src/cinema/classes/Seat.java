package cinema.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

    private int row;
    private int column;
    private int price;
    private boolean bought;

    public Seat() {
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public Seat(int row, int column, int price, boolean bought) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.bought = bought;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @JsonIgnore
    public boolean isBought() {
        return bought;
    }

    @JsonIgnore
    public void setBought(boolean bought) {
        this.bought = bought;
    }

}
