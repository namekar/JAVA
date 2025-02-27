package simpleNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
public class GUI implements ActionListener{
	JFrame window;
	//TEXT AREA
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	//TOP MENU BAR
	JMenuBar menuBar;
	JMenu menuFile, menuEdit,menuFormat, menuColor;
	//FILE MENU
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	//FORMAT MENU
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont,menuFontSize;
	
	
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);


	public static void main(String[] args) {
		new GUI();

	}
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		
		
		window.setVisible(true);
		

	}
	public void createWindow() {
		window = new JFrame ("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		
	}
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
	}
	public void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save as");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	public void createFormatMenu() {
		iWrap = new JMenuItem("Word Wrap : Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);

		
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("28");
		menuFontSize.add(iFontSize24);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "SaveAs": file.saveAs(); break;
		case "Save": file.save(); break;
		case "Exit": file.exit(); break;
		case "Word Wrap": format.wordWrap(); break;
		case "Arial": format.setFont(command); break;
		case "Comic Sans MS": format.setFont(command); break;
		case "Times New Roman": format.setFont(command); break;
		case "8": format.createFont(8); break;
		case "12": format.createFont(12); break;
		case "16": format.createFont(16); break;
		case "20": format.createFont(20); break;
		case "24": format.createFont(24); break;
		case "28": format.createFont(28); break;
		}
	}
}
	
