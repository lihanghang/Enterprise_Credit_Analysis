/* 
 * Copyright (C) 2014 Vasilis Vryniotis <bbriniotis at datumbox.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.ccip.bank.utils.javaDea;

/**
 * DEA method separates the features of the observations in input and output; 
 * The DeaRecord is a wrapper Object which stores the input and output parts of our
 * data points.
 * 
 * @author Vasilis Vryniotis <bbriniotis at datumbox.com>
 */
public class DeaRecord {
    /**
     * The values of features that are considered as input. It can be empty if 
     * if no input is assumed. 
     */
    private final double[] input;
    
    /**
     * The values of features that are considered as output.
     */
    private final double[] output;
    
    /**
     * Constructor of DEA Record with only output
     * 
     * @param output    The output part of our data record
     */
    public DeaRecord(double[] output) {
        this.output=output;
        this.input= new double[0];
    }
    
    /**
     * Constructor of DEA Record with both input and output
     * 
     * @param output    The output part of our data record
     * @param input     The input part of our data record
     */
    public DeaRecord(double[] output, double[] input) {
        this.output=output;
        this.input=input;
    }
    
    /**
     * Getter for input
     * 
     * @return  Returns the input part of our data.
     */
    public double[] getInput() {
        return input;
    }
    
    /**
     * Getter for output
     * 
     * @return  Returns the output part of our data.
     */
    public double[] getOutput() {
        return output;
    }
}
