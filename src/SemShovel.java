/*
 * By: Leann Labelle
 */
public class SemShovel {

	private int value;
	public SemShovel() {
	      value = 0;
	   }
	   
	   public SemShovel(int v) {
	      value = v;
	   }
	   
	   public synchronized void P() { // called before accessing the resource
	      while (value <= 0) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { }
	      }
	      value --;
	   }
	   
	   public synchronized void V() { //resource not needed
	      ++value;
	      notify();
	   }
}
