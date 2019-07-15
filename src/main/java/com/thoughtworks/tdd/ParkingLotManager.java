package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private List<ParkingBoy> parkingBoys = new ArrayList<>();  //停车经理能够管理多个停车男孩
    private ParkingLot parkingLot; //停车经理管理一个停车场

    public ParkingLotManager() {} //无参的构造函数

    public ParkingLotManager(ParkingLot parkingLot) { //传一个停车场的构造函数
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(ParkingBoy parkingBoy, Car car) { //经理要停车男孩去停车
        if (parkingBoys.contains(parkingBoy)) {  //如果停车男孩已经存在了
            return parkingBoy.park(car);  //如果男孩存在，那么就可以让男孩进行停车，返回车票或者异常
        } else {
            throw new IllegalStateException("No boy is working.");  //这个男孩不在这个经理的管辖范围之内，则返回这个男孩没有在这里工作
        }
    }

    public ParkingTicket park(Car car) {  //经理到管理的停车场进行停车
        return parkingLot.park(car);  //该经理只有一个停车场，所以不需要进行停车场的遍历
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {  //该经理可以添加男孩到停车男孩数组中
        parkingBoys.add(parkingBoy);
    }

    public void setParkingLot(ParkingLot parkingLot) { //提供停车场的设置方法
        this.parkingLot = parkingLot;
    }
}
