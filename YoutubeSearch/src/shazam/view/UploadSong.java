package shazam.view;

import javax.swing.JFrame;

import shazam.controller.Listener;

public class UploadSong {

	public UploadSong(){
		JFrame frame = new JFrame();
		new Listener(frame);
		frame.pack();
		frame.setVisible(true);
	}
}
