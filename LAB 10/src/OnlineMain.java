import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

// class implementing the icon
class CircleIcon implements Icon
{
	private double		radius;			// radius of the circle icon
	private int			X_position;		// x-position of circle icon
	private int			Y_position;		// y-position of circle icon
	// Constructor Method
	CircleIcon(double radius)
	{
		this.radius 		= 	radius;
		this.X_position 	= 	300;	// current x-position is 300
		this.Y_position 	= 	0;		// current y-position is 0
	}

	// Methods for getting icon height and width
	public int getIconWidth()			{	return (int)radius;   	}
	public int getIconHeight()			{	return (int)radius;   	}

	// Method for painting icon
	public void paintIcon(Component C,Graphics g, int x,int y)
	{
	Graphics2D g2 = (Graphics2D)g;
	Ellipse2D.Double circle = new Ellipse2D.Double(x+X_position,y+Y_position,radius,radius);
	g2.draw(circle);
	g2.setColor(Color.red);
	g2.fill(circle);
	}

	//    ADD ANY OTHER METHOD(s) THAT YOU THINK IS/ARE REQUIRED FOR THIS PROBLEM. DO NOT REMOVE
	//    THESE COMMENTS JUST WRITE YOUR CODE AFTER THESE COMMENTS
	
	//Accessor and mutator methods
	
	public double getRadius(){
		return radius;
	}
	public int getX(){
		return X_position;
	}
	public int getY(){
		return Y_position;
	}
	public void setRadius(double radius){
		this.radius= radius;
	}
	public void setX(int X_position){
		this.X_position = X_position;
	}
	public void setY(int Y_position){
		this.Y_position = Y_position;
	}

}// End of class CircleIcon


//-----------------------------------------FOUR THREAD CLASSES -------------------------

class LeftThread extends Thread
{
		CircleIcon circleIcon;
		boolean suspendLeftThread = true;
		JFrame frame;
		
		public LeftThread(CircleIcon circleIcon, JFrame frame){
			this.circleIcon = circleIcon;
			this.frame = frame;
		}
							
		public void run(){
			synchronized(circleIcon){
				try{
					while(true){
						while(suspendLeftThread){						
								circleIcon.wait();					
						}
						if(circleIcon.getX()!=0){
							System.out.println("Moving Left");
							circleIcon.setX(circleIcon.getX()-10);
							frame.repaint();
							Thread.sleep(100);
						}
						else{
							circleIcon.wait();
							suspendLeftThread = true;
						}					
					}
				}
				catch(InterruptedException e){
					System.out.println("Child thread Interrupted");
				}		
			}
		}
}

class RightThread extends Thread
{
		CircleIcon circleIcon;
		boolean suspendRightThread = true;	
		JFrame frame;
		
		public RightThread(CircleIcon circleIcon, JFrame frame){
			this.circleIcon = circleIcon;
			this.frame = frame;
		}
							
		public void run(){
			synchronized(circleIcon){
				try{
					while(true){
						while(suspendRightThread){						
								circleIcon.wait();					
						}
						if(circleIcon.getX()!=600){
						System.out.println("Moving Right");
						circleIcon.setX(circleIcon.getX()+10);
						frame.repaint();
						Thread.sleep(100);
						}
						else{
							circleIcon.wait();
							suspendRightThread = true;
						}							
					}
				}
				catch(InterruptedException e){
					System.out.println("Child thread Interrupted");
				}		
			}
		}
}

class ScaleUpThread extends Thread
{
		CircleIcon circleIcon;
		boolean suspendScaleUpThread = true;	
		JFrame frame;
		
		public ScaleUpThread(CircleIcon circleIcon, JFrame frame){
			this.circleIcon = circleIcon;
			this.frame = frame;
		}
							
		public void run(){
			synchronized(circleIcon){
				try{
					while(true){
						while(suspendScaleUpThread){						
								circleIcon.wait();					
						}
						if(circleIcon.getRadius()!=50){					
							System.out.println("Scaling Up");
							circleIcon.setRadius(circleIcon.getRadius()+1);	
							frame.repaint();
							Thread.sleep(100);
						}
						else{
							suspendScaleUpThread = true;
							circleIcon.wait();							
						}			
					}
				}
				catch(InterruptedException e){
					System.out.println("Child thread Interrupted");
				}		
			}
		}
}
class ScaleDownThread extends Thread
{
		CircleIcon circleIcon;
		boolean suspendScaleDownThread = true;	
		JFrame frame;
		
		public ScaleDownThread(CircleIcon circleIcon, JFrame frame){
			this.circleIcon = circleIcon;
			this.frame = frame;
		}
							
		public void run(){
			synchronized(circleIcon){
				try{
					while(true){
						while(suspendScaleDownThread){						
								circleIcon.wait();					
						}
						if(circleIcon.getRadius()!=5){					
							System.out.println("Scaling Down");
							circleIcon.setRadius(circleIcon.getRadius()-1);
							frame.repaint();
							Thread.sleep(100);
						}
						else{
							suspendScaleDownThread = true;
							circleIcon.wait();							
						}
					}
				}
				catch(InterruptedException e){
					System.out.println("Child thread Interrupted");
				}		
			}
		}
}

//----------------------------------------THREAD CLASSES ENDS HERE------------------------




// Driver class
class OnlineMain
{
	// The following four boolean class variables can be used to determine whether the thread has started or not
	// While starting any thread just make the corresponding flag as  true. Initially no thread is started.
	public static boolean leftThreadStarted 		= false;	//leftThread not started initially
	public static boolean rightThreadStarted 		= false;	//rightThread not started initially
	public static boolean scaleUpThreadStarted 		= false;	//scaleUpThread not started initially
	public static boolean scaleDownThreadStarted 	= false;	//scaleDownThread not started initially

	// The following four boolean class variables can be used to determine which thread is currently running
	// Only one of the following 4 variables will be true at a time and rest other are false.
	// Initially no thread is running
	public static boolean leftThreadRunning 		= false;	//leftThread is not running initially
	public static boolean rightThreadRunning 		= false;	//rightThread is not running initially
	public static boolean scaleUpThreadRunning 		= false;	//scaleUpThread is not running initially
	public static boolean scaleDownThreadRunning 	= false;	//scaleDownThread is not running initially

	// Driver main() Method
	public static void main(String args[])
	{

		JFrame frame = new JFrame("Main Frame");	// original frame
		frame.setSize(600,600);						// size 600 * 600
		frame.setLayout(new BorderLayout());		// layout BorderLayout

		// Create a CircleIcon instance circleIcon with initial radius 10
		CircleIcon circleIcon = new CircleIcon(10);

		// Create a JLabel instance named iconLabel which can hold above circleIcon
		final JLabel iconLabel = new JLabel();
		iconLabel.setIcon(circleIcon);		// setting icon for iconLabel

		// Create a JPanel for holding iconLabel
		JPanel centrePanel = new JPanel(new BorderLayout());
		centrePanel.add(iconLabel,BorderLayout.CENTER);		// Adding iconLabel in the center of centrePanel

		// Create Buttons with labels as mentioned in the Question
		JButton leftButton 			= 	new JButton("LEFT");		// left button
		JButton rightButton 		= 	new JButton("RIGHT");		// right button
		JButton scaleUpButton 		= 	new JButton("SCALE UP");	// scaleUp button
		JButton scaleDownButton 	= 	new JButton("SCALE DOWN");	// scaleDown button
		JButton stopButton 			= 	new JButton("STOP");		// stop button

		// Create a buttonPanel for holding buttons
		JPanel buttonPanel		=	new JPanel();

		// Add buttons to buttonPanel
		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);
		buttonPanel.add(scaleUpButton);
		buttonPanel.add(scaleDownButton);
		buttonPanel.add(stopButton);


		// Add centrePanel to center of frame
		frame.add(centrePanel,BorderLayout.CENTER);

		// Add buttonPanel to south portion of frame
		frame.add(buttonPanel,BorderLayout.SOUTH);

		// Display Frame
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Default close operation

		//---------------------------------------- WRITE YOUR CODE FROM HERE---------------------------

		// Complete the following thread creating statement(s) after removing the comments

		 final LeftThread leftThread 			= 	new LeftThread(circleIcon,frame);
		 final RightThread rightThread 			= 	new RightThread(circleIcon,frame);
		 final ScaleUpThread scaleUpThread 		= 	new ScaleUpThread(circleIcon,frame);
		 final ScaleDownThread scaleDownThread 	= 	new ScaleDownThread(circleIcon,frame);
		 
		 
		// WRITE JAVA CODE FOR ACTIONLISTENERS FOR VARIOUS BUTTONS. USE ONLY INNER CLASSES FOR THE SAME
		 
		 leftButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					leftThread.suspendLeftThread= true;
					rightThread.suspendRightThread= true;
					scaleUpThread.suspendScaleUpThread= true;
					scaleDownThread.suspendScaleDownThread= true;
					if(leftThreadStarted == false){
						leftThreadStarted = true;
						leftThread.suspendLeftThread= false;
						leftThread.start();
					}
					else{
						synchronized(circleIcon)  {
							leftThread.suspendLeftThread= false;
							circleIcon.notifyAll();
						}
					}
				}
			});
		 
		 rightButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					leftThread.suspendLeftThread= true;
					rightThread.suspendRightThread= true;
					scaleUpThread.suspendScaleUpThread= true;
					scaleDownThread.suspendScaleDownThread= true;
					if(rightThreadStarted == false){
						rightThreadStarted = true;
						rightThread.suspendRightThread= false;
						rightThread.start();
					}
					else{
						synchronized(circleIcon)  {
							rightThread.suspendRightThread= false;
							circleIcon.notifyAll();
						}
					}
				}
			});
		 
		 scaleUpButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					leftThread.suspendLeftThread= true;
					rightThread.suspendRightThread= true;
					scaleUpThread.suspendScaleUpThread= true;
					scaleDownThread.suspendScaleDownThread= true;
					if(scaleUpThreadStarted == false){
						scaleUpThreadStarted = true;
						scaleUpThread.suspendScaleUpThread= false;
						scaleUpThread.start();
					}
					else{
						synchronized(circleIcon)  {
							scaleUpThread.suspendScaleUpThread= false;
							circleIcon.notifyAll();
						}
					}
				}
			});
		 
		 scaleDownButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					leftThread.suspendLeftThread= true;
					rightThread.suspendRightThread= true;
					scaleUpThread.suspendScaleUpThread= true;
					scaleDownThread.suspendScaleDownThread= true;
					if(scaleDownThreadStarted == false){
						scaleDownThreadStarted = true;
						scaleDownThread.suspendScaleDownThread= false;
						scaleDownThread.start();
					}
					else{
						synchronized(circleIcon)  {
							scaleDownThread.suspendScaleDownThread= false;
							circleIcon.notifyAll();
						}
					}
				}
			});
		 
		  stopButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					leftThread.suspendLeftThread= true;
					rightThread.suspendRightThread= true;
					scaleUpThread.suspendScaleUpThread= true;
					scaleDownThread.suspendScaleDownThread= true;
					
				}
			});

	} // End of main() Method
}// End of class OnlineMain