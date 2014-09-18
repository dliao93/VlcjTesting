package Vlcj;
import java.io.File;
import javax.swing.JFileChooser;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;

public class Start
{
	private static JFileChooser ourFileSelector = new JFileChooser();
	public static void main(String[] args)
	{
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		
		String vlcPath ="", mediaPath ="";
		File ourFile;
		
		ourFileSelector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		ourFileSelector.showSaveDialog(null);
		ourFile = ourFileSelector.getSelectedFile();
		vlcPath = ourFile.getAbsolutePath();
		
		ourFileSelector.setFileSelectionMode(JFileChooser.FILES_ONLY);
		ourFileSelector.showSaveDialog(null);
		ourFile = ourFileSelector.getSelectedFile();
		vlcPath = ourFile.getAbsolutePath();
		
		new MediaPlayer(vlcPath,mediaPath).run();
	}
}