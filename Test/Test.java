import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 

public class Test extends JFrame implements ActionListener{
	JFrame f;
	Test(){
		f = new JFrame();
		JMenuBar mb = new JMenuBar();
		JMenuItem delete = new JMenuItem("delete");
		delete.addActionListener(this);
		mb.add(delete);
		f.setJMenuBar(mb);
		f.setSize(500,500);
		f.show();
	}
	public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		if(s.equals("delete")){
			JFileChooser j = new JFileChooser();
			int r = j.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION){
				File fd = new File(j.getSelectedFile().getAbsolutePath());
				if(fd.delete()){
					System.out.println("File deleted");
				}
				else{
					System.out.println("Something is wrong");
				}				
			}
		}

	}
	public static void main(String args[]){
		Test t = new Test();
	}
}