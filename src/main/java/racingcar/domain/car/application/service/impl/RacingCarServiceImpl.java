package racingcar.domain.car.application.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.car.application.service.CarDataService;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;
import racingcar.domain.car.presentation.view.OutputView;

public class RacingCarServiceImpl implements RacingCarService {

    private final CarDataService carDataService;

    public RacingCarServiceImpl(CarDataService carDataService) {
        this.carDataService = carDataService;
    }

    @Override
    public void setupRace(List<Car> cars) {
        carDataService.carSave(cars);
    }

    @Override
    public void playRace(long attemptCount) {
        while (attemptCount-- > 0) {
            moveCars();
            OutputView.printRaceStatus(carDataService.carFindAll());
        }
    }

    @Override
    public List<Car> getCars() {
        return carDataService.carFindAll();
    }


    /**
     * 각 자동차의 랜덤 이동 거리 4 이상이면 한 칸씩 전진 아니면 정지
     */
    private void moveCars() {
        for (Car car : carDataService.carFindAll()) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.move();
            }
        }
    }


}
