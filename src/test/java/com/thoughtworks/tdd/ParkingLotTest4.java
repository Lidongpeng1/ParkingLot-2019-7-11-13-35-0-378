package com.thoughtworks.tdd;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest4 {
    @Test
    public void should_select_more_empty_positions_parking_lot_when_park_by_smart_parking_boy() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        // when
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.assignParkingLot(parkingLot);
        smartParkingBoy.assignParkingLot(parkingLot2);
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        // then
        assertThat(parkingTicket, notNullValue());
        assertThat(parkingLot2.availablePositionsCount(), CoreMatchers.is(1));
    }
}
