package global;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author cglaeser
 * Common file operations
 *
 */
public class FileOperations {
	
	public static File getProgramDirectory(){
		String currentDir = "";
		Path currentRelativePath = Paths.get("");
		currentDir = System.getProperty("user.dir");
		System.out.println("Current relative path is: " + currentDir);
		return new File(currentDir);
	}
	
	/**
	 * Deletes directory and all files included
	 * @param directory The directory to delete
	 * @return The result of the deletion attempt, true if successful, else false
	 */
	public static boolean deleteDirectory(File directory){
	    if( directory.exists() ) {
	        File[] files = directory.listFiles();
	        for(int i=0; i<files.length; i++) {
	           if(files[i].isDirectory()) {
	             deleteDirectory(files[i]);
	           }
	           else {
	             files[i].delete();
	           }
	        }
	      }
	      return(directory.delete());
	}
	
	/**
	 * @param file A File with a relative file path
	 * @param directory A Directory with an absolute or relative path 
	 * @return true if file is in directory
	 */
	public static boolean fileIsInDirectory(File file, File directory){
		return new File(directory + File.separator + file).exists();
	}

}
