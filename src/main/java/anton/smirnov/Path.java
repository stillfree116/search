package anton.smirnov;

import java.io.IOException;
import java.util.HashMap;

public class Path {
	
	private String SearchPath;
	private String SavePath;

	public void setSearchPath(String path) {
//		 System.out.println("Путь для поиска - " + path);
		 this.SearchPath = path; }
	 
	public void setSavePath(String path) {
//		 System.out.println("Путь для сохранения - " + path);
		 this.SavePath = path; }
	
	public void start() throws IOException {
		
		Find workerFind = new Find();
		workerFind.createFilesVector(SearchPath);
		workerFind.setAllFilesVector(workerFind.all);
		HashMap<String, Integer> filesDict = workerFind.getFilesDict();
		if (filesDict.isEmpty()) {
			System.out.println("Не найдено ни одного совпадения");
			System.exit(0);
		}
		
		Save save = new Save();
		if (SavePath == null) { 
			save.write(filesDict);
//			System.out.println(filesDict);
		} else {
			save.write(SavePath, filesDict);
//			System.out.println(filesDict.values());
			
		}
	}
}