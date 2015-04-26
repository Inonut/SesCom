package search.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AudioLogic.Media;
import search.view.Result;
import search.view.UploadWorker;
import search.view.View;
import uk.co.caprica.vlcj.binding.internal.media_duration_changed;

public class Controller {
	View vw;
	Controller t = this;
	public Boolean run = true;
	UploadWorker wrk = null;
	Media med = new Media();

	public Controller(View vw) {
		this.vw = vw;
		initActions();
	}

	public void initActions() {

		vw.getMatch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = med.getMatch().analyze();
				Result result = new Result(name);
				showResult(result);
			}

		});

		vw.getRegister().addActionListener(new StartList(wrk, vw.getFc(), vw));

		vw.getStopUpload().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (wrk != null){
					wrk.cancel(true);
					wrk.setWorcking(false);
				}

			}

		});

		vw.getStartMic().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				med.startrecordMic();
			}

		});
	}

	public void showResult(JPanel panel) {

		JFrame frame = new JFrame();
		new Listener(frame);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	class StartList implements ActionListener {

		JFileChooser fc = null;
		View frm = null;

		StartList(UploadWorker wrk, JFileChooser fc, View frm) {

			this.fc = fc;
			this.frm = frm;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			wrk = new UploadWorker(fc, frm, med);
			wrk.execute();
		}

	}

}
