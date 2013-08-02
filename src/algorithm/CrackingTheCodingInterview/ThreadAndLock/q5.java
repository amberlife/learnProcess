package algorithm.CrackingTheCodingInterview.ThreadAndLock;

import java.util.concurrent.Semaphore;

/**
 *	
 *class Foo{
    A(.....); If A is called, a new thread will be created and
               the corresponding function will be executed. 
    B(.....); same as above 
    C(.....); same as above 
};
  1 设计一种机制，确保B在A之后执行，C在B之后执行
  2 设计一种机制，确保所有的方法都能按照如下顺序进行：A(),B(),C(),A(),B(),C()...
 */
public class q5  {
	
	private Semaphore mech1_A = new Semaphore(0);
	private Semaphore mech1_B = new Semaphore(0);
	
	private Semaphore mech2_A = new Semaphore(0);
	private Semaphore mech2_B =new Semaphore(0);
	private Semaphore mech2_C =new Semaphore(1);
	
	public void  A1()  {
		System.out.println("A1();");
		mech1_A.release();
	}
	
	public void  B1() {
		try {
			mech1_A.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B1();");
		mech1_B.release();
	}
	
	public void  C1() {
		try {
			mech1_B.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("C1();");
	}
	
	
	public void A2(){
		try {
			mech2_C.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("A2()");
		mech2_A.release();
	}
	
	public void B2(){
			try{
				mech2_A.acquire();
			} catch (InterruptedException e) {}
	
		System.out.println("B2()");
		
			mech2_B.release();
		
	}
	
	public void C2() {
		try{
			mech2_B.acquire();
		}catch(InterruptedException e){
			
		}
		System.out.println("C2()");
		mech2_C.release();
		
	}
	

	public static void main(String[] args) {
		final q5 q = new q5();
		/*Thread t1 = new Thread( new Runnable(){
			public void run(){
				q.A1();
			}
		});
		Thread t2 = new Thread( new Runnable(){
			public void run(){
				q.B1();
			}
		});
		Thread t3 = new Thread( new Runnable(){
			public void run(){
				q.C1();
			}
		});
		Thread t4 = new Thread( new Runnable(){
			public void run(){
				q.A1();
			}
		});
		t1.start();
		t4.start();
		t3.start();
		t2.start();*/
		
		Thread t5 = new Thread( new Runnable(){
			public void run(){
				q.A2();
			}
		});
		Thread t6 = new Thread( new Runnable(){
			public void run(){
				q.B2();
			}
		});
		Thread t7 = new Thread( new Runnable(){
			public void run(){
				q.C2();
			}
		});
		Thread t8 = new Thread( new Runnable(){
			public void run(){
				q.A2();
			}
		});
		Thread t9 = new Thread( new Runnable(){
			public void run(){
				q.B2();
			}
		});
		Thread t10 = new Thread( new Runnable(){
			public void run(){
				q.C2();
			}
		});
		
		t10.start();
		t9.start();
		t8.start();
		t7.start();
		t6.start();
		t5.start();
		
		
	}

	
	
}
