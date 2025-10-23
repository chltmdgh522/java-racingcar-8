package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.domain.entity.Car;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import racingcar.global.config.ApplicationFactory;
import racingcar.global.config.ApplicationRunner;

public class Application {

    public static void main(String[] args) {
        ApplicationRunner ar = ApplicationFactory.createApplicationRunner();
        ar.run();
    }
}
