package excercse;

public class Demo {

	static DataModifer dataModifer = null;

	public static void main(String... a) {// TODO
		int i = 10;
		dataModifer = new DataModifer();
		dataModifer.val = 500;
		System.out.println(" dataModifer b4 call " + dataModifer.val);
//		i = updater(i);
		updater(i);
		System.out.println(" updater " + i);
		dataModifer.updateMe(dataModifer);
		System.out.println(" dataModifer af4 call " + dataModifer.val);
	}

	public static int updater(int r) {
		return ++r;
	}
}

class DataModifer {
	public int val = 50;

	public DataModifer updateMe(DataModifer x) {
		x.val = this.val;
		return x;
	}

}
