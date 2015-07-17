/**
 *  This program is distributed under the terms of the GNU General Public License
 *  Copyright (c) 2015, Ravi Mohan
 */


/**  
 *  This file is part of minkowski-graph.
 *
 *  minkowski-graph is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  minkowski-graph is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with minkowski-graph.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author The_Cowboy
 */

package minkowski;


import java.util.Scanner;
import java.math.*;

public class generateData {
    
    private
        float multiplier;
    
    public
        double data[][];        
                
        generateData(float mul){
            multiplier = mul;
        }
        
        void generate(){
            
            int ch, num_of_points;
            float total_len, interval_len;
            float xi, yi, slope;
            String sl;
            byte isInfinity = 0;

            Scanner in = new Scanner(System.in);

            System.out.println("Enter the plot type: coordinate axis(0), time axis(1), space axis(2)");
            ch = in.nextInt();
            System.out.println("Enter the total duration");
            total_len = in.nextFloat();
            System.out.println("Enter the interval length");
            interval_len = in.nextFloat();
            System.out.println("Enter the slope");
            sl = in.next();
            if(sl.equalsIgnoreCase("infinity"))
            {isInfinity = 1; slope = 0;}
            else slope = Float.parseFloat(sl);
            System.out.println("Enter the initial x coordinate");
            xi = in.nextFloat();
            System.out.println("Enter the initial y coordinate");
            yi = in.nextFloat();

            xi *= multiplier;
            yi *= multiplier;
	    
            num_of_points = (int)(total_len/interval_len);
		
            data = new double[num_of_points+1][2];
            
            data[0][0] = xi;
            data[0][1] = yi;
            
            for(int i = 1; i <= num_of_points; i++){
                if(ch == 0){
                    if(isInfinity == 0){
                        data[i][0] = (float) (xi + multiplier*i*interval_len*1/Math.sqrt(1+slope*slope)); 
                        data[i][1] = (float) (yi + multiplier*i*interval_len*slope/Math.sqrt(1+slope*slope));
                    }
                    else{
                        data[i][0] = xi; 
                        data[i][1] = yi + multiplier*i*interval_len;
                    }
                }
                else if(ch == 1){
			data[i][0] = xi + multiplier*i*interval_len/slope;
                        data[i][1] = yi + multiplier*i*interval_len;
                }
		else if(ch == 2){
			data[i][0] = xi + multiplier*i*interval_len;
                        data[i][1] = yi + multiplier*i*interval_len*slope;
                }
		
            }
	    
        }
    
        
}
