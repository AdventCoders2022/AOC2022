package com.altimetrik.aoc.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Puzzle1 {
    public static void main(String[] args) {
        File file = new File("D:\\User\\rvinayakamurthy\\workarea\\AoCworkspace\\AoC\\src\\com\\altimetrik\\aoc\\day1\\input.txt");
        List<Long> output=new ArrayList<>();
        long sum=0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
            	String line1= scanner.nextLine();
            	
            	if(!line1.equals("")) {
            		long line = Long.parseLong(line1);
            		sum+=line;
            	}else {
            		output.add(sum);
            		sum=0;
            	}
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Collections.sort(output,Collections.reverseOrder());
        
        long total=0;
        int i=0;
        for (Iterator iterator = output.iterator(); iterator.hasNext();) {
			Long long1 = (Long) iterator.next();
			total = total + long1;
			if (i==2) {
				break;
			}
			i++;
			
		}
        System.out.println("Sum of first 3 values :" + total);
		
        
    }
}