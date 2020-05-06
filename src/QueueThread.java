import java.util.Date;
import java.util.TimerTask;

public class QueueThread implements Runnable {
	Thread t;
	int timeLimit;
	Queue q;
	int currTime;
	Client nextClient;
	int simStep = 1;
	int timeStep;
	
	public QueueThread(Queue q, int timeLimit, int timeStep) {
		this.q = q;
		this.timeLimit = timeLimit;
		currTime = 0;
		this.timeStep = timeStep;
		t = new Thread(this);
		t.start();
		TimerTask task = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on: " + new Date() + "n" +"Thread's name: " + Thread.currentThread().getName());
	        }
		};
	}
	
	public String toString() {
		String s = new String();
		if(this.q.headClient != null)
		s += "| " + this.q.headClient.arrivalTime + " | ";
		s += this.q.toString();
		return s;
	}
	public void run() {
		
		synchronized(t) {
		while(currTime < this.timeLimit) {
			//System.out.print("In queue " + this.q.queueNumber + " : ");
		if (q.headClient == null) {
			q.headClient = this.q.extract();
			//System.out.println("Initialised with client " + q.headClient.arrivalTime);
		}
		else if(this.q.isEmpty() && q.headClient.isDone()) {
			//System.out.println("Queue is done");
			q.headClient = null;
			break;
		}
		else if (q.headClient.isDone()) {
			//System.out.println("Finished with client " + q.headClient.arrivalTime);
			q.headClient = this.q.extract();
		}
		else {
		q.headClient.makeProgress();
		//System.out.println("Working on client " + q.headClient.arrivalTime);}
		}
		currTime ++;
		if(this.nextClient != null) {
			this.q.addClient(this.nextClient);
			if(this.q.headClient == null)
				this.q.headClient = this.q.extract();
			this.nextClient = null;
			}
		try {
		Thread.sleep(timeStep);
		simStep ++;
		}catch(InterruptedException e)
		{
			System.out.println("INTERRUPTED");
		}
		}
		}
	}
	
	public void setNextClient(Client c) {
		this.nextClient = c;
	}
}
