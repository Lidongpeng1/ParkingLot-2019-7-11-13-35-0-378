package com.thoughtworks.tdd;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest6 {
    @Test
    public void test_service_manager_specify_parking_boy_in_manage_list_to_park_or_fetch_the_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(4);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy();
        // when
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        parkingBoy.assignParkingLot(parkingLot);
        parkingLotManager.addParkingBoy(parkingBoy);
        ParkingTicket parkingTicket = parkingLotManager.park(parkingBoy, new Car());
        // then
        assertThat(parkingTicket, notNullValue());
    }

    @Test
    public void test_service_manager_park_or_fetch_the_car_by_itself() {
        // given
        ParkingLot parkingLot = new ParkingLot(4);
        // when
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        ParkingTicket parkingTicket = parkingLotManager.park(new Car());
        // then
        assertThat(parkingTicket, notNullValue());
    }

    @Test
    public void should_throw_exception_with_message_when_manager_park_given_boy_while_boy_not_work() {
        // given
        ParkingLot parkingLot = new ParkingLot(4);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy();
        // when
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        try {
            parkingLotManager.park(parkingBoy, new Car());
        } catch (Exception e) {
            // then
            assertThat(e.getMessage(), CoreMatchers.is("No boy is working."));
        }
    }
}
