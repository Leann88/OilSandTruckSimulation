/*
 * By: Leann Labelle
 */
public class MainSimulation2 {

	public static void main(String [] args){
		System.out.println("MainSimulation 2: 1 Trucks added to each shovel");
		Simulation sim1 = new Simulation();
		Simulation sim2 = new Simulation();
		Simulation sim3 = new Simulation();
		Simulation sim4 = new Simulation();
		double [] avgTreated = new double [4];
		double [] avgLoad = new double [4];
		System.out.println("Simulation 1");
		sim1.simMethod();
		System.out.println("Simulation 2");
		sim2.simMethod();
		System.out.println("Simulation 3");
		sim3.simMethod();
		System.out.println("Simulation 4");
		sim4.simMethod();
		//Finding average number of loads per hour
		avgLoad[0] = sim1.getTotalNumLoadsPerHour();
		avgLoad[1] = sim2.getTotalNumLoadsPerHour();
		avgLoad[2] = sim3.getTotalNumLoadsPerHour();
		avgLoad[3] = sim4.getTotalNumLoadsPerHour();
		double avgL= (avgLoad[0] + avgLoad[1] + avgLoad [2] + avgLoad [3])/4; 
		double stdL = 0;
		for(int i =0; i < avgLoad.length; i++){
			stdL= stdL + Math.pow((avgLoad[i] - avgL), 2.0);
		}
		stdL = Math.sqrt(stdL/3.0);
		double seL = stdL/Math.sqrt(4.0);
		
		//Finding average number of treated loads per hour
		avgTreated[0] = sim1.getLoadsTreatedPerHour();
		avgTreated[1] = sim2.getLoadsTreatedPerHour();
		avgTreated[2] = sim3.getLoadsTreatedPerHour(); 
		avgTreated[3] = sim4.getLoadsTreatedPerHour();
		double avgt= (avgTreated[0] + avgTreated[1] + avgTreated [2] + avgTreated [3])/4; 
		double stdt = 0;
		for(int i =0; i < avgTreated.length; i++){
			stdt= stdt + Math.pow((avgTreated[i] - avgt), 2.0);
		}
		//need avg num truck loads
		stdt = Math.sqrt(stdt/3.0);
		double set = stdt/Math.sqrt(4.0);
		
		double avgShovel1 = (sim1.getAvgWaitTimeShovel1() + sim2.getAvgWaitTimeShovel1() + sim3.getAvgWaitTimeShovel1() + sim4.getAvgWaitTimeShovel1())/4;
		double avgShovel2 = (sim1.getAvgWaitTimeShovel2() + sim2.getAvgWaitTimeShovel2() + sim3.getAvgWaitTimeShovel2() + sim4.getAvgWaitTimeShovel2())/4;
		double avgTreatmentPlant = (sim1.getAvgWaitTimeTreatmentPlant() + sim2.getAvgWaitTimeTreatmentPlant() + sim3.getAvgWaitTimeTreatmentPlant() + sim4.getAvgWaitTimeTreatmentPlant())/4;
		
		System.out.println();
		System.out.println("Average number of Loads: " + avgL + " per hour");
		System.out.println("Standard deviation of Load: "+ stdL);
		System.out.println("Standard error of Load: "+ seL);
		System.out.println();
		System.out.println("Average Treatment of 5 loads: "+ avgt +" per hour");
		System.out.println("Standard deviation of Treatment: "+ stdt);
		System.out.println("Standard error of Treatment: "+ set);
		System.out.println();
	    System.out.println("Average wait time at shovel 1: " + avgShovel1 + " hours");
	    System.out.println("Average wait time at shovel 2: " + avgShovel2 + " hours");
	    System.out.println("Average wait time at Treatment Plant: " + avgTreatmentPlant + " hours");
		
		
	}
}
