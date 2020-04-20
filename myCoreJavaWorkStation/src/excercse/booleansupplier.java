package excercse;

import java.util.function.BooleanSupplier;

class booleansupplier {
	
	
	public boolean CompareProjectStatus(String expectedStatus){
		
		String status="Approved";
		return status.equals(expectedStatus);				
	}
	
	
	public void wait_till_status(){
		
		BooleanSupplier bs =  () ->CompareProjectStatus("Approved");
		booleansupplier.WaitforCondition(bs,5,"status change msg");
	}
	
	
	public static void WaitforCondition(BooleanSupplier condition,int minutes,String errormessage){
		int secondsBetweenRefresh=30;
		for(int numberOfTimesToWait = minutes*(60/secondsBetweenRefresh); numberOfTimesToWait>0; numberOfTimesToWait--){
			if(condition.getAsBoolean()){
				break;
			}
			
			try{
				
				Thread.sleep(secondsBetweenRefresh * 10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		String Message="errormessage";
		
	}

	public static void main(String[] args) {
		
		booleansupplier s = new booleansupplier();
		s.wait_till_status();
	}

}
