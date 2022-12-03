package arab;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        arabian.Converter converter = new arabian.Converter();
        String[] math = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

        int actionIndex=-1;
        for (int i = 0; i < math.length; i++) {
            if(exp.contains(math[i])){
                actionIndex = i;
                break;
            }
        }

        if(actionIndex==-1){
            System.out.println("Вырожение введено не верно");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);

        if(converter.isRom(data[0]) == converter.isRom(data[1])){
            int a,b;

            //конвертep
            boolean isRom = converter.isRom(data[0]);
            if(isRom){

                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            if (a < 0){
                System.out.println("Вы должны ввести цифру больше нуля!");
            }else if (a > 10){
                System.out.println("Вы должны ввести цифру меньше или равную десяти!");
            }else if (b > 10){
                System.out.println("Вы должны ввести цифру меньше или равную десяти!");
            }else{
                if (math[actionIndex] == "+") {
                    result = a + b;
                    if (isRom) {
                        System.out.println(converter.intToRom(result));
                    } else {
                        System.out.println(result);
                    }
                } else if (math[actionIndex] == "-") {
                    result = a - b;
                    if (isRom) {
                        System.out.println(converter.intToRom(result));
                    } else {
                        System.out.println(result);
                    }
                } else if (math[actionIndex] == "*") {
                    result = a * b;
                    if (isRom) {
                        System.out.println(converter.intToRom(result));
                    } else {
                        System.out.println(result);
                    }
                } else if (math[actionIndex] == "/") {
                    result = a / b;
                    if (isRom) {
                        System.out.println(converter.intToRom(result));
                    } else {
                        System.out.println(result);
                    }
                }
            }



        } else{
            System.out.println("Числа должны быть в одной форме!");
        }

    }
}