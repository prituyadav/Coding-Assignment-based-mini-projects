package com.masai.entities;

 class Student implements Runnable{
	
	private Thread t;
	private String threadName;
		
	public Student(String threadName) {
		// TODO Auto-generated constructor stub
		this.threadName=threadName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			System.out.println(threadName);
		
	}
	
	public void start() {
		if(t==null) {
			t=new Thread(this,threadName);
			t.start();
		}
	}
        
	
	public static class M {
		private static void main(String[] arr) {
			// TODO Auto-generated method stub
             Student a=new Student("A");
             Student b=new Student("B");
             
             b.start();
             a.start();
		}
	}
	
}
