package braitenberg;



import braitenberg.braitenbergvehikel.BVSimulation;

public class SimulationThread extends Thread {

	private BVSimulation simulation;
	
	boolean flag = true;
	public SimulationThread(BVSimulation simulation) {
		this.simulation = simulation;
	}


	public void run() {
		while(flag){
		simulation.simulationsSchritt();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
	}

	public void setFlag(){
		 flag =false;
	}
}
