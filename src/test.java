
public class test {
	public static void main(String[] args) {
		SimView sv = new SimView();
		SimModel sm = new SimModel(sv);
		SimController sc = new SimController(sm, sv);
		while(sc.goFlag == 0) {
			System.out.print(".");
		}
		while(true) {
		int arrMin = sv.getArrMin();
		int arrMax = sv.getArrMax();
		int servMin = sv.getServMin();
		int servMax = sv.getServMax();
		int noQueues = sv.getNoQueues();
		int simInterval = sv.getSimInterval();
		int timeStep = sv.getTimeStep();
		sm.simulate(arrMin, arrMax, servMin, servMax, noQueues, simInterval, timeStep);
		sc.goFlag = 0;
		sm.reset();
		break;
		}
	}
}
