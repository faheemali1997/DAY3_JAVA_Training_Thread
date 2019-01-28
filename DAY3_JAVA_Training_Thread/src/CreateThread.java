class MyRunnable implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("MyRunnable Running "+ Thread.currentThread().getName());
	}
}

public class CreateThread{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyRunnable(),"AvgCalculatorThread"); // Method 1 : Naming Thread: Constructor Method
		//t.setName("AvgCalculatorThread"); Method 2 : Naming Thread
		Thread t2 = new Thread(new MyRunnable(),"MaxCalculatorThread");
		//y.setName("MaxCalculatorThread");
		Thread t3 = new Thread(new MyRunnable(),"MinCalculatorThread");
		//u.setName("MinCalculatorThread");
		t1.start();
		t2.start();
		t3.start();
		try{
			t1.join(); //Wait till thread t is completed and then execute main.
		}catch (Exception e)
		{
		}
		System.out.println("Main Class Ends");
	}
}


