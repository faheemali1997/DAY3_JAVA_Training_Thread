class Signal{
	private Object MyNewObj = new Object();
	public void doWait() throws InterruptedException
	{
		synchronized(MyNewObj) {
			// TODO Auto-generated method stub
				MyNewObj.wait();
		}	
	}
}

public class CreateThread1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Signal s = new Signal();
		System.out.println("In main!");
		s.doWait();
	}
}
