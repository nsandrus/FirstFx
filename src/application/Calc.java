package application;

import application.MyController;

public class Calc implements Runnable {

		MyController controller;
		
public Calc(MyController myController) {
	System.out.println("new thread constructor");
	controller = new MyController();
	controller = myController;
	myController.btn1.setVisible(false);
	}

@Override
public void run() {
	System.out.println(this.toString());
	System.out.println("new thread run");
	//myController.btn1.setDisable(true);
	//myController.btn1.setVisible(false);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("new thread run");
	controller.btn1.setVisible(true);

	
}
}