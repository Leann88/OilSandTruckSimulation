/*
 * By: Leann Labelle
 */
public class TreatmentFacility {

	private TreatmentPlant [] tp;
	private int aNum;
	int test =0;
	public TreatmentFacility(TreatmentPlant[] treatmentPlant) {
		tp = treatmentPlant;
		aNum= tp.length-1;
	}
//Used to assign trucks to next available treatment plant, round robin distribution
//	public int assignTreatmentPlant(){
//		if(aNum == tp.length-1){
//			aNum=0;
//			return aNum;
//		}else{
//			aNum++;
//			return aNum;
//		}
//	}
////	Used to test if assigning 5 trucks to first plant then 5 trucks to the second's efficiency
	public int assignTreatmentPlant(){
		if(test < 5){
			test ++;
			return 0;
		}else{
			test ++;
			if(test == 9){
				test = 0;
			}
			return 1;
		}
	}
//	
	public TreatmentPlant getTreatmentPlant(int i){
		return tp[i];
	}
	
}
