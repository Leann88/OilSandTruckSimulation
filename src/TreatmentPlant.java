/*
 * By: Leann Labelle
 */
public class TreatmentPlant{

	private int numOfTreatedLoads=0;
	private int numLoads=0;
	private long treatmentTime;
	private long varTreatmentTime;
	private long treatTime;
	private String name;
	private SemTreatmentPlant stp= new SemTreatmentPlant(5);
	
	public TreatmentPlant(String n, long tt, long vtt){
		name=n;
		treatmentTime=tt;
		varTreatmentTime=vtt;
	}
	
	public SemTreatmentPlant getSemTreatmentPlant(){
		return stp;
	}
	public void treatLoad(){
		numLoads++;
		if((numLoads%5)==0){
			numOfTreatedLoads++;
			int addSub=(int) (Math.random()*2);
			if(addSub==0){
				treatTime = (long) (treatmentTime + Math.random()*varTreatmentTime);
			}else{
				treatTime = (long) (treatmentTime - Math.random()*varTreatmentTime);
			}
			//System.out.println(name + " is now treating the oil sand for " + treatTime);
			try {
				Thread.sleep(treatTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println(name +" is done treating the loads of oil sand");
			stp.V();
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getNumLoads(){
		return numLoads;
	}
	
	public int getNumLoadTreated(){
		return numOfTreatedLoads;
	}
	
}
//Treatment plants: Poisson Arrival time
//So serve on a first-come first serve basis
//First truck to arrive will be served by the first treatment plant while the next will be served by the second