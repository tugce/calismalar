package eclipsePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.apache.log4j.Logger;

public class SortTest {
	
	/** Sort the array a[] in ascending order
     ** using an insertion sort.
     */
    static void sort(int a[], int size) {
        for (int i = 1; i < size; i++) {
            // a[0..i-1] is sorted
            // insert a[i] in the proper place
            int x = a[i];
            int j;
            for (j = i-1; j >=0; --j) {
                if (a[j] <= x)
                    break;
                a[j+1] = a[j];
            }
            // now a[0..j] are all <= x
            // and a[j+2..i] are > x
            a[j+1] = x;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SortTest.class);
		/*
		System.out.println(args[0]);
		if (args.length != 1) {
            System.out.println("usage: sort array-size");
            System.exit(1);
        }
		
        int size = Integer.parseInt(args[0]);*/
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("/home/tugce/workspace/calismalar/EclipseTutorial/src/eclipsePackage/parameters.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = Integer.parseInt(prop.getProperty("sort"));
        int test[] = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++)
            test[i] = (int)(r.nextFloat() * 100);
        System.out.println("before");
        for (int i = 0; i < size; i++)
            System.out.print(" " + test[i]);
        System.out.println();
        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");
        sort(test, size);

        System.out.println("after");
        for (int i = 0; i < size; i++)
            System.out.print(" " + test[i]);
        System.out.println();
        System.exit(0);

	}

}
