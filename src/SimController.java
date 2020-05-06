import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimController {
	private SimModel sm;
	private SimView sv;
	public int goFlag = 0;
	int arrMin;
	int arrMax;
	int servMin;
	int servMax;
	int noQueues;
	int simInterval;
	int timeStep;
	public SimController(SimModel sm, SimView sv) {
		this.sm = sm;
		this.sv = sv;
		sv.addGoListener(new GoListener());
	}
	
	public void setGoFlag(int f) {
		this.goFlag = f;
	}
	class GoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
			arrMin = sv.getArrMin();
			arrMax = sv.getArrMax();
			servMin = sv.getServMin();
			servMax = sv.getServMax();
			noQueues = sv.getNoQueues();
			simInterval = sv.getSimInterval();
			timeStep = sv.getTimeStep();
			} catch(NumberFormatException ex) {
				System.out.println("Wrong");
				return;
			}
			RTSView rts = new RTSView(sm);
			sm.simulate(arrMin, arrMax, servMin, servMax, noQueues, simInterval, timeStep);
			sv.remove(sv.s_goButton);
		}
	}
}
