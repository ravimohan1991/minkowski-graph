/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * $version - 0.9
 * $author - The_Cowboy
 * $date - July 7, 2015
 */

import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.math.*;

public class generate {

    public static float multiplier = 3;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

	int num_of_plots, ch;
	float total_len, interval_len;
	float xi, yi, slope;

	Scanner in = new Scanner(System.in);

	System.out.println("Enter the number of plots");
	num_of_plots = in.nextInt();

	for(int i = 1; i <= num_of_plots; i++ ){
	    
	    PrintWriter writer = new PrintWriter(new File(i+".txt"));

	    System.out.println("Enter the plot type: proper axis(0), time axis(1), space axis(2)");
	    ch = in.nextInt();
	    System.out.println("Enter the total duration");
	    total_len = in.nextFloat();
	    System.out.println("Enter the interval length");
	    interval_len = in.nextFloat();
	    System.out.println((ch == 0) ? "Enter the slope (negative for infinity)":"Enter the slope");
	    slope = in.nextFloat();
	    System.out.println("Enter the initial x coordinate");
	    xi = in.nextFloat();
	    System.out.println("Enter the initial y coordinate");
	    yi = in.nextFloat();

	    xi *= multiplier;
	    yi *= multiplier;
	    writer.printf("%f %f\n", xi, yi);
       
		for(int j = 1; j <= total_len/interval_len; j++ ){
		    if(ch == 0){
			if(slope >= 0)
			    writer.printf("%f %f\n", xi+multiplier*j*interval_len*1/Math.sqrt(1+slope*slope), yi+multiplier*j*interval_len*slope/Math.sqrt(1+slope*slope));
			else
			    writer.printf("%f %f\n", xi, yi+multiplier*j*interval_len);
		    }
		    else if(ch == 1)
			writer.printf("%f %f\n", xi+multiplier*j*interval_len/slope, yi+multiplier*j*interval_len);
		    else if(ch == 2)
			writer.printf("%f %f\n", xi+multiplier*j*interval_len, yi+multiplier*j*interval_len*slope);
		}
	    writer.close();
	    }
    }  
}
