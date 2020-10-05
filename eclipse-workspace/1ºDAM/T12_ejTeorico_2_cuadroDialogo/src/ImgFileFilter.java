import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImgFileFilter extends FileFilter{
	public boolean accept(File f) {
		if( f.getPath().endsWith(".jpg")
			||f.getPath().endsWith(".gif")
			||f.getPath().endsWith(".jpeg")
			||f.isDirectory())
			return true;
			else return false;
		
	}
	public String getDescription() {
		return "Archivos de imagen";
	}
}
