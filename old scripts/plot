##
#  This program is distributed under the terms of the GNU General Public License
#  Copyright 2015, Ravi Mohan
##

##  
#  This file is part of minkowski-graph.
#
#  minkowski-graph is free software: you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation, either version 3 of the License, or
#  (at your option) any later version.
#
#  minkowski-graph is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  You should have received a copy of the GNU General Public License
#  along with minkowski-graph.  If not, see <http://www.gnu.org/licenses/>.
##

#-----------------------------------------------------------------
# $version - 0.9 
# $author - The_Cowboy
# $date - July 7, 2015
# $purpose - to generate a plot using gnuplot from the data files
#-----------------------------------------------------------------

set terminal epslatex size 5, 7 color 
set output "graph.tex"


# Set the title and labels

set title "Minkowski Graph of Observer F"
set xlabel "$x$ in meters"
set ylabel "$t$ in light seconds"


# Setup the grid

set xrange [-50:50]
set yrange [-50:50]
set size ratio -1				#Makes sure to draw square boxes 
set grid ytics lc rgb "#bbbbbb" lw 1 lt 1    # draw lines for ytics 
set grid xtics lc rgb "#bbbbbb" lw 1 lt 1    # draw lines for xtics
set ytics 3 format " "		     		# set the spacing for the ytics without labels. Change the multiplier when you change this
set xtics 3 format " "	       			 # set the spacing for the xtics without labels
set grid              				 # enable the grid
 

# Use the data points from the files generated

plot "1.txt"  using 1:2 notitle with lp lc "#008000" lt 1 lw 2 pt 7 pi -1 ps 1, "2.txt"  using 1:2 notitle with lp lc "#008000" lt 1 lw 2 pt 7 pi -1 ps 1, "3.txt"  using 1:2 title "coordinate axis of F'" with lp lc "#8A2BE2" lt 1 lw 2 pt 7 pi -1 ps 1, "4.txt"  using 1:2 notitle with lp lc "#8A2BE2" lt 1 lw 2 pt 7 pi -1 ps 1, "5.txt"  using 1:2 title "world sheet of rod" with lp lc "#DC143C" lt 1 lw 2 pt 7 pi -1 ps .7, "6.txt"  using 1:2 notitle with lp lc "#DC143C" lt 1 lw 2 pt 7 pi -1 ps .7





