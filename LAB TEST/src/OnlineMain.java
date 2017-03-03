import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class QuadraticEquation
{
private		int	quadNo;
private 	int 	a;
private 	int 	b;
private 	int 	c;
private 	boolean isSolved;
private		boolean	isRootsPossible;
private	static	int	noofobjectsCreated = 0;
private		double	root1;
private		double	root2;

QuadraticEquation(int a, int b, int c)
{
this.a	=	a;
this.b	=	b;
this.c	=	c;
isSolved=	false;
noofobjectsCreated++;
quadNo	=	noofobjectsCreated;
}
public synchronized void computeRoots()
{
	if( b*b - 4*a*c < 0) 
	{
	isRootsPossible = false;
	root1 = root2 = Double.NEGATIVE_INFINITY; 
	isSolved = true;
	return;
	}
	double disc	=	Math.sqrt(b*b - 4*a*c);
	root1 		= 	(-b+disc)/(2*a);
	root2 		= 	(-b-disc)/(2*a);
	isRootsPossible = 	true;
	isSolved 	= 	true;
	return;
}
public synchronized String toString()
{
return "Quadratic Equation No:="+quadNo+"A:= "+a+"B:= "+b+"C:= "+c+"Root 1:="+root1+"Root 2:="+root2;
}
public synchronized boolean getisSolved()
{
return isSolved;
}
public synchronized	int getNoofObjects()
{
return noofobjectsCreated;
}
}// End of class QuadraticEquation

class QuadraticEquationQueue
{
private QuadraticEquation[]	quadQueue	=	new QuadraticEquation[10];
private	int	tail;
private	int	head;
private	int	size;
	QuadraticEquationQueue()
	{
		head = tail = size =0;
	}
	public synchronized QuadraticEquation remove() throws InterruptedException
	{
		while(size == 0) wait();
		QuadraticEquation quad = quadQueue[head];
		head++;
		size--;
		if(head == quadQueue.length)
			head =0;
		notifyAll();
		return quad;
	}
	public synchronized void add(QuadraticEquation quad) throws InterruptedException
	{
		while(size == quadQueue.length) wait();
		quadQueue[tail] = quad;
		tail++;
		size++;
		if(tail == quadQueue.length)
		tail = 0;
		notifyAll();
	}
	public synchronized boolean isFull()
	{
	return size == quadQueue.length;
	}
	public synchronized boolean isEmpty()
	{
	return size == 0;
	}
}// End of class QuadraticEquationQueue


class CreateThread extends Thread
{
	private JTextField 		T1;
	private JTextField 		T2;
	private JTextField 		T3;
	private QuadraticEquationQueue	queue;
	private boolean			suspendFlag = false;
	private JLabel			label;
	private JLabel			queueFull;
	CreateThread(JTextField T1,JTextField T2,JTextField T3,QuadraticEquationQueue	queue,JLabel label, JLabel queuefullLabel)
	{
		this.T1 	= T1;
		this.T2 	= T2;
		this.T3 	= T3;
		this.queue 	= queue;
		this.label	= label;
		this.queueFull	= queuefullLabel;
	}
	public void run()
	{
		try 
		{
			while(true)
			{
				synchronized(this)
				{
					while(suspendFlag) 
					wait();
					try
					{
						int a = Integer.parseInt(T1.getText());
						int b = Integer.parseInt(T2.getText());
						int c = Integer.parseInt(T3.getText());
						if( a == 0 ) continue;
						QuadraticEquation quad = new QuadraticEquation(a,b,c);
						queue.add(quad);
						String text = "Total No of Equations Created:"+quad.getNoofObjects();
						System.out.println(text);
						System.out.println();
						label.setText(text);
						if(queue.isFull())
							queueFull.setForeground(Color.green);
						else
						queueFull.setForeground(Color.black);
					}
					catch(NumberFormatException ne) {}
				}
				Thread.sleep(150);
			}
		}
		catch(InterruptedException  e){}
	}// End of Run Method

	public void mysuspend()
	{
		suspendFlag = true;
	}
	public synchronized void myresume()
	{
		suspendFlag = false;
		notify();
	}
}// End of CreateThread class


class ComputeThread extends Thread
{
	private	int						threadNo;
	private QuadraticEquationQueue	queue;
	private JLabel[] 				displayLabels = new JLabel[10];
	private JLabel					totalCountLabel;
	private JLabel					countLabel;
	private int						count;
	private JLabel					queueEmpty;
	private	boolean					suspendFlag;

	private	static  int				totalCount=0;
	
	ComputeThread(QuadraticEquationQueue	queue,JLabel[] labels,JLabel totalcountLabel, JLabel L,JLabel queueEmpty,int no)
	{
		this.queue				= queue;
		displayLabels 			= labels;
		this.totalCountLabel 	= totalcountLabel;	
		countLabel				= L;
		this.queueEmpty			= queueEmpty;
		threadNo				= no;
		count					= 0;
	}
	public void run()
	{
		try 
		{
			while(true)
			{
				synchronized(this)
				{
					while(suspendFlag) 
					wait();
					QuadraticEquation quad = queue.remove();
					if(queue.isEmpty())
						queueEmpty.setForeground(Color.green);
					else
						queueEmpty.setForeground(Color.black);
					
					boolean flag = quad.getisSolved();
					
					if(flag) continue;

					int a	= totalCount % 10;
					quad.computeRoots();
					displayLabels[a].setText(quad.toString());
					totalCount++;
					totalCountLabel.setText("Total No of Equations Solved :"+totalCount);
					count++;
					countLabel.setText("By Thread " + threadNo +" :"+count);
					Thread.sleep(150);
				}
		 	}
		}
		catch(InterruptedException e){System.out.println(e);}
	}// End of Run Method

public void mysuspend()
{
suspendFlag = true;
}
public synchronized void myresume()
{
suspendFlag = false;
notify();
}
}// End of CreateThread class

class OnlineMain
{
static Random 	r1 = new Random(20);

static boolean 	createThreadStarted	= false;
static boolean 	createThreadStopped	= false;
static boolean 	createThreadResumed	= false;

static boolean 	computeThreadStarted	= false;
static boolean 	computeThreadStopped	= false;
static boolean 	computeThreadResumed	= false;




public static void main(String args[])
{
JFrame frame = new JFrame("QuadraticFrame");
Container c1 = frame.getContentPane();
c1.setLayout(new BoxLayout(c1,BoxLayout.X_AXIS));

JPanel leftPanel = new JPanel();
leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));

JLabel label1	= new JLabel("QUEUE FULL");
leftPanel.add(label1);

JButton b1 = new JButton("START");
JButton b2 = new JButton("STOP");

JLabel L1	= new JLabel("A =");
JLabel L2	= new JLabel("B =");
JLabel L3	= new JLabel("C =");
JLabel L4	= new JLabel("Total No of Equations Created:"+0);

JPanel btnPanel = new JPanel();
btnPanel.add(b1);
btnPanel.add(b2);

final JTextField T1 	= new JTextField(6); 
final JTextField T2 	= new JTextField(6); 
final JTextField T3 	= new JTextField(6); 

T1.setText("0");
T2.setText("0");
T3.setText("0");

JPanel P1 = new JPanel();
P1.add(L1);
P1.add(T1);

JPanel P2 = new JPanel();
P2.add(L2);
P2.add(T2);

JPanel P3 = new JPanel();
P3.add(L3);
P3.add(T3);

JPanel P4 = new JPanel();
P4.add(L4);

leftPanel.add(btnPanel);
leftPanel.add(P1);
leftPanel.add(P2);
leftPanel.add(P3);
leftPanel.add(P4);



JPanel rightPanel = new JPanel();
rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));

JLabel L20 = new JLabel("QUEUE EMPTY");
rightPanel.add(L20);

JPanel P21 = new JPanel();
JButton b3 = new JButton("START");
JButton b4 = new JButton("STOP");
P21.add(b3);
P21.add(b4);


JLabel[] resultLabels = new JLabel[10];
for(int i=0;i<10;i++)
resultLabels[i] = new JLabel();

JPanel P22 = new JPanel();
P22.setLayout(new BoxLayout(P22,BoxLayout.Y_AXIS));
for(int i=0;i<10;i++)
P22.add(resultLabels[i]);

JLabel L21 = new JLabel("Total No Of Equations Solved:"+0);
P22.add(L21);

JLabel L22 = new JLabel("By Thread 1:"+0);
P22.add(L22);

JLabel L23 = new JLabel("By Thread 2:"+0);
P22.add(L23);

JLabel L24 = new JLabel("By Thread 3:"+0);
P22.add(L24);

rightPanel.add(P21);
rightPanel.add(P22);

c1.add(leftPanel);
c1.add(rightPanel);
frame.setSize(400,600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);




ActionListener listener = new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
				Integer  a = r1.nextInt(20);
				Integer  b = r1.nextInt(20);
				Integer  c = r1.nextInt(20);
				T1.setText(a.toString());
				T2.setText(b.toString());
				T3.setText(c.toString()); 
				return;
			        }
			};
final Timer timer = new Timer(100,listener);
final QuadraticEquationQueue queue = new QuadraticEquationQueue();
final CreateThread createThread1 = new CreateThread(T1,T2,T3,queue,L4,label1);

final ComputeThread computeT1 = new ComputeThread(queue,resultLabels,L21,L22,L20,1);
final ComputeThread computeT2 = new ComputeThread(queue,resultLabels,L21,L23,L20,2);
final ComputeThread computeT3 = new ComputeThread(queue,resultLabels,L21,L24,L20,3);



b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		if(!createThreadStarted) 
			{
			createThread1.start();
			createThreadStarted = true;
			timer.start();
			return;
			}	
		if(createThreadStopped)
			{
			createThread1.myresume();
			createThreadResumed = true;
			createThreadStopped = false;
        		timer.restart();
			}
		}
	});

b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(createThreadResumed || createThreadStarted)
			{
			createThread1.mysuspend();
			createThreadStopped = true;
			createThreadResumed = false;
			timer.stop();
			}
		}
	});

b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		if(!computeThreadStarted) 
			{
			computeT1.start();
			computeT2.start();
			computeT3.start();
			computeThreadStarted = true;
			return;
			}	
		if(computeThreadStopped)
			{
			computeT1.myresume();
			computeT2.myresume();
			computeT3.myresume();
			computeThreadResumed = true;
			computeThreadStopped = false;
        		}
		}
	});

b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(computeThreadStarted || computeThreadResumed) 
			{
			computeT1.mysuspend();
			computeT2.mysuspend();
			computeT3.mysuspend();
			computeThreadStopped = true;
			computeThreadResumed = false;
			}	
		}
	});



}
}
