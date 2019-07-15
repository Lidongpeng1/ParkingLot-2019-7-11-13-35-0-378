package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> cars = new HashMap<>();//使用map来存储车和停车票
    private int capacity = 10;  //设置停车场的最大容量

    public ParkingLot() {}

    public ParkingLot(int capacity) {  //使用构造函数来自由设置停车场最大停车数，这里默认设置为10
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (cars.size() >= capacity) {
            throw new IllegalStateException("Not enough position.");//停车场位置已满
        }
        if (car == null) { //如果当前传入的var是空的，则输出空指针异常
            throw new NullPointerException();
        }
        if (cars.containsValue(car)) {  //如果当前停车成已经停了该车，则输出异常
            throw new IllegalArgumentException("Can not passing a parked car.");
        }
        ParkingTicket parkingTicket = new ParkingTicket(); //执行到这一步说明可以存车，创建新的停车票
        cars.put(parkingTicket, car); //在cars中存入当前存的车
        return parkingTicket; //返回当前的Ticket对象，也就是当前的停车票
    }

    public Car fetchCar(ParkingTicket ticket) { //取车方法
        if (ticket == null) { //如果停车票为空
            throw new IllegalArgumentException("Please provide your parking ticket.");//请提供你的车票
        }
        Car car = cars.remove(ticket);//Map集合的remove方法，返回值为对应的car对象
        if (car == null) {
            throw new IllegalArgumentException("Unrecognized parking ticket.");//remove失败返回空，则说明车票无效，返回无法识别的车票
        }
        return car;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int availablePositionsCount() {
        return capacity - cars.size();
    }//提供求可用停车位的方法
}
