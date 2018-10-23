import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*;
import java.awt.FlowLayout;

public class Finder extends JFrame{
	JFrame f;
	JTextField find_text;
	JLabel find_label;
	JPanel panel;
	public JButton b;
	Finder(){
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		b = new JButton("find");
		f = new JFrame("Editor");
		find_text = new JTextField(20);
		find_label = new JLabel("find");
		panel.add(find_label);
		panel.add(find_text);
		panel.add(b);
		f.add(panel);
		f.pack();
		f.show();
	}

	String get_find_text(){
		return find_text.getText();
	}

	int find(String text , String target , int starting){
		int ret = text.indexOf(target , starting);
		return ret;
	}

	public static void main(String args[]){
		Finder inst = new Finder();
	}
}