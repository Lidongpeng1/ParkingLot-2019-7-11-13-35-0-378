package com.thoughtworks.tdd;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest5 {
    @Test
    public void should_select_parking_lot_with_best_rate_when_park_by_super_smart_parking_boy() {
        // given
        ParkingLot parkingLot = new ParkingLot(4);
        ParkingLot parkingLot2 = new ParkingLot(2);
        // when
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy();
        parkingBoy.assignParkingLot(parkingLot);
        parkingBoy.assignParkingLot(parkingLot2);
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        ParkingTicket parkingTicket2 = parkingBoy.park(new Car());
        // then
        assertThat(parkingTicket, notNullValue());
        assertThat(parkingTicket2, notNullValue());
        assertThat(parkingLot.availablePositionsCount(), CoreMatchers.is(3));
        assertThat(parkingLot2.availablePositionsCount(), CoreMatchers.is(1));
    }
}
