package racingcar.domain.car.domain.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.domain.entity.Car;

/**
 * 자동차 정보를 관리하는 메모리 기반 저장소 클래스.
 * <p>
 * 자동차 등록 및 전체 조회 기능을 제공한다.
 */
public class CarRepository {

    /** 자동차 데이터를 저장하는 Map (ID 기준으로 관리) */
    private final Map<String, Car> carDB = new LinkedHashMap<>();

    /**
     * 자동차 리스트를 저장한다.
     * <p>
     * 각 자동차의 ID를 key로 하여 Map에 등록한다.
     *
     * @param cars 저장할 자동차 리스트
     */
    public void save(List<Car> cars) {
        for (Car car : cars) {
            carDB.put(car.getId(), car);
        }
    }

    /**
     * 저장된 모든 자동차 정보를 반환한다.
     *
     * @return 자동차 리스트
     */
    public List<Car> findAll() {
        return new ArrayList<>(carDB.values());
    }
}
