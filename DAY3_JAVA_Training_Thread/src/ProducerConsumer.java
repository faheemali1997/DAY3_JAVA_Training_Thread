
public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Buffer bufferSize = new Buffer(10);
		Thread p = new Thread(new Producer(),"Producer"); 
		Thread c = new Thread(new Consumer(),"Consumer");
		p.start();
		c.start();}		
}

class Buffer{
	public int bufferSize = 10;
	public int count = 0;
//	Buffer(int buffer){
//		this.bufferSize = buffer;
//	}
//	Buffer()
//	{
//		
//	}
	void incrementCount()
	{
		count++;
	}
	
	void decrementCount()
	{
		count--;
	}
	
	int getCount(){
		return count;
	}
	
	int getMaxCount(){
		return bufferSize;
	}
}

class Producer extends  Buffer implements Runnable{
	private Buffer buffer = new Buffer();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(buffer){
		if(count == buffer.getMaxCount())
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer.incrementCount();
		notify();
		}
	}
}

class Consumer extends Buffer implements Runnable{
	private Buffer buffer = new Buffer();
	@Override
	public void run() {
		// TODO Auto-generated method stub
			synchronized(buffer){
			if(count == 0)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			buffer.decrementCount();
			notify();
			}
	}
}