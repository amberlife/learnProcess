package thinkingInJava.concurrent;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProducerConsumer {
	Queue<Integer> items = new ConcurrentLinkedQueue<Integer>();
	final static int NO_ITEMS = 100; // 队列最大容量

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(pc.new Producer(10));
		Thread t2 = new Thread(pc.new Producer(20));
		Thread t3 = new Thread(pc.new Producer(30));
		Thread t4 = new Thread(pc.new Producer(40));
		Consumer c = pc.new Consumer(20);
		Thread t5 = new Thread(c);
		Thread t6 = new Thread(c);
		Thread t7 = new Thread(c);
		Thread t8 = new Thread(c);
		Thread t9 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}

	class Producer implements Runnable {
		int produceNum;

		public Producer(int produceNum) {
			this.produceNum = produceNum;
		}

		// 生产produceNum数量的Integer
		public void produce() {
			synchronized (Producer.class) {
				while (produceNum + items.size() > NO_ITEMS) {
					System.out.println("生产结果，超出队列最大容量");
					try {
						Producer.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
				Random random = new Random(47);
				// 满足生产条件，开始生产
				for (int i = 0; i < produceNum; i++) {
					items.add(random.nextInt(100));
				}
			

			System.out.println("已经produce了" + produceNum + "个产品");
			synchronized (Consumer.class) {
				Consumer.class.notifyAll();
			}
		}

		public void run() {
			produce();
		}
	}

	class Consumer implements Runnable {
		int consumeNum;

		public Consumer(int consumeNum) {
			this.consumeNum = consumeNum;
		}

		public void consume() {
			synchronized (Consumer.class) {
				while (items.size() - consumeNum < 0) {
					System.out.println("消费数量太多，超出队列中产品数量");
					try {
						Consumer.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			for (int i = 0; i < consumeNum; i++) {
					items.poll();
			}		
			System.out.println("已经consume了" + consumeNum + "个产品");
			synchronized (Producer.class) {
				Producer.class.notifyAll();
			}
		}

		public void run() {
			consume();
		}
	}
}