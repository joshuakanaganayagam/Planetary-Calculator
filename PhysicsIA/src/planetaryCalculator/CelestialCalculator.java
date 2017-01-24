package planetaryCalculator;

public class CelestialCalculator {
	
	
	//double GravitationalConstantG = 0.00000000006674;
	int NumberOfObjects = 0;
	celestialObject[] objects;
	double[] objectGravitParameter;
	
	double[] xcoords;
	double[] ycoords;
	double[] zcoords;
	int printingObject = 0;
	double printRate = 0.0;
	double printCounter = 0.0;
	boolean dataToFile = false;
	
	
	public CelestialCalculator(int NumberOfObjects, double[] gravitationalParameter, double interval, int objectForPrint, double printRate, double[] xcoords, double[] ycoords, double[] zcoords, double[] xVel, double[] yVel, double[] zVel) {
		this.NumberOfObjects = NumberOfObjects;

		objects = new celestialObject[this.NumberOfObjects];
		for (int i=1; i<=NumberOfObjects; i++) {
			
			objects[i-1] = new celestialObject(xcoords[i-1], ycoords[i-1], zcoords[i-1], xVel[i-1], yVel[i-1], zVel[i-1], interval);
			
		}
		objectGravitParameter = new double[this.NumberOfObjects];
		objectGravitParameter = gravitationalParameter;
		
		printingObject = objectForPrint;
		this.printRate = printRate;
		printCounter = 0.0;
		if (dataToFile) {
			objects[printingObject-1].printDataToFile();
		} else {
			objects[printingObject-1].printData(0.0);
		}
		
		//

		
		this.xcoords = new double[this.NumberOfObjects];
		this.ycoords = new double[this.NumberOfObjects];
		this.zcoords = new double[this.NumberOfObjects];
		
	}
	
	
	
	
	
	public void UpdateForces(double seconds) {
		
		for (int i=1; i<=NumberOfObjects; i++) {
			xcoords[i-1] = objects[i-1].getXcoord();
			ycoords[i-1] = objects[i-1].getYcoord();
			zcoords[i-1] = objects[i-1].getZcoord();
		}
		
		for (int i=1; i<=NumberOfObjects; i++) {
			
				double totalAccelerationX = 0.0;
				double totalAccelerationY = 0.0;
				double totalAccelerationZ = 0.0;
				
			for (int j=1; j<=NumberOfObjects; j++) {
				if (i==j) {
					
				} else {
					double distance = Math.sqrt(Math.pow((xcoords[j-1]-xcoords[i-1]), 2) + Math.pow((ycoords[j-1]-ycoords[i-1]), 2) + Math.pow((zcoords[j-1]-zcoords[i-1]), 2));
					double gravitationalFieldStrength = objectGravitParameter[j-1]/Math.pow(distance, 2);
					double xAcceleration = gravitationalFieldStrength * (xcoords[j-1]-xcoords[i-1])/distance;
					double yAcceleration = gravitationalFieldStrength * (ycoords[j-1]-ycoords[i-1])/distance;
					double zAcceleration = gravitationalFieldStrength * (zcoords[j-1]-zcoords[i-1])/distance;
					
					totalAccelerationX += xAcceleration;
					totalAccelerationY += yAcceleration;
					totalAccelerationZ += zAcceleration;
					
				}
			}
			objects[i-1].setxAccel(totalAccelerationX);
			objects[i-1].setyAccel(totalAccelerationY);
			objects[i-1].setzAccel(totalAccelerationZ);
			
		}
		
		for (int i=1; i<=NumberOfObjects; i++) {
			objects[i-1].performIteration();
			
		}
		
		printCounter += 1.0;
		if (printCounter>=printRate) {
			printCounter -= printRate; 
			if (dataToFile) {
				objects[printingObject-1].printDataToFile();	
			} else {
				objects[printingObject-1].printData(seconds);;
			}
			
		}
        
		
	}
	
}
