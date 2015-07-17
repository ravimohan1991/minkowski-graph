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

package minkowski;

import com.panayotis.gnuplot.GNUPlotParameters;
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.dataset.FileDataSet;
import com.panayotis.gnuplot.layout.StripeLayout;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.NamedPlotColor;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.swing.JPlot;
import com.panayotis.gnuplot.terminal.PostscriptTerminal;
import com.panayotis.gnuplot.terminal.SVGTerminal;
import com.panayotis.gnuplot.utils.Debug;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author The_Cowboy
 */
public class Minkowski {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int num_of_plots;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the number of plots");
        num_of_plots = in.nextInt();
        
        for(int i = 0; i < num_of_plots; i++){
            generateData gd = new generateData();
            gd.generate();
            EPSTerminal(gd.data);
        }
        
    }
    
    /* This demo code creates a EPS file on home directory */
     static void EPSTerminal(double[][] data) {
        JavaPlot p = new JavaPlot();

        PostscriptTerminal epsf = new PostscriptTerminal(System.getProperty("user.home")
                + System.getProperty("file.separator") + "output.eps");
        epsf.setColor(true);
        p.setTerminal(epsf);
        
        //Set the title and labels
        p.setTitle("Minkowski Graph of Observer F");
        p.set("xlabel", "\"$x$ in meters\"");
        p.set("ylabel", "\"$t$ in light seconds\"");
        
        //Set up the grid for the Minkowski graph
        p.set("xrange", "[-50:50]");
        p.set("yrange", "[-50:50]");
        p.set("size ratio", "-1");
        p.set("grid xtics", "lc rgb \"#bbbbbb\" lw 1 lt 1");
        p.set("grid ytics", "lc rgb \"#bbbbbb\" lw 1 lt 1");
        p.set("ytics", "3 format \" \"");
        p.set("xtics", "3 format \" \"");
        p.set("grid", null);
       
        p.addPlot(data);
        
        PlotStyle stl = ((AbstractPlot) p.getPlots().get(0)).getPlotStyle();
        stl.setStyle(Style.LINESPOINTS);
        stl.setLineWidth(2);
        stl.setLineType(NamedPlotColor.BLUE);
        stl.setPointType(7);
        stl.setPointSize(1);
        ((AbstractPlot) p.getPlots().get(0)).setTitle("Axis");
        
        p.plot();
    }
    
}
