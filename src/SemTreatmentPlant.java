/*
 * By: Leann Labelle
 */
public class SemTreatmentPlant {
	private int value;
	private int restoreV;
	public SemTreatmentPlant() {
	      value = 0;
	   }
	   
	   public SemTreatmentPlant(int v) {
	      value = v;
	      restoreV=v;
	   }
	   
	   public synchronized void P() { 
	      while (value <= 0) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { }
	      }
	      
	      value --;
	   }
	   
	   public synchronized void V() { 
	      value=restoreV;
	      notify();
	   }
	  
}
