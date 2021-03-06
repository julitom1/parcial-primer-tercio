package eci.arsw.covidanalyzer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * NOT MODIFY THIS CLASS.
 */
public class TestReader {

    public static final int THREAD_DELAY = 100;
    private static boolean detener=false;
    public TestReader() {

    }

    public List<Result> readResultsFromFile(File ResultFile) {
        ArrayList<Result> Results = new ArrayList<>();
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        //System.out.println(ResultFile.getName()+"  ===  "+ResultFile.length());
        int count = 0;
        try {
            CSVParser csvParser = CSVFormat.newFormat(',').parse(new InputStreamReader(new FileInputStream(ResultFile)));
            for (CSVRecord record : csvParser) {
            	 
            	//System.out.println("hola");
            	while(detener) {
            		//System.out.println(ResultFile.getName()+"  ===  "+ResultFile.length());
            		synchronized(this) {
            			try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}

                Result Result = new Result();
                Result.setId(UUID.fromString(record.get(0)));
                Result.setFirstName(record.get(1));
                Result.setLastName(record.get(2));
                Result.setEmail(record.get(3));
                Result.setGender(record.get(4));
                Result.setBirthDate(record.get(5));
                Result.setTestDate(record.get(6));
                Result.setResult(new Boolean(record.get(7)));
                Result.setTestSpecifity(Double.parseDouble(record.get(8)));
                Results.add(Result);
                try {
                    if (count % 20 == 0) {
                        Thread.sleep(THREAD_DELAY);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Results;
    }
    public static void setDetener(boolean det) {
    	detener=det;
    }
public static boolean getDetener() {
    	return detener; 
    }
}
