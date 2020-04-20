package testDemo;
public class TwoSummy {
    public static int[] findTwoSum(int[] list, int sum) {
        int[] result = new int[2];
        for(int a = 0; a < list.length; a++){
        for(int ba = a; ba < list.length; ba++){
            if((list[a] + list[ba]) == sum) {
            	result[0] = a;
            	result[1] = ba;
            	return result;
            }
        }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}