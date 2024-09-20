package subject2;

import java.util.List;

public class StationMain {

	public static void main(String[] args) {
		
	
		StationDao stationDao = new JDBCStationDao();

       
        Station newStation = new Station("A", "001", "Seoul");
        boolean insertSuccess = stationDao.insert(newStation);
        if (insertSuccess) {
            System.out.println("역 정보가 성공적으로 입력되었습니다!");
        } else {
            System.out.println("입력에 실패하였습니다.");
        }

        
        List<Station> stations = stationDao.findAll();
        System.out.println("역의 모든 정보를 출력합니다:");
        for (Station station : stations) {
            System.out.println("역이름: " + station.getName() + ", 역 번호: " + station.getStNum() + ", 역 주소: " + station.getAddress());
        }

       
        String stNumToFind = "001"; 
        Station foundStation = stationDao.find(stNumToFind);
        if (foundStation != null) {
            System.out.println("역을 찾았습니다:");
            System.out.println("역 이름: " + foundStation.getName() + ", 역 번호: " + foundStation.getStNum() + ", 역 주소: " + foundStation.getAddress());
        } else {
            System.out.println("역 검색에 실패하였습니다" + stNumToFind);
        }

        
        Station updatedStation = new Station();
        boolean updateSuccess = stationDao.update(updatedStation);
        if (updateSuccess) {
            System.out.println("성공적으로 수정되었습니다!");
        } else {
            System.out.println("수정에 실패하였습니다.");
        }

        
        boolean deleteSuccess = stationDao.delete(stNumToFind);
        if (deleteSuccess) {
            System.out.println("성공적으로 삭제 하였습니다!");
        } else {
            System.out.println("삭제에 실패하였습니다.");
        }
}
}