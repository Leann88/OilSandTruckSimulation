/*
 * By: Leann Labelle
 */

public class Shovel {

	private long loadingTime;
	private long varLoadingTime;
	private long transportationTime;
	private long varTransporationTime;
	private SemShovel ss = new SemShovel(1);
	
	public Shovel(long ldt, long vlt, long tt, long vtt){
		loadingTime = ldt;
		varLoadingTime=vlt;
		transportationTime=tt;
		varTransporationTime=vtt;
	}
	
	public long travelTime(){
		int addSub=(int) (Math.random()*2);
		if(addSub==0){
			return (long) (transportationTime + Math.random()*varTransporationTime);
		}else{
			return (long) (transportationTime - Math.random()*varTransporationTime);
		}
			
	}
	
	public long loadingTime(){
		int addSub=(int) (Math.random()*2);
		if(addSub==0){
			return (long) (loadingTime + Math.random()*varLoadingTime);
		}else{
			return (long) (loadingTime - Math.random()*varLoadingTime);
		}
		
	}
	
	public SemShovel getSemShovel(){
		return ss;
	}
}
