package subject3;

import java.util.List;

public interface TaxiDao {

	boolean insert(Taxi taxi);
	List<Taxi> findAll();
	Taxi find(int taxiNum);
	boolean update(Taxi taxi);
	boolean delete(int taxiNum);
}
