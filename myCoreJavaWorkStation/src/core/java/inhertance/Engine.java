package core.java.inhertance;

class Engine extends Car {
	public static Engine getEngine() {
		return new Engine();
	}
	
	String getFin() {
		return "Fin/Vin";
	}

	public static void main(String[] args) {
		System.out.println("Car  " + Car.getCar());
		System.out.println("Engine  " + Engine.getEngine());
	}
}
