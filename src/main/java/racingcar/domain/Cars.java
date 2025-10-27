/**
 * 일급 컬렉션(First-Class Collection) Cars는 List&lt;Car&gt;를 감싸며, 자동차 컬렉션에 대한 모든 도메인 로직을 책임짐.
 * SRP(단일 책임 원칙)를 지키기 위해 컬렉션 관련 행위(예: 이동, 우승자 계산)를 외부가 아닌 Cars 내부에서만 처리함.
 * 내부 리스트는 외부에 직접 노출되지 않아 캡슐화가 보장되며, 불변성을 위해 복사본을 반환함.
 * Cars를 통해 자동차 목록의 관리와 관련된 도메인 규칙을 한 곳에 집중시켜, 변경에 유연하도록 설계함.
 */
package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> findWinners() {
        int longPosition =cars.stream().
                mapToInt(Car::getPosition)
                .max().
                orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == longPosition)
                .map(Car::getName).
                collect(Collectors.toList());
    }
}