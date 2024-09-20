package subject1;

import java.util.List;

public interface BusDao {
	
	boolean insert(Bus bus);
	List<Bus> findAll();
	Bus find(String busNum);
	boolean update(Bus bus);
	boolean delete(String busNum);		
	
}
	

