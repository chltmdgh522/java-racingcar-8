package racingcar.domain.car.domain.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.domain.entity.Car;

public class CarRepository {

    public final Map<String, Car> carDB = new LinkedHashMap<>();


    public void save(Car car) {
        carDB.put(car.getId(), car);
    }


    public List<Car> findAll() {
        return new ArrayList<>(carDB.values());
    }


}
