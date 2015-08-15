package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogToFile {

	private File file;
	private FileWriter fw;
	private BufferedWriter bw;
	private boolean writeAble;
	
	public LogToFile() {
		openFile();
	}
	
	private void openFile(){
		try {

			String content = "This is the content to write into file.";

			file = new File("C:\\Users\\EthanHuntTB1\\Desktop\\log.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// Force to create new file
			file.createNewFile();

			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			writeln(content);

			System.out.println("Log created ...");
			writeAble = true;

		} catch (IOException e) {
			System.out.println("Log created ... CRASH");
			e.printStackTrace();
		}
	}
	
	public void closeFile(){
		try{
			bw.close();
			writeAble = false;
			System.out.println("Log end ...");
		} catch (IOException e) {
			System.out.println("Log end ... CRASH");
			e.printStackTrace();
		}
	}

	public void write(String logStr) {
		if(!writeAble)
			return;
		try {
			bw.write(logStr);
		} catch (IOException e) {
			System.out.println("Log write ... CRASH");
			e.printStackTrace();
		}		
	}

	public void writeln(String logStr) {
		if(!writeAble)
			return;
		try {
			bw.write(logStr+"\r\n");
		} catch (IOException e) {
			System.out.println("Log writeln ... CRASH");
			e.printStackTrace();
		}	
	}
}
