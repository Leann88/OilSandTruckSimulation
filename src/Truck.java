/*
 * By: Leann Labelle
 */
import java.util.ArrayList;

public class Truck extends Thread{
	
	  private Shovel shovel;
	  private TreatmentFacility tf;
	  private String name;
	  private ArrayList<Long> shovelWaitTimes = new ArrayList<Long>();
	  private ArrayList<Long> unloadingWaitTimes = new ArrayList<Long>();
	  private long startTime;
	  private long endTime;

	  public Truck(Shovel s, String n, TreatmentFacility treatmentFacility) {
		  shovel=s;
		  tf=treatmentFacility;
		  name=n;
	  }

	  public ArrayList<Long> shovelTimes(){
		  return shovelWaitTimes;
	  }
	  
	  public ArrayList<Long> unloadTimes(){
		  return unloadingWaitTimes;
	  }
      
	  public void run() {
	    for(;;){
	    	  long travelTime = shovel.travelTime();
			  //System.out.println(name +" is travelling " + travelTime + " to get to a shovel");
			  try {
				Thread.sleep(travelTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  //Determine shovel wait time
			  startTime = System.currentTimeMillis();
			  shovel.getSemShovel().P();
			  endTime = System.currentTimeMillis();
			  shovelWaitTimes.add(endTime - startTime);
			  
			  long loadingTime= shovel.loadingTime();
			  //System.out.println(name + " is loading oil for " + loadingTime);
			  try {
					Thread.sleep(loadingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			  shovel.getSemShovel().V();
			  
			  travelTime = shovel.travelTime();
			  //System.out.println(name +" is travelling " + travelTime + " to get to treatment facility");
			  try {
				Thread.sleep(travelTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			  //System.out.println(name + " has arrived at the Treatment Facility");
			  int tpNum = tf.assignTreatmentPlant();
			  TreatmentPlant tp = tf.getTreatmentPlant(tpNum);
			  //System.out.println(name + " has been assigned " + tp.getName());
			  
			  startTime = System.currentTimeMillis();
			  tp.getSemTreatmentPlant().P();
			  endTime = System.currentTimeMillis();
			  unloadingWaitTimes.add(endTime - startTime);
			  
			  //System.out.println(name + " is unloading the oil sand at " + tp.getName());
			  tp.treatLoad();

	    }
	}

	public Shovel getShovel() {
		return shovel;
	}
}

