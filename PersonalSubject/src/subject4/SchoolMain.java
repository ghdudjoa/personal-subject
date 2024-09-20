package subject4;

import java.util.List;

public class SchoolMain {
    public static void main(String[] args) {
        
        SchoolDao schoolDao = new JDBCSchoolDao();

       
        School newSchool = new School("안녕초등학교", 1, 3.5, 11);
        boolean insertSuccess = schoolDao.insert(newSchool);
        if (insertSuccess) {
            System.out.println("학교가 성공적으로 추가되었습니다!");
        } else {
            System.out.println("학교 추가에 실패했습니다.");
        }

       
        List<School> schools = schoolDao.findAll();
        System.out.println("모든 학교 목록:");
        for (School school : schools) {
            System.out.println("이름: " + school.getname() + ", 반: " + school.getClassNum() + ", 학년: " + school.getGrade() + ", 학생 수: " + school.getStudentNum());
        }

     
        int studentNumToFind = 11; // 찾고자 하는 학생 번호
        School foundSchool = schoolDao.find(studentNumToFind);
        if (foundSchool != null) {
            System.out.println("찾은 학교:");
            System.out.println("이름: " + foundSchool.getname() + ", 반: " + foundSchool.getClassNum() + ", 학년: " + foundSchool.getGrade() + ", 학생 수: " + foundSchool.getStudentNum());
        } else {
            System.out.println("학생 번호 " + studentNumToFind + "에 해당하는 학교를 찾을 수 없습니다.");
        }

       
        School updatedSchool = new School("업데이트된 서울초등학교", 1, 4.0, 1001);
        boolean updateSuccess = schoolDao.update(updatedSchool);
        if (updateSuccess) {
            System.out.println("학교 정보가 성공적으로 업데이트되었습니다!");
        } else {
            System.out.println("학교 정보 업데이트에 실패했습니다.");
        }

       
        boolean deleteSuccess = schoolDao.delete(studentNumToFind);
        if (deleteSuccess) {
            System.out.println("학교가 성공적으로 삭제되었습니다!");
        } else {
            System.out.println("삭제에 실패했습니다.");
        }
    }
}
