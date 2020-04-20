package testDemo;

public class Shipping {
	public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
		int smallP = 0;
		int largP = 0;
		
		if (items > 5) {
			smallP = items % 5;
			if(items / 5 > availableLargePackages)
			{
				largP = items / 5;
			}else {
				largP = availableLargePackages;
			}
			
		}
		if (5 * availableLargePackages == items / 5) {

			largP = items / 5;
		}
		return largP + smallP;
	}

	public static void main(String[] args) {
		System.out.println(minimalNumberOfPackages(16, 2, 10));
	}
}