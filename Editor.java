import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*;

public class Editor extends JFrame implements ActionListener {
	JFrame f;
	JTextArea t;
	Editor(){
		f = new JFrame("Editor");
		t = new JTextArea();
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("File");

		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Open"); 
        JMenuItem mi3 = new JMenuItem("Save");

        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 

        m1.add(mi1);
       	m1.add(mi2); 
        m1.add(mi3);

        JMenu m2 = new JMenu("Edit");

        JMenuItem mi4 = new JMenuItem("cut"); 
        JMenuItem mi5 = new JMenuItem("copy"); 
        JMenuItem mi6 = new JMenuItem("paste");
        JMenuItem mi7 = new JMenuItem("find");

        mi4.addActionListener(this); 
        mi5.addActionListener(this); 
        mi6.addActionListener(this);
        mi7.addActionListener(this);

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);

        JMenuItem md = new JMenuItem("Delete");
        md.addActionListener(this);

        mb.add(m1);
        mb.add(m2);
        mb.add(md);

        Finder finder = new Finder();
        finder.b.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		String text = t.getText();
        		String target = finder.get_find_text();
        		int curr_position = t.getCaretPosition();
        		int next_pos = finder.find(text , target , curr_position+1);
				t.setCaretPosition(next_pos);
        	}
		});
        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(500,500);
        f.show();
	}

	public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		if (s.equals("cut")) { 
            t.cut(); 
        }
        else if (s.equals("copy")) { 
            t.copy(); 
        }
        else if (s.equals("paste")) { 
            t.paste(); 
        }
        else if(s.equals("Save")){
        	JFileChooser j = new JFileChooser("F:");
        	int r = j.showSaveDialog(null);
        	if(r == JFileChooser.APPROVE_OPTION){
        		File fs = new File(j.getSelectedFile().getAbsolutePath());
        		try{
        			FileWriter wr = new FileWriter(fs , false);
        			BufferedWriter w = new BufferedWriter(wr);
        			w.write(t.getText());
        			w.flush();
        			w.close();
        		}
        		catch(Exception evt){
        			;
        		}
        	}
        	else{
        		JOptionPane.showMessageDialog(f , "the user cancelled the operation");	
        	}
        }
        else if(s.equals("Open")){
        	JFileChooser j = new JFileChooser("F:");
        	int r = j.showOpenDialog(null);
        	if(r == JFileChooser.APPROVE_OPTION){
        		File fo = new File(j.getSelectedFile().getAbsolutePath());
        		try{
        			String s1 ="" , s2 = "";
        			FileReader fr = new FileReader(fo);
        			BufferedReader br = new BufferedReader(fr);
        			s2 = br.readLine();
        			while((s1 = br.readLine()) != null){
        				s2 = s2 + "\n" + s1;
        			}
        			t.setText(s2);
        		}
        		catch(Exception evt){
        			;
        		}
        	}
        	else{
        		JOptionPane.showMessageDialog(f , "the user cancelled the operation");	
        	}
        }
        else if(s.equals("Delete")){
        	JFileChooser j = new JFileChooser("F:");
			int r = j.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION){
				File fd = new File(j.getSelectedFile().getAbsolutePath());
				if(fd.delete()){
					JOptionPane.showMessageDialog(f , "The file was deleted.");
				}
				else{
					System.out.println("Something is wrong");
				}				
			}
        }
        else if(s.equals("New")){
        	t.setText("");
        } 
	}
	public static void main(String args[]){
		Editor inst = new Editor();
	}
}