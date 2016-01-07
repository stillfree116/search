package anton.smirnov;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Save {

	public void write(String fileName, HashMap<String, Integer> filesDict) throws IOException {
		File file = new File(fileName);
		try {
	        if(!file.exists()){
	            file.createNewFile();
	        } else {
	        	System.out.println("Такой файл уже существует и был перезаписан");
	        }
	        PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	        	for (Map.Entry<String, Integer> entry : filesDict.entrySet()) {
	        	writer.println("Файл - '" + entry.getKey()
    		    + "', повторений: " + entry.getValue());
	        	}
	        } finally {
	        	writer.close();
	        	System.out.println("Результат сохранен в " + file);
	        }
	    } catch(IOException e) {
	    	System.out.println("Не удалось найти указыннй путь");
	    }
	}
	
	public void write(HashMap<String, Integer> filesDict) {
		for (Map.Entry<String, Integer> entry : filesDict.entrySet()) {
		    System.out.println("Файл - '" + entry.getKey()
		    + "', повторений: " + entry.getValue());
		}
	}
}