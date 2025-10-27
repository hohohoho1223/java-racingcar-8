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