package search.view;

import javax.swing.JFrame;

import search.controller.Listener;

public class UploadSong {

	public UploadSong(){
		JFrame frame = new JFrame();
		new Listener(frame);
		frame.pack();
		frame.setVisible(true);
	}
}
