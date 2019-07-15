package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest3 {
    @Test
    public void should_return_parking_ticket_when_park_given_multiple_parking_lot_to_boy() {
        // when
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.assignParkingLot(new ParkingLot(1));
        parkingBoy.assignParkingLot(new ParkingLot(1));
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        ParkingTicket parkingTicket2 = parkingBoy.park(new Car());
        // then
        assertThat(parkingTicket, notNullValue());
        assertThat(parkingTicket2, notNullValue());
    }
}
