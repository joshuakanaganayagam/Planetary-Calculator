package planetaryCalculator;

public class celestialObject {
	
	double xcoord;
	double ycoord;
	double zcoord;
	
	double xVel;
	double yVel;
	double zVel;
	
	double xAccel;
	double yAccel;
	double zAccel;
	
	double interval;
	
	
	
	public celestialObject(double xc, double yc, double zc, double vx, double vy, double vz, double interval) {
		xcoord = xc;
		ycoord = yc;
		zcoord = zc;
		
		xVel = vx;
		yVel = vy;
		zVel = vz;
		
		xAccel = 0.0;
		yAccel = 0.0;
		zAccel = 0.0;
		
		this.interval = interval;
		

		
	}
	
	public void performIteration() {
		/*
		xcoord += (xVel*interval) + (xAccel/2)*Math.pow(interval, 2);
		ycoord += (yVel*interval) + (yAccel/2)*Math.pow(interval, 2);
		zcoord += (zVel*interval) + (zAccel/2)*Math.pow(interval, 2);
		*/
		xcoord += (xVel*interval);
		ycoord += (yVel*interval);
		zcoord += (zVel*interval);
		
		xVel += xAccel*interval;
		yVel += yAccel*interval;
		zVel += zAccel*interval;
		
		
	}
	
	public void printData(double seconds) {
		System.out.println(seconds);
		System.out.println(xcoord + " " + ycoord + " " + zcoord);
		System.out.println(xVel + " " + yVel + " " + zVel);
		System.out.println(xAccel + " " + yAccel + " " + zAccel);
		
		System.out.println();
		
	}
	
	public void printDataToFile() {
		
		System.out.println(xcoord + ";" + ycoord + ";" + zcoord);

		
	}
	

	public void setxAccel(double xAccel) {
		this.xAccel = xAccel;
	}

	public void setyAccel(double yAccel) {
		this.yAccel = yAccel;
	}

	public void setzAccel(double zAccel) {
		this.zAccel = zAccel;
	}

	public double getXcoord() {
		return xcoord;
	}

	public double getYcoord() {
		return ycoord;
	}

	public double getZcoord() {
		return zcoord;
	}
	
	
	
	
	
}
