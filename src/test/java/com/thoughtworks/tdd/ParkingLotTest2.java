package com.thoughtworks.tdd;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest2 {
    @Test
    public void should_return_exception_with_message_when_park_given_wrong_ticket() {
        // given
        Car carToBePark = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        // then
        assertThat(parkingTicket, notNullValue());

        // given
        Exception exception = null;
        // when
        try {
            parkingBoy.fetchCar(new ParkingTicket());
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception.getMessage(), CoreMatchers.is("Unrecognized parking ticket."));
    }

    @Test
    public void should_return_exception_with_message_when_park_given_null() {
        // given
        Car carToBePark = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        // then
        assertThat(parkingTicket, notNullValue());

        // given
        Exception exception = null;
        // when
        try {
            parkingBoy.fetchCar(null);
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception.getMessage(), CoreMatchers.is("Please provide your parking ticket."));
    }

    @Test
    public void should_return_exception_with_message_when_park_while_parking_lot_is_full() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        try {
            parkingBoy.park(new Car());
        } catch (Exception e) {
            assertThat(e.getMessage(), CoreMatchers.is("Not enough position."));
        }
    }
}
