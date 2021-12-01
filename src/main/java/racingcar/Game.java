package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class Game {
    private String input;
    public String[] carNames;
    public int times;

    public Game() {

    }

    private void Input() {
        input = Console.readLine();
    }

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        boolean checking = false;
        while (!checking) {
            Input();
            checking = checkCars();
        }
        checking = false;
        while (!checking) {
            Input();
            checking = checkTimes();
        }

    }

    private boolean checkCars() {
        boolean checking = true;
        try {
            Exception e = new Exception();
            rightInput();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            checking = false;
        }
        return checking;
    }

    private void rightInput() throws IllegalArgumentException {
        carNames = input.split(",");
        for (int i=0;i<carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return;
    }

    private boolean checkTimes() {
        boolean checking = true;
        try {
            Exception e = new Exception();
            rightInputTimes();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            checking = false;
        }
        return checking;
    }

    private void rightInputTimes() throws IllegalArgumentException {
        char temp;
        for (int i=0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (Character.isDigit(temp) == false) {
                throw new IllegalArgumentException();
            }
        }
        times = Integer.parseInt(input);
        if (times < 0) {
            throw new IllegalArgumentException();
        }
    }


}
