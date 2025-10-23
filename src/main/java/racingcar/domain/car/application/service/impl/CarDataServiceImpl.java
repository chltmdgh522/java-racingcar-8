package racingcar.domain.car.application.service.impl;

import java.util.List;
import racingcar.domain.car.application.service.CarDataService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;

public class CarDataServiceImpl implements CarDataService {

    private final CarRepository carRepository;

    public CarDataServiceImpl(CarRepository carRepository) {
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
