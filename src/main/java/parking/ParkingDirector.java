package parking;

import java.util.Arrays;
import java.util.List;

public class ParkingDirector {

    List<ParkingManager> parkingManagerList;

    public ParkingDirector(ParkingManager... parkingManagers) {
        this.parkingManagerList = Arrays.asList(parkingManagers);
    }

    public String viewReport(){
        StringBuilder stringBuilder = new StringBuilder();
        for (ParkingManager parkingManage:parkingManagerList
             ) {
            stringBuilder.append(parkingManage.generateReport());
        }
        return  stringBuilder.toString();
    }
}
