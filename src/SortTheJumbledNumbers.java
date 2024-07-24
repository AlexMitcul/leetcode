import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTheJumbledNumbers {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> convertedNumbers = new HashMap<>();

        int index = 0;
        for (int num : nums) {
            int convertedNum = 0;
            if (num == 0) convertedNum = mapping[0];
            int degree = 1;
            while (num > 0) {
                convertedNum += (mapping[num % 10]) * degree;
                degree *= 10;
                num /= 10;
            }
            System.out.println(convertedNum);
            if (!convertedNumbers.containsKey(convertedNum)) {
                convertedNumbers.put(convertedNum, new ArrayList<>());
                convertedNumbers.get(convertedNum).add(index);
            } else {
                convertedNumbers.get(convertedNum).add(index);
            }
            index++;
        }

        List<Integer> order = convertedNumbers.keySet().stream().sorted().toList();
        int[] result = new int[nums.length];
        int indexToPut = 0;
        for (int key : order) {
            var indexes = convertedNumbers.get(key);
            for (int index2 : indexes) {
                result[indexToPut] = nums[index2];
                indexToPut++;
            }
        }

        return result;
    }

}