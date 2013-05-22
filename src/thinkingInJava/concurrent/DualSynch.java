package thinkingInJava.concurrent;

public class DualSynch {
	private Object syncObject = new Object();
	public synchronized void f() {
		for(int i=0;i<5;i++){
			System.out.println("f()");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void g(){
		synchronized(syncObject){
			for(int i=0;i<5;i++){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("g()");
			}
		}
	}
	
	public  static void main(String[] args){
		final DualSynch ds = new DualSynch();
		new Thread(){
			public void run(){
				ds.f();
			}
		}.start();
		ds.g();
	}
	
}
