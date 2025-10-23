package racingcar.domain.car.application.service;

import java.util.List;
import racingcar.domain.car.domain.entity.Car;

public interface CarService {


    void startRace(long attemptCount);

    void carSave(List<Car> cars);

    List<Car> carFindAll();

    void validateInput();
}
