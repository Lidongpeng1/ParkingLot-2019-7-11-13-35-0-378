package com.thoughtworks.tdd;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {
    @Test
    public void should_return_parking_ticket_when_invoke_park_given_a_car() {
        // given
        Car carToBePark = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        // then
        assertThat(parkingTicket, notNullValue());

        // given
        // when
        Car fetchedCar = parkingBoy.fetchCar(parkingTicket);
        // then
        assertThat(fetchedCar, CoreMatchers.equalTo(carToBePark));
    }

    @Test
    public void should_return_parking_tickets_when_invoke_park_given_multiple_cars() {
        // given
        Car carToBePark = new Car();
        Car carToBePark2 = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        ParkingTicket parkingTicket2 = parkingBoy.park(carToBePark2);
        // then
        assertThat(parkingTicket, notNullValue());
        assertThat(parkingTicket2, notNullValue());

        // given
        // when
        Car fetchedCar = parkingBoy.fetchCar(parkingTicket);
        Car fetchedCar2 = parkingBoy.fetchCar(parkingTicket2);
        // then
        assertThat(fetchedCar, CoreMatchers.equalTo(carToBePark));
        assertThat(fetchedCar2, CoreMatchers.equalTo(carToBePark2));
    }

    @Test
    public void should_throw_exception_with_message_when_invoke_fetchCar_given_wrong_ticket() {
        // given
        Car carToBePark = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        // then
        assertThat(parkingTicket, notNullValue());

        // given
        // when
        try {
            parkingBoy.fetchCar(new ParkingTicket());
        } catch (Exception e) {
            assertThat(e.getMessage(), CoreMatchers.is("Unrecognized parking ticket."));
        }
    }

    @Test
    public void should_throw_exception_with_message_when_invoke_fetchCar_twice_given_same_ticket() {
        // given
        Car carToBePark = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        // then
        assertThat(parkingTicket, notNullValue());

        // given
        // when
        Car fetchedCar = parkingBoy.fetchCar(parkingTicket);
        try {
            parkingBoy.fetchCar(parkingTicket);
        } catch (Exception e) {
            assertThat(e.getMessage(), CoreMatchers.is("Unrecognized parking ticket."));
        }
        // then
        assertThat(fetchedCar, CoreMatchers.equalTo(carToBePark));
    }

    @Test
    public void should_throw_exception_with_message_when_invoke_park_while_ParkingLot_is_full() {
        // given
        Car carToBePark = new Car();
        Car carToBePark2 = new Car();
        Car carToBePark3 = new Car();
        Car carToBePark4 = new Car();
        Car carToBePark5 = new Car();
        Car carToBePark6 = new Car();
        Car carToBePark7 = new Car();
        Car carToBePark8 = new Car();
        Car carToBePark9 = new Car();
        Car carToBePark10 = new Car();
        Car carToBePark11 = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(carToBePark);
        ParkingTicket parkingTicket2 = parkingBoy.park(carToBePark2);
        ParkingTicket parkingTicket3 = parkingBoy.park(carToBePark3);
        ParkingTicket parkingTicket4 = parkingBoy.park(carToBePark4);
        ParkingTicket parkingTicket5 = parkingBoy.park(carToBePark5);
        ParkingTicket parkingTicket6 = parkingBoy.park(carToBePark6);
        ParkingTicket parkingTicket7 = parkingBoy.park(carToBePark7);
        ParkingTicket parkingTicket8 = parkingBoy.park(carToBePark8);
        ParkingTicket parkingTicket9 = parkingBoy.park(carToBePark9);
        ParkingTicket parkingTicket10 = parkingBoy.park(carToBePark10);
        try {
            parkingBoy.park(carToBePark11);
        } catch (Exception e) {
            assertThat(e.getMessage(), CoreMatchers.is("Not enough position."));
        }
        // then
        assertThat(parkingTicket, notNullValue());
        assertThat(parkingTicket2, notNullValue());
        assertThat(parkingTicket3, notNullValue());
        assertThat(parkingTicket4, notNullValue());
        assertThat(parkingTicket5, notNullValue());
        assertThat(parkingTicket6, notNullValue());
        assertThat(parkingTicket7, notNullValue());
        assertThat(parkingTicket8, notNullValue());
        assertThat(parkingTicket9, notNullValue());
        assertThat(parkingTicket10, notNullValue());
    }

    @Test
    public void should_throw_Exception_when_invoke_fetchCar_given_parked_car_or_null() {
        // given
        Car carToBePark = new Car();
        // when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        parkingBoy.park(carToBePark);
        Exception exception = null;
        try {
            parkingBoy.park(carToBePark);
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception, CoreMatchers.instanceOf(IllegalArgumentException.class));

        // given
        Car carToBePark2 = null;
        // when
        try {
            parkingBoy.park(carToBePark2);
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception, CoreMatchers.instanceOf(NullPointerException.class));
    }
}
