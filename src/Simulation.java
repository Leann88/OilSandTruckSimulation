/*
 * By: Leann Labelle
 */

import java.util.ArrayList;


public class Simulation {

	private double totalShovelWaitTimeShovel1=0;
	private double totalShovelWaitTimeShovel2=0;   
	private double totalUnloadingWaitTime = 0;
	
	private TreatmentPlant tp1 = new TreatmentPlant("1",6000, 1000);
	private TreatmentPlant tp2 = new TreatmentPlant("2",6000, 1000);
	private TreatmentPlant [] tf = {tp1, tp2}; 
	private TreatmentFacility treatmentFacility=new TreatmentFacility(tf);; 
	private Shovel shovel = new Shovel(1000, 500, 2000, 500);
	private Shovel shovel2 = new Shovel(1000, 500, 4000, 1000);
	
    private Truck truck = new Truck(shovel,"1",treatmentFacility);
    private Truck truck2= new Truck(shovel, "2",treatmentFacility);
    private Truck truck3 = new Truck(shovel, "3", treatmentFacility);
    private Truck truck4 = new Truck(shovel, "4", treatmentFacility);
    private Truck truck5 = new Truck(shovel2, "5", treatmentFacility);
    private Truck truck6 = new Truck(shovel2, "6", treatmentFacility);
    private Truck truck7 = new Truck(shovel2, "7", treatmentFacility);
    private Truck truck8 = new Truck(shovel2, "8", treatmentFacility);
    
    private long startTime;
    private long endTime;
 
    private double totalTimesWaitingShovel1;
    private double totalTimesWaitingShovel2;
    private double totalTimesWaitedUnloading;
	
    public void simMethod(){
	   
    	Truck [] allTrucks = {truck, truck2, truck3, truck4, truck5, truck6, truck7, truck8};
	    truck.start();
	    truck2.start();
	    truck3.start();
	    truck4.start();
	    truck5.start();
	    truck6.start();
	    truck7.start();
	    truck8.start();
	    
	    startTime = System.currentTimeMillis();
	    //Allow the simulations to last for 60000ms where 100ms = 1min so 10 hours
	    while( (System.currentTimeMillis() - startTime) < 60000 ){
			try{
				Thread.sleep(100);
			}catch(Exception e){}
		}
	    
	   for(int i = 0; i < allTrucks.length; i++){
		   allTrucks[i].stop();
	   }
	   
	   
	   //Determines total wait times and the number of time waited
	    for(int i = 0; i < allTrucks.length; i++){
	    	if(allTrucks[i].getShovel() == shovel){
		    	for(int j = 0; j < allTrucks[i].shovelTimes().size(); j++ ){
			    	totalShovelWaitTimeShovel1 = totalShovelWaitTimeShovel1 + Double.parseDouble(allTrucks[i].shovelTimes().get(j).toString());
			    }
		    	totalTimesWaitingShovel1 = totalTimesWaitingShovel1 + allTrucks[i].shovelTimes().size();
	    	}else{
	    		for(int j = 0; j < allTrucks[i].shovelTimes().size(); j++ ){
			    	totalShovelWaitTimeShovel2 = totalShovelWaitTimeShovel2 + Double.parseDouble(allTrucks[i].shovelTimes().get(j).toString());
	    		}
	    		totalTimesWaitingShovel2 = totalTimesWaitingShovel2 + allTrucks[i].shovelTimes().size();
	    	}
	    	
	    }
	    //add value to count number of times waited
	    for(int i = 0; i < allTrucks.length; i++){
	    	for(int j = 0; j < allTrucks[i].unloadTimes().size(); j++ ){
	    		totalUnloadingWaitTime = totalUnloadingWaitTime + Double.parseDouble(allTrucks[i].unloadTimes().get(j).toString());
		    }
	    	totalTimesWaitedUnloading = totalTimesWaitedUnloading + allTrucks[i].unloadTimes().size();
	    }
	    
	    System.out.println(totalTimesWaitedUnloading + "  " + totalUnloadingWaitTime);
	    endTime = System.currentTimeMillis();
	    System.out.println("Total Shovel Wait Time: " + (double)((totalShovelWaitTimeShovel1 + totalShovelWaitTimeShovel2)/100.0) +"min");
	    System.out.println("Total Unloading Wait Time: " + (double) (totalUnloadingWaitTime/100.0) + "min");
	    System.out.println("Total Number of loads unloaded: " + getTotalNumLoads());
	    System.out.println("Total Number of Treated Loads of 5: " + getTotalNumLoadsTreated());
	    System.out.println("Total time: " + (endTime-startTime) );
//	    System.out.println("Average wait time at shovel 1: " + getAvgWaitTimeShovel1() + " hours");
//	    System.out.println("Average wait time at shovel 2: " + getAvgWaitTimeShovel2() + " hours");
//	    System.out.println("Average wait time at Treatment Plant: " + getAvgWaitTimeTreatmentPlant() + " hours");
	    System.out.println();
	}
	
	public double getShovelWaitTime(){
		return totalShovelWaitTimeShovel1;
	}
	
	public double getUnloadingWaitTime(){
		return totalUnloadingWaitTime;
	}
	
	public int getTotalNumLoads(){
		return (tp1.getNumLoads() + tp2.getNumLoads());
	}
	
	public double getTotalNumLoadsPerHour(){
		return (double) getTotalNumLoads()/((endTime-startTime)/6000);
	}
	
	public int getTotalNumLoadsTreated(){
		return (tp1.getNumLoadTreated() + tp2.getNumLoadTreated());
	}
	
	public double getLoadsTreatedPerHour(){
		return (double) getTotalNumLoadsTreated()/((endTime-startTime)/6000);
	}
	
	public double getLoadsdPerHour(){
		return (double) getTotalNumLoads()/((endTime-startTime)/6000);
	}
	
	public double getAvgWaitTimeTreatmentPlant(){
		return (double) (totalUnloadingWaitTime/6000.00)/totalTimesWaitedUnloading;
	}
	
	public double getAvgWaitTimeShovel1(){
		return (double) (totalShovelWaitTimeShovel1/6000.00)/totalTimesWaitingShovel1;
	}
	
	public double getAvgWaitTimeShovel2(){
		return (double) (totalShovelWaitTimeShovel2/6000.00)/totalTimesWaitingShovel2;
	}
}
