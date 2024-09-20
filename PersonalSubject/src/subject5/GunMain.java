package subject5;

import java.util.List;

public class GunMain {
    public static void main(String[] args) {
        
        GunDao gunDao = new JDBCGunDao();
        
        Gun newGun = new Gun("사격총", 50000, "사격용", 101);
        boolean insertSuccess = gunDao.insert(newGun);
        if (insertSuccess) {
            System.out.println("총기가 성공적으로 추가되었습니다!");
        } else {
            System.out.println("총기 추가에 실패했습니다.");
        }
       
        List<Gun> guns = gunDao.findAll(newGun);
        System.out.println("모든 총기 목록:");
        for (Gun gun : guns) {
            System.out.println("이름: " + gun.getName() + ", 가격: " + gun.getPrice() + ", 기능: " + gun.getFunction() + ", 총기 번호: " + gun.getGunNum());
        }
  
        int gunNumToFind = 101; 
        Gun foundGun = gunDao.find(gunNumToFind);
        if (foundGun != null) {
            System.out.println("찾은 총기:");
            System.out.println("이름: " + foundGun.getName() + ", 가격: " + foundGun.getPrice() + ", 기능: " + foundGun.getFunction() + ", 총기 번호: " + foundGun.getGunNum());
        } else {
            System.out.println("총기 번호 " + gunNumToFind + "에 해당하는 총기를 찾을 수 없습니다.");
        }
        
        Gun updatedGun = new Gun("번경된 총", 55000, "변경된 사격용", gunNumToFind);
        boolean updateSuccess = gunDao.update(updatedGun);
        if (updateSuccess) {
            System.out.println("총기 정보가 성공적으로 업데이트되었습니다!");
        } else {
            System.out.println("총기 정보 업데이트에 실패했습니다.");
        }

        boolean deleteSuccess = gunDao.delete(gunNumToFind);
        if (deleteSuccess) {
            System.out.println("총기가 성공적으로 삭제되었습니다!");
        } else {
            System.out.println("총기 삭제에 실패했습니다.");
        }
    }
}