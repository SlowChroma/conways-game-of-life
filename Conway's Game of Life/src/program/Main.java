package program;

import java.util.Random;

import javax.swing.JOptionPane;

public class Main {
	//This method run's a simulation of Conway's Game of Life, and it gives the user a few starting options.
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try
		{
			int rows = 0;
			int cols = 0;
			boolean runRows = true;
			while (runRows)
			{
				rows = Integer.parseInt(JOptionPane.showInputDialog(null, "How many rows do you want there to be? Max 40, min 10."));
				if (rows > 40 || rows < 10)
				{
					JOptionPane.showMessageDialog(null, "please input an acceptable value");
				}
				else
				{
					runRows = false;
				}
			}
			
			boolean runCols = true;
			while (runCols)
			{
				cols= Integer.parseInt(JOptionPane.showInputDialog(null, "How many columns do you want there to be? Max 40, min 10."));
				if (cols > 40 || cols < 10)
				{
					JOptionPane.showMessageDialog(null, "please input an acceptable value");
				}
				else
				{
					runCols = false;
				}
			}
			boolean[][] array = new boolean[rows-1][cols-1];
			
			Random rand = new Random();
			int ran1 = 0;
			boolean runRan = true;
			while (runRan)
			{
				ran1 = Integer.parseInt(JOptionPane.showInputDialog(null, "What chance do you want for the cells to start alive? Max 80, Min 1"));
				if (ran1 > 80 || ran1 < 1)
				{
					JOptionPane.showInputDialog(null, "please enter an appropriate value");
				}
				else
				{
					runRan = false;
				}
			}
			for (int i = 0; i < array.length; i++)
			{
				for (int j = 0; j < array[i].length; j++)
				{
					int ran2 = rand.nextInt(101);
					
					if (ran2 <= ran1)
					{
						array[i][j] = true;
					}
					else
					{
						array[i][j] = false;
					}	
				}
			}
			
			boolean run = true;
			
			while (run)
			{
				String display = "";
				
				for (int i = 0; i < array.length; i++)
				{
					for (int j = 0; j < array[i].length; j++)
					{
						if (array [i][j])
						{
							display += "⬛";
						}
						else
						{
							display += "⬜";
						}
					}
					display += "\n";
				}
				
				String[] options = new String[] {"refresh", "exit"};
				Object answer = JOptionPane.showInputDialog(null, display, "Conway's Game of Life", 1, null, options, null);
				if (answer.equals("refresh"))
				{	
					for (int i = 0; i < array.length; i++)
					{
						for (int j = 0; j < array[i].length; j++)
						{
							int neighbors = 0;
							
							try
							{
								if (array[i-1][j-1])
								{
									neighbors++;
								}
								if (array[i-1][j])
								{
									neighbors++;
								}
								if (array[i-1][j+1])
								{
									neighbors++;
								}
								if (array[i][j-1])
								{
									neighbors++;
								}
								if (array[i][j+1])
								{
									neighbors++;
								}
								if (array[i+1][j-1])
								{
									neighbors++;
								}
								if (array[i+1][j])
								{
									neighbors++;
								}
								if (array[i+1][j+1])
								{
									neighbors++;
								}
							}
							catch (Exception e){}
							
							if (array[i][j])
							{
								if (neighbors < 2)
								{
									array[i][j] = false;
								}
								else if (neighbors > 3)
								{
									array[i][j] = false;
								}
							}
							else if (!array[i][j])
							{
								if (neighbors == 3)
								{
									array[i][j] = true;
								}
							}
						}
					}					
				}
				else if (answer.equals("exit"))
				{
					run = false;
				}
				else if (answer.equals(0))
				{
					run = false;
				}
			}			
		}
		catch (Exception e){}
	}
}
