package shazam.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import shazam.controller.Listener;
import sun.security.util.PendingException;
import vlc.Utils;

public class View extends JFrame implements ActionListener{

	private JPanel panelShazam;
	private JPanel panelResult;
	private JButton register,match;
	
	public View(){
		
		Utils.chargerLibrairie();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		panelShazam = new JPanel();
		panelResult = new JPanel();
		
		
		register = new JButton("Register");
		match = new JButton("Match");
		
		register.addActionListener(this);
		match.addActionListener(this);
		
		panelShazam.add(register);
		panelShazam.add(match);
		
		this.add(panelShazam,BorderLayout.NORTH);
		this.add(panelResult,BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
	}
	
	public void showResult(JPanel panel){
		//this.remove(this.panelResult);
		//this.panelResult=panel;
		//this.add(this.panelResult,BorderLayout.CENTER);
		
		JFrame frame = new JFrame();
		new Listener(frame);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==match){
			
			//exemplu
			//stringu reprezinta ce rezulta din shazam
			Result result = new Result("Rammstein - Les Arènes de Nîmes");
	        this.showResult(result);
			
			return;
		}
		
		if(e.getSource()==register){
			
			new UploadSong();
			
			return;
		}
		
	}
	
}
