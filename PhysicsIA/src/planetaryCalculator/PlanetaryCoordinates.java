package planetaryCalculator;

public class PlanetaryCoordinates {

	public static void main(String[] args) {

		int numberOfObjects=3;
		
		//Earth and Sun Calculations! 1st October 2015
		
		/* Earth Coords
		 *    1.491310898458938E+08  1.911742163412118E+07 -2.466425803116988E+04
  			-4.251655242047355E+00  2.943889064497480E+01 -2.513437365720961E-04
		 * GM = 398600.440 * E9
		 * 
		 * Sun Coords
		 * 	   5.410672737156067E+05  1.173981845232310E+05 -2.357472050279917E+04
   				2.959173176265306E-03  1.125735099691444E-02 -8.791253272060276E-05
		 * 	GM = 1.3271244004193938 E11 * E9; 1.988544 E30
		 * 
		 * Moon Coords
		 *    1.493759933199680E+08  1.938662429298412E+07 -4.932566229437478E+04
  				-5.010493631601595E+00  3.020038032349431E+01 -7.182716471397477E-02
  				GM=4902.798 *E9

		 * 
		 */
		
		
		double[] xcords = {149131089845.8938, 541067273.7156067, 149375993319.9680};
		double[] ycords = {19117421634.12118, 117398184.5232310, 19386624292.98412};
		double[] zcords = {-24664258.03116988, -23574720.50279917, -49325662.29437478};
		
		double[] xVel = {-4251.655242047355,2.959173176265306, -5010.493631601595};
		double[] yVel = {29438.89064497480, 11.25735099691444, 30200.38032349431};
		double[] zVel = {-0.2513437365720961, -0.08791253272060276, -71.82716471397477};
		
		double[] gravitationalParameter = {398600440000000.0,132712440041939380000.0, 4902798000000.0};

		//Please note that these variables will be changed if the program is needed for a different time frame.
		double interval = 0.01;
		double seconds = (604800*53);
		double secondsPerPrint = 604800;
		double iterationsPerPrint = secondsPerPrint/interval;
		int printingObject = 1;
		
		
		
		CelestialCalculator ForceCalculator = new CelestialCalculator(numberOfObjects, gravitationalParameter, interval, printingObject, iterationsPerPrint, xcords, ycords, zcords, xVel, yVel, zVel);
		
		for (double m=interval; m<seconds+interval; m+=interval) {

			ForceCalculator.UpdateForces(m);
			
		}

	}

}
