import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class Plotter extends ApplicationFrame {

	

	public Plotter(String title) 
	{
		super(title);
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));
		setContentPane(chartPanel);
	}


	private static XYDataset createDataset() 
	{
		
		XYSeries series = new XYSeries("Probability of pair");	//For plotting
		
		int trials,trial_no,person_no,guess_date;
		float probability;
		int person_success[] = new int [366];					//For recording success
		
		trials= 600;											//No. of trials n
		
		for(trial_no=0;trial_no<trials;trial_no++)              //Conduct trials
		{
			
			int year[] = new int [365];							//Represents a year
			
			for(person_no=0;person_no<366;person_no++)			//Add persons
			{
				guess_date= (int)(Math.random() * (365));		//Generate random guess_date in [0,366)
				
				if( ++year[guess_date] > 1)						//First Pair detected at guess_date
					for(;person_no<366;person_no++)				//Record success
					{
						++person_success[person_no];
					}											//Goto next trial        	
			}
		
		}														
		
																//All trials completed
				  
		System.out.println("Persons\tProbability\n");
		
		for(person_no=0;person_no<366;person_no++)     			//For every no. of persons
		{
			probability = (float)person_success[person_no]/trials; //Calculate Probability
			System.out.println((person_no+1)+"\t"+probability);
			series.add((person_no+1),probability);
		}

		
		//For plotting
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		return dataset;
}

	private static JFreeChart createChart(XYDataset dataset) 
	{
		// create the chart...
		JFreeChart chart = ChartFactory.createXYLineChart(
		"Probability Plot", // chart title
		"Number_of_persons", // x axis label
		"p(pair)", // y axis label
		dataset, // data
		PlotOrientation.VERTICAL,
		true, // include legend
		false, // tooltips
		false // urls
		);

	
		chart.setBackgroundPaint(Color.white);
	
		return chart;
}



	public static JPanel createDemoPanel() 
	{
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}


	public static void main(String[] args) 
	{
		Plotter demo = new Plotter("Birthday Paradox");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}