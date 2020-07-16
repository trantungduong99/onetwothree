package onetwothree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private JPanel frame;
	private JPanel graphicsPanel;
	private static final long serialVersionUID = 1L;
	private String aa[]= {"keo","bua","bao"};
	private int id = 1;
	private int row = 1;
	private int col = 3;
	private int wid = 650;
	private int hei = 800;
	private JButton keo,bua,bao;
	public MainFrame() throws IOException
	{
		frame = new JPanel(new BorderLayout());
		graphicsPanel = new JPanel(new GridLayout(row,col));
		keo = new JButton();
		bua = new JButton();
		bao = new JButton();
		keo.addActionListener(this);
		bua.addActionListener(this);
		bao.addActionListener(this);	

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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==keo)
		{
			versus(1);
		}
		else if (arg0.getSource()==bua)
		{
			versus(2);
		}
		else if (arg0.getSource()==bao)
		{
			versus(3);
		}
		
	}
	private void versus(int i) {
		int a;
		Random rd=new Random();
		a=rd.nextInt()%10;
		if (a<4) 
		{
			
			System.out.println("Bot ra "+aa[i-1]);
			System.out.println("Hoa!");
		}
		if (a>=4 && a<=6)
		{
			int z=i-1;
			if (z==0) z=3;
			System.out.println("Bot ra "+aa[z-1]);
			System.out.println("Win ^^");
			change(1);
		}
		if (a==7 || a==8 || a==9)
		{
			int z=i+1;
			if (z==4) z=1;
			System.out.println("Bot ra "+aa[z-1]);
			System.out.println("Lose T.T");
			change(-1);
		}
		
	}

}