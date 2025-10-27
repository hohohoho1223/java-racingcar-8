package racingcar.domain;

public class Car {
    private static final int moveStandard = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name; // 각각의 Car 객체가 자기 자신만의 이름을 가짐
    }

    /**
     * 자동차 이름의 유효성을 검증한다.
     * 이름은 null이 아니고, 공백 사용불가 및 5자를 초과할 수 없다.
     */
    private void validateName(String name) {
        // null 입력 검증
        if (name == null) {
            throw new IllegalArgumentException("[시스템 오류] Car 객체 생성 시 name이 null입니다.");
        }

        // 공백 문자열 또는 띄어쓰기만 있는 경우 검증
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다! 다시 시도해 주세요.");
        }

        // 5자 초과 검증
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