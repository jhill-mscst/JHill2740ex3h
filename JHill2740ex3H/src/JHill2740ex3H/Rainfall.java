package JHill2740ex3H;


public class Rainfall {
	private double [] rainfallArray;
	
	public Rainfall(double[] r) {
		rainfallArray = new double[r.length];
		
		for(int index = 0; index < r.length; index++)
			rainfallArray[index] = r[index];
	}
	
	 public Rainfall(String[] r) {
	        super();
	        this.rainfallArray = new double[r.length]; 
	        for  (int index = 0; index < r.length; index++) 
	                this.rainfallArray[index] = Double.parseDouble(r[index]);
	    }
	
	public double getTotal() {
		double total = 0.0;
		
		for (double value : rainfallArray)
			total += value;
		
		return total;
	}
	
	public double getAverage()
	{
		return getTotal() / this.rainfallArray.length;
	}
	
	public double getHighest() {
		double highest = rainfallArray[0];
		
		for (int index = 1; index < rainfallArray.length; index++)		
		{
			if (rainfallArray[index] > highest)
				highest = rainfallArray[index];
		}
		return highest;
	}
	
	public double getLowest() {
		double lowest = rainfallArray[0];
		
		for (int index = 1; index < rainfallArray.length; index++)
			
		{
			if (rainfallArray[index] < lowest)
				lowest = rainfallArray[index];
		}
		
		return lowest;
	}
}
