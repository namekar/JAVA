package simpleNotepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	GUI gui;
	String fileName;
	String fileAddress;
	public Function_File(GUI gui) {
		this.gui = gui;
	}
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
		fileName = null;
		fileAddress = null;
	}
	public void open() {
		FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if (fd.getFile()!=null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(fileName);
			
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));// u need address to read file
			gui.textArea.setText("");
			String line = null;
			while((line = br.readLine())!=null) {
				gui.textArea.append(line + "\n");
			}
			br.close();
		}catch(Exception e) {
			System.out.println("FILE NOT OPENED");
		}
	}
	public void save() {
		if(fileName==null) {
			saveAs();
		}else {
			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(fileName);
				fw.close();
				
			}catch (Exception e) {
				System.out.println("SOMETHING WRONG");
			}
		}
		
	}
	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window, "save", FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		try {
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(gui.textArea.getText());
			fw.close();
			
		}catch(Exception e) {
			System.out.println("something is wrong");
		}
	}
	public void exit() {
		System.exit(0);
	}

}
