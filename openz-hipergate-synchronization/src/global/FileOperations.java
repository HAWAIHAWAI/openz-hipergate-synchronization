package global;

import java.io.File;

/**
 * Class for file operations.
 * 
 * @author Christian Gl�ser
 *
 */
public class FileOperations {

	/**
	 * Determines the directory of the program and returns it.
	 * 
	 * @return Directory of the program.
	 */
	public static File getProgramDirectory() {
		String currentDir = "";
		currentDir = System.getProperty("user.dir");
		System.out.println("Current relative path is: " + currentDir);
		return new File(currentDir);
	}

	/**
	 * Deletes directory and all files included
	 * 
	 * @param directory
	 *            The directory to delete
	 * @return The result of the deletion attempt, true if successful, else
	 *         false
	 */
	public static boolean deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (directory.delete());
	}

	/**
	 * Checks if a file exists in a specified directoy.
	 * 
	 * @param file
	 *            A File with a relative file path
	 * @param directory
	 *            A Directory with an absolute or relative path
	 * @return true if file is in directory
	 */
	public static boolean fileIsInDirectory(File file, File directory) {
		return new File(directory + File.separator + file).exists();
	}

}
