import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*;

class Menu extends JMenu{
	JMenu m1;
	Menu(String name){
		m1 = new JMenu(name);
	}
}