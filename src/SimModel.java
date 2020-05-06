import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimModel {
	
	static ArrayList <QueueThread> threads;
	SimView sv;

	public SimModel(SimView sv) {
		this.sv = sv;
		threads = new ArrayList <QueueThread> ();
	}
	
	
	
	public void reset() {
		threads = new ArrayList <QueueThread> ();
	}
	
	public void simulate(int arrMin, int arrMax, int servMin, int servMax, int noQueues, int simInterval, int timeStep) {
		
		Thread t = new Thread();
		int i = 0;/*
		while(i < noQueues) {
			threads.add(new QueueThread(new Queue(i), simInterval, timeStep));
			i ++;
		}*/
		
		ExecutorService executor = Executors.newFixedThreadPool(noQueues);
		for(int j = 0; j < noQueues; j ++) {
			Runnable queue = new QueueThread(new Queue(j+1), simInterval, timeStep);
			executor.execute(queue);
		}
		executor.shutdown();
		Random r = new Random();
		synchronized(threads) {
		while(true)
		{
			try {
				Thread.sleep(timeStep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(SimModel.threads.get(0).currTime == simInterval) {
				System.out.println("BREAK");
				break;
			}
			String s = new String();
			Iterator <QueueThread> it = threads.iterator();
			QueueThread currThread;
			while(it.hasNext())
			{
				currThread = it.next();
				//if(!currThread.q.isEmpty())
				s += currThread.toString() + "\n";
			}
			int j = 0;
			int min = 32767;
			int newMin;
			int minPos = 0;
			sv.setTextArea(s);
			sv.setSimStep(threads.get(0).simStep);
			int rand = r.nextInt(100);
			if(rand < ((float)arrMin/(float)arrMax) * 100)
				{
				it = threads.iterator();
				it = threads.iterator();
				while(it.hasNext()) {
					if((newMin = it.next().q.length) < min) {
						min = newMin;
						minPos = j;
					}
					j ++;
				}
				Client newClient = new Client(r.nextInt(arrMax - arrMin) + arrMin, r.nextInt(servMax - servMin) + servMin);
				threads.get(minPos).setNextClient(newClient);
				}
			else threads.get(minPos).setNextClient(null);
		}
		}
	}
	/*
	public String getState() {
		String s = new String();
		Iterator <QueueThread> it = threads.iterator();
		QueueThread currThread;
		while(it.hasNext())
		{
			currThread = it.next();
			if(!currThread.q.isEmpty())
			s += currThread.toString() + "\n";
		}
		return s;
	}*/
}
