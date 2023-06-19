import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user=new User();
        Computer computer=new Computer();
        computer.generateNumbers();
        int countTrys=1;
        while(true){
            String answer=user.inputAnswer();
            String resultStr=computer.calculateScore(answer);
            if(resultStr.equals("3S")){
                System.out.printf("%d번만에 맞혔습니다.",countTrys-1);
                return;
            }
            System.out.printf("%d번째 시도 : %s \n",countTrys++,resultStr);
        }
    }
}
    class Computer {
        private int[] numbers; // 외부에서 값을 변경하지 않게 하기위해, 캡슐화
        // 내부에서만 배열에 접근가능
        public String calculateScore(String input){
            int strikeCount=0, ballCount=0;
            if(input.equals(""+ this.numbers[0] + this.numbers[1] + this.numbers[2])){
                return "3S";
            }
            for(int i=0; i<input.length();i++) {
                char c = input.charAt(i);
                if (c - '0' == this.numbers[i]) {
                    strikeCount++;
                    continue;
                }
                for (int j : this.numbers) {
                    if (j == c - '0') {
                        ballCount++;
                    }
                }
            }
            return strikeCount+"S"+ballCount+"B";
        }
        // 랜덤 생성함수
        // 랜덤숫자 생성 및 반환
        public void generateNumbers() {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            while(list.size() < 3) {
                int num = random.nextInt(10);
                if(!list.contains(num)){
                    list.add(num);
                }
            }
            this.numbers = new int[3];
            for(int i=0; i<numbers.length; i++){
                numbers[i] = list.get(i);
            }
            System.out.println("생성된 숫자는"+ Arrays.toString(numbers) + " 입니다.");
        }
    }

    class User {
        public String inputAnswer() { // 유저가 값을 입력하는 메서드
            System.out.println("숫자를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            String answerString = "";
            answerString += sc.nextLine();
            return answerString;
        }
    }