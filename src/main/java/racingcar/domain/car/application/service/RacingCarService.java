package racingcar.domain.car.application.service;

import java.util.List;
import racingcar.domain.car.domain.entity.Car;

public interface RacingCarService {


    void startRace(long attemptCount);


    void validateInput();
}
