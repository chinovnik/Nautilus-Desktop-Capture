package net.ardgi.nautilus.desktopcapture.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private Point initialClick;

	private void initialize() {
		frame = new JFrame();
		frame.setSize(96, 408);
		frame.setBounds(0, 0, 96, 408);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		JLabel move = new JLabel();
		move.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				move.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/move_click.png")));
				frame.setOpacity(0.5f);
				initialClick = e.getPoint();
				frame.getComponentAt(initialClick);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				move.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/move_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				move.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/move.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				move.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/move_hover.png")));
				frame.setOpacity(1.0f);
			}
		});

		move.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {

				// get location of Window
				int thisX = frame.getLocation().x;
				int thisY = frame.getLocation().y;

				// Determine how much the mouse moved since the initial click
				int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
				int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

				// Move window to this position
				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				frame.setLocation(X, Y);
			}
		});
		JLabel record = new JLabel();
		JLabel play = new JLabel();
		JLabel pause = new JLabel();
		JLabel stop = new JLabel();

		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				play.setVisible(false);
				pause.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				play.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/play_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				play.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/play.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				play.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/play_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				play.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/play_hover.png")));
			}
		});

		move.setIcon(new ImageIcon(Gui.class
				.getResource("/net/ardgi/nautilus/desktopcapture/res/move.png")));
		move.setBounds(0, 0, 96, 24);
		frame.getContentPane().add(move);

		JLabel exit = new JLabel();
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/exit_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/exit.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				exit.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/exit_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				exit.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/exit_hover.png")));
			}
		});
		exit.setIcon(new ImageIcon(Gui.class
				.getResource("/net/ardgi/nautilus/desktopcapture/res/exit.png")));
		exit.setBounds(0, 24, 96, 96);
		frame.getContentPane().add(exit);

		pause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pause.setVisible(false);
				play.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pause.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/pause_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pause.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/pause.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pause.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/pause_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pause.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/pause_hover.png")));
			}
		});
		pause.setIcon(new ImageIcon(
				Gui.class
						.getResource("/net/ardgi/nautilus/desktopcapture/res/pause.png")));
		pause.setBounds(0, 120, 48, 96);
		frame.getContentPane().add(pause);
		pause.setVisible(false);

		stop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stop.setVisible(false);
				pause.setVisible(false);
				play.setVisible(false);
				record.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				stop.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/stop_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				stop.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/stop.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				stop.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/stop_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				stop.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/stop_hover.png")));
			}
		});
		stop.setIcon(new ImageIcon(Gui.class
				.getResource("/net/ardgi/nautilus/desktopcapture/res/stop.png")));
		stop.setBounds(48, 120, 48, 96);
		frame.getContentPane().add(stop);
		stop.setVisible(false);

		JLabel screenshot = new JLabel();
		screenshot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				screenshot.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/screenshot_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				screenshot.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/screenshot.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				screenshot.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/screenshot_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				screenshot.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/screenshot_hover.png")));
			}
		});
		screenshot
				.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/screenshot.png")));
		screenshot.setBounds(0, 216, 96, 96);
		frame.getContentPane().add(screenshot);

		JLabel settings = new JLabel();
		settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settings.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/settings_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				settings.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/settings.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				settings.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/settings_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				settings.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/settings_hover.png")));
			}
		});
		settings.setIcon(new ImageIcon(
				Gui.class
						.getResource("/net/ardgi/nautilus/desktopcapture/res/settings.png")));
		settings.setBounds(0, 312, 96, 96);
		frame.getContentPane().add(settings);

		record.setVisible(true);
		record.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				record.setVisible(false);
				pause.setVisible(true);
				stop.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				record.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/record_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				record.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/record.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				record.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/record_click.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				record.setIcon(new ImageIcon(
						Gui.class
								.getResource("/net/ardgi/nautilus/desktopcapture/res/record_hover.png")));
			}
		});
		record.setIcon(new ImageIcon(
				Gui.class
						.getResource("/net/ardgi/nautilus/desktopcapture/res/record.png")));
		record.setBounds(0, 120, 96, 96);
		frame.getContentPane().add(record);

		play.setVisible(false);
		play.setIcon(new ImageIcon(Gui.class
				.getResource("/net/ardgi/nautilus/desktopcapture/res/play.png")));
		play.setBounds(0, 120, 48, 96);
		frame.getContentPane().add(play);
	}
}
