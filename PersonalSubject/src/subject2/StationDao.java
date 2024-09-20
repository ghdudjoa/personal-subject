package subject2;

import java.util.List;

public interface StationDao {

	boolean insert(Station station);
	List<Station> findAll();
	Station find(String stNum);
	boolean update(Station station);
	boolean delete(String stNum);
	
}
