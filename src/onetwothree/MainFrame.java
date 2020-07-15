package onetwothree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends JFrame
{
	/**
	 * 
	 */
	private JPanel frame;
	private JPanel graphicsPanel;
	private static final long serialVersionUID = 1L;
	//private String aa[]= {"keo","bua","bao"};
	private int id = 1;
	private int row = 1;
	private int col = 3;
	private int wid = 650;
	private int hei = 720;
	private JButton keo,bua,bao;
	public MainFrame() throws IOException
	{
		frame = new JPanel(new BorderLayout());
		graphicsPanel = new JPanel(new GridLayout(row,col));
		keo = new JButton();
		bua = new JButton();
		bao = new JButton();
		Image hand;
		hand =ImageIO.read(getClass().getResource("/Image/sci.png"));
		keo.setIcon(new ImageIcon(hand));		
		hand = ImageIO.read(getClass().getResource("/Image/roc.png"));
		bua.setIcon(new ImageIcon(hand));
		hand = ImageIO.read(getClass().getResource("/Image/pap.png"));
		bao.setIcon(new ImageIcon(hand));
		graphicsPanel.add(keo);
		graphicsPanel.add(bua);
		graphicsPanel.add(bao);
		
		frame.add(graphicsPanel,BorderLayout.SOUTH);
		Image back = ImageIO.read(getClass().getResource("/Image/yt1.jpg"));
		frame.add(new JLabel(new ImageIcon(back)),BorderLayout.CENTER);
		
		this.add(frame);
		this.setTitle("One Two Three Game");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(wid, hei);
		this.setLocationRelativeTo(null);
		this.setVisible(true);				
	}
	public void change(int stt)
	{
		id+=stt;
		if (id==11) id =5;
		if (id==0) id=1;
		String path="/Image/yt";
		path=path+Integer.toString(id);
		path=path+".jpg";
		
		Image back = null;
		try {
			back = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) { 
			e.printStackTrace();
		}
		this.frame.removeAll();
		this.frame.add(new JLabel(new ImageIcon(back)),BorderLayout.CENTER);
		this.frame.add(this.graphicsPanel,BorderLayout.SOUTH);
		this.add(this.frame);
		this.validate();
		this.repaint();
		System.out.println("Change image");
	}

}