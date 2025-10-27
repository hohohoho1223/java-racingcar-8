package racingcar.domain;

public class Car {
    private static final int moveStandard = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name; // 각각의 Car 객체가 자기 자신만의 이름을 가짐
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름을 입력해주십시오!");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다! 다시 시도해 주세요.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다! 다시 시도해 주세요.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= moveStandard) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }






}