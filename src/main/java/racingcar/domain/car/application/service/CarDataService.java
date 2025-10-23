package racingcar.domain.car.application.service;

import java.util.List;
import racingcar.domain.car.domain.entity.Car;

public interface CarDataService {

    void carSave(List<Car> cars);

    List<Car> carFindAll();
}
