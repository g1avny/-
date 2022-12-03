package arabian;

import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romKeyMap = new TreeMap<>();

    TreeMap<Integer, String> arabnKeyMap = new TreeMap<>();


    public Converter() {
        romKeyMap.put('I', 1);
        romKeyMap.put('V', 5);
        romKeyMap.put('X', 10);
        romKeyMap.put('L', 50);
        romKeyMap.put('C', 100);
        romKeyMap.put('D', 500);
        romKeyMap.put('M', 1000);




        arabnKeyMap.put(1000, "M");
        arabnKeyMap.put(900, "CM");
        arabnKeyMap.put(500, "D");
        arabnKeyMap.put(400, "CD");
        arabnKeyMap.put(100, "C");
        arabnKeyMap.put(90, "XC");
        arabnKeyMap.put(50, "L");
        arabnKeyMap.put(40, "XL");
        arabnKeyMap.put(10, "X");
        arabnKeyMap.put(9, "IX");
        arabnKeyMap.put(5, "V");
        arabnKeyMap.put(4, "IV");
        arabnKeyMap.put(1, "I");



    }


    public boolean isRom(String number){
        return romKeyMap.containsKey(number.charAt(0));
    }

    public String intToRom(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabnKeyMap.floorKey(number);
            roman += arabnKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;


    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romKeyMap.get(arr[i]);

            if (arabian < romKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;

    }

}