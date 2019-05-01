package infpp.oceanlife.Controller;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Custom FileFilter to save and load oceans in a file ending with ".ocean". Keeps able of navigating through directories.
 * 
 * @author Baris Simonjan, Etienne Violet
 */
class OceanFileFilter extends FileFilter {
	/**
	 * Overriding the method that is called by the JFileChooser to decide which formats are accepted
	 * 
	 * @param file
	 *            file from the class File
	 * @return boolean
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		String filename = file.getName();
		return filename.endsWith(".ocean");
	}

	/**
	 * Return the allowed file extensions
	 * 
	 * @return .ocean
	 */
	@Override
	public String getDescription() {
		return "*.ocean";
	}
}
