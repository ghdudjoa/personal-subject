package subject3;
import java.util.List;

public class TaxiMain {
    public static void main(String[] args) {
        
        TaxiDao taxiDao = new JDBCTaxiDao();

   
        Taxi newTaxi = new Taxi("카카오 택시", 7777, "세단");
        boolean insertSuccess = taxiDao.insert(newTaxi);
        if (insertSuccess) {
            System.out.println("성공적으로 생성되었습니다.");
        } else {
            System.out.println("잘못된 접근입니다.");
        }

        List<Taxi> taxis = taxiDao.findAll();
        System.out.println("모든 택시 정보를 출력합니다:");
        for (Taxi taxi : taxis) {
            System.out.println("택시 명: " + taxi.getName() + ", 택시 번호: " + taxi.getTaxiNum() + ", 차종: " + taxi.getType());
        }

        
        int taxiNumToFind = 7777; 
        Taxi foundTaxi = taxiDao.find(taxiNumToFind);
        if (foundTaxi != null) {
            System.out.println("찾은 택시:");
            System.out.println("택시 명: " + foundTaxi.getName() + ", 택시 번호: " + foundTaxi.getTaxiNum() + ", 차종: " + foundTaxi.getType());
        } else {
            System.out.println("잘못된 접근" + taxiNumToFind);
        }

      
        Taxi updatedTaxi = new Taxi("Uber", 1111, "SUV");
        boolean updateSuccess = taxiDao.update(updatedTaxi);
        if (updateSuccess) {
            System.out.println("성공적으로 변경 되었습니다!");
        } else {
            System.out.println("변경에 실패하였습니다.");
        }

        // 5. Taxi 삭제
        boolean deleteSuccess = taxiDao.delete(taxiNumToFind);
        if (deleteSuccess) {
            System.out.println("성공적으로 삭제되었습니다!");
        } else {
            System.out.println("삭제에 실패하였습니다.");
        }
    }
}