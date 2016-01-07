package anton.smirnov;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Dictionary {
	private Vector<String> allFilesVector;
	
	public void setAllFilesVector(Vector<String> allFilesVector) {
		this.allFilesVector = allFilesVector; }
	
	public HashMap<String, Integer> getFilesDict () {
		List<String> allFilesList = Collections.list(allFilesVector.elements());
	    HashMap<String, Integer> filesDict = new HashMap<String, Integer>();
	    Integer c;
	    for (String i : allFilesList) {
	        c = filesDict.get(i);
	        filesDict.put(i, c == null ? 1 : c + 1); }

	    for (Object key : filesDict.keySet().toArray()) {
	        if (filesDict.get(key) == 1) {
	        	filesDict.remove(key); }
	        }
	    return filesDict; }}


class Find extends Dictionary {
	Vector<String> all = new Vector<String>();
	
	public void createFilesVector(String path) {
		File startPath = new File(path);
		File[] files = startPath.listFiles();
		
		if (files.length == 0) {
			System.out.println("Не найдено ни одного файла");
			System.exit(0);
		}
		
		for (int i = 0; i < files.length; i++) {
			File file = new File(files[i].toString());
			if (file.isFile()) {
				String name = file.getName();
				all.add(name);
			} else { 
				this.createFilesVector(files[i].toString());
			}
		}
	}
}