package subject1;

import java.sql.Timestamp;
import java.util.List;

public class BusMain {
    public static void main(String[] args) {
       
        Bus bus = new Bus("A1", "1234", new Timestamp(System.currentTimeMillis()));       
        JDBCBusDao dao = new JDBCBusDao();
        
        boolean success = dao.insert(bus);
      
        if (success) {
            System.out.println("버스가 성공적으로 추가되었습니다.");
        } else {
            System.out.println("추가에 실패하였습니다.");
        }
        
        List<Bus> buses = dao.findAll();
        System.out.println("버스의 모든 정보를 출력합니다:");
        for (Bus bus1 : buses) {
            System.out.println("버스 명: " + bus1.getName() + ", 버스 번호: " + bus1.getBusNum() + ", 오는 시간: " + bus1.getTime());
        }
        
        String busNumToFind = "1234"; 
        Bus foundBus = dao.find(busNumToFind);

        if (foundBus != null) {
            System.out.println("찾을 버스:");
            System.out.println("버스 명: " + foundBus.getName() + ", 버스 번호: " + foundBus.getBusNum() + ", 오는 시간: " + foundBus.getTime());
        } else {
            System.out.println("찾으시는 번호 " + busNumToFind + " 없습니다.");
        }
    
    	Bus busToUpdate = new Bus("Updated Name", "1234", new Timestamp(System.currentTimeMillis()));
    	boolean updateSuccess = dao.update(busToUpdate);

    	if (updateSuccess) {
        System.out.println("버스가 성공적으로 업데이트 되었습니다");
    	} else {
        System.out.println("업데이트에 실패하였습니다.");
    	}
    	
    	String busNumToDelete = "1111"; // 삭제할 버스 번호       
        boolean deleteSuccess = dao.delete(busNumToDelete);

        if (deleteSuccess) {
            System.out.println("버스 정보가 성공적으로 삭제 되었습니다.");
        } else {
            System.out.println("삭제에 실패하였습니다.");
        }
    }
	
}
