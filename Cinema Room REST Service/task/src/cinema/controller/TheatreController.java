package cinema.controller;

import cinema.classes.*;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

    @RestController
    public  class TheatreController {
        MovieTheatre movieTheatre = new MovieTheatre(9, 9);
        List<Purchase> purchases = new ArrayList<>();
        Stats stats = new Stats(movieTheatre.getTotal_columns() * movieTheatre.getTotal_rows());


        @GetMapping("/seats")
        public MovieTheatre getAvailableSeats() {
            return movieTheatre;
        }


        @PostMapping("/purchase")
        public Purchase ticketPurchase(@RequestBody Seat s) {
            int row = s.getRow();
            int column = s.getColumn();
            if (row > movieTheatre.getTotal_rows() || column > movieTheatre.getTotal_columns()
                    || row <= 0 || column <= 0) {
                throw new SeatException("The number of a row or a column is out of bounds!");
            }

            for (Seat seat : movieTheatre.getAvailable_seats()) {
                if (seat.getRow() == row && seat.getColumn() == column && !seat.isBought()) {
                    seat.setBought(true);
                    Purchase purchase = new Purchase();
                    UUID token = UUID.randomUUID();
                    purchase.setToken(token);
                    purchase.setTicket(seat);
                    purchases.add(purchase);
                    stats.setCurrent_income(stats.getCurrent_income() + seat.getPrice());
                    stats.setNumber_of_purchased_tickets(stats.getNumber_of_purchased_tickets() + 1);
                    stats.setNumber_of_available_seats(stats.getNumber_of_available_seats() - 1);
                    return purchase;
                }
            }
            throw new SeatException("The ticket has been already purchased!");
        }


        @PostMapping("/return")
        public ReturnedTicket returnedTicket(@RequestBody Purchase purchase){
            for(Purchase p : purchases){
                if(p.getToken().equals(purchase.getToken())){
                    ReturnedTicket returned_ticket = new ReturnedTicket(p.getTicket());
                    p.getTicket().setBought(false);
                    stats.setCurrent_income(stats.getCurrent_income() - p.getTicket().getPrice());
                    stats.setNumber_of_purchased_tickets(stats.getNumber_of_purchased_tickets() - 1);
                    stats.setNumber_of_available_seats(stats.getNumber_of_available_seats() + 1);
                    return returned_ticket;
                }
            }
            throw new SeatException("Wrong token!");
        }

        @PostMapping("/stats")

        public Stats getStats(@RequestParam(required = false) String password) {
            if(password != null && !password.isBlank()){
                return stats;
            } else if (password == null) {
                throw new AccessUnauthorized("The password is wrong!");
            } else {
                throw new AccessUnauthorized("The password is wrong!");
            }

        }

    }
