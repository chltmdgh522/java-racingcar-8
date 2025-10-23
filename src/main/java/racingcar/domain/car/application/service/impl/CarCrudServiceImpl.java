package racingcar.domain.car.application.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.car.application.service.CarCrudService;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;

public class CarCrudServiceImpl implements CarCrudService {

    private final CarRepository carRepository;

    public CarCrudServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void carSave(List<Car> cars) {
        for (Car car : cars) {
            carRepository.save(car);
        }

    }

    @Override
    public List<Car> carFindAll() {
        return carRepository.findAll();
    }

}
