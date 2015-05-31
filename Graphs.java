package leaf;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Graphs extends Frame {
	// ±◊∑°«¡ ≈∏¿‘¿ª ¿ß«— ªÛºˆ
	public final static int BAR = 0;

	private int graphStyle;

	// µ•¿Ã≈ÕøÕ ∞°¿Â¿⁄∏Æ ªÁ¿Ãø° ∫Òøˆµ— ∞¯∞£¿« æÁ¿ª ¡ˆ¡§«—¥Ÿ.
	private final int leftGap = 2;
	private final int topGap = 2;
	private final int bottomGap = 2;
	private int rightGap;

	// µ•¿Ã≈∏¿« √÷º“∞™∞˙ √÷¥Î∞™¿ª ¡ˆ¥—¥Ÿ.
	private double min, max;

	// µ•¿Ã≈∏∏¶ ¬¸¡∂«—¥Ÿ.
	private int[] data;

	// ±◊∑°«¡ø° ªÁøÎµ«¥¬ ªˆªÛ.
	Color gridColor = new Color(0, 150, 150);
	Color dataColor = new Color(234, 24, 212);

	// µ•¿Ã≈Õ¿« ≈©±‚∏¶ ¡∂¡§«œ∞Ì ±◊∏Æ±‚ ¿ß«ÿ ªÁøÎµ«¥¬ ¥ŸæÁ«— ∞™µÈ.
	private int hGap; // µ•¿Ã≈∏ ¡°µÈ ªÁ¿Ã¿« ∞≈∏Æ
	private int spread; // √÷º“∞™∞˙ √÷¥Î∞™¿« ¬˜¿Ã
	private double scale; // Ω∫ƒ…¿œ∏µ ¿Œ¿⁄
	private int baseline; // ±‚¡ÿº±¿« ºˆ¡˜ ¡¬«•

	// ¿©µµøÏ ≥ª¿« µ•¿Ã≈Õ øµø™¿« ¿ßƒ°
	private int top, bottom, left, right;

	/*
	 * Graphs ª˝º∫¿⁄(close event,resize event,µ•¿Ã≈∏ ¡§∑¬,±◊∑°«¡º±≈√)
	 */
	public Graphs(int[] vals, int style) {
		// ¿©µµøÏ ¥›±‚ ¿Ã∫•∆Æ √≥∏Æ
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
				dispose();
			}
		});

		// resize event √≥∏Æ
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		});

		graphStyle = style;
		data = vals;

		// min,max ∞™¿ª ±∏«œ±‚ ¿ß«ÿ µ•¿Ã≈∏ ¡§∑ƒ
		double t[] = new double[vals.length];
		System.arraycopy(vals, 0, t, 0, vals.length);
		Arrays.sort(t);
		min = t[0];
		max = t[t.length - 1];

		setSize(new Dimension(200, 120));
		setTitle("BAR Graph");
		setLocation(25, 250);
		setVisible(true);
	}

	/*
	 * paint()
	 */
	public void paint(Graphics g) {
		Dimension winSize = getSize(); // ¿©µµøÏ ≈©±‚
		Insets ins = getInsets(); // ¿©µµøÏ ∞°¿Â¿⁄∏Æ ≈©±‚

		// «ˆ¿Á º±≈√µ» ∆˘∆Æ¿Ã ≈©±‚∏¶ æÚ¥¬¥Ÿ.
		FontMetrics fm = g.getFontMetrics();

		// ø¿∏•¬  ∞£∞›¿ª ∞ËªÍ«—¥Ÿ.
		rightGap = fm.stringWidth("" + data.length);

		// µ•¿Ã≈∏ øµø™¿ª ¡ˆ¡§«œ±‚ ¿ß«— ∞™µÈ¿ª ∞ËªÍ«—¥Ÿ.
		left = ins.left + leftGap + fm.charWidth('0');

		top = ins.top + topGap + fm.getAscent();
		bottom = ins.bottom + bottomGap + fm.getAscent();
		right = ins.right + rightGap;

		if (min > 0)
			min = 0;
		if (max < 0)
			max = 0;

		// √÷º“∞™∞˙ √÷¥Î∞™¿« ∞≈∏Æ∏¶ ∞ËªÍ«—¥Ÿ.
		spread = (int) (max - min);

		// Ω∫ƒ…¿œ∏µ ¿Œ¿⁄ ∞™¿ª ∞ËªÍ«—¥Ÿ.
		scale = (double) (winSize.height - bottom - top) / spread;

		// ±‚¡ÿº±¿ª √£¥¬¥Ÿ.
		baseline = (int) (winSize.height - bottom + min * scale);

		// µ•¿Ã≈Õ ªÁ¿Ã¿« ∞£∞›¿ª ∞ËªÍ«—¥Ÿ.
		hGap = (winSize.width - left - right) / (data.length - 1);

		// ±◊∏ÆµÂ ªˆªÛ¿ª ¡ˆ¡§«—¥Ÿ
		g.setColor(gridColor);

		// ±‚¡ÿº±¿ª ±◊∏∞¥Ÿ.
		g.drawLine(left, baseline, left + (data.length - 1) * hGap, baseline);

		// y√‡¿ª ±◊∏∞¥Ÿ.
		if (graphStyle != BAR)
			g.drawLine(left, winSize.height - bottom, left, top);

		// √÷¥Î∞™,√÷º“∞™¿ª ±◊∏Æ∞Ì 0¿ª «•Ω√«—¥Ÿ.
		g.drawString("0", ins.left, baseline + fm.getAscent() / 2);

		if (max != 0)
			g.drawString("" + max, ins.left, baseline - (int) (max * scale) - 4);

		if (min != 0)
			g.drawString("" + min, ins.left, baseline - (int) (min * scale)
					+ fm.getAscent());

		// ∞™µÈ¿« ∞≥ºˆ∏¶ «•Ω√«—¥Ÿ.
		g.drawString("" + data.length, (data.length - 1) * (hGap) + left,
				baseline + fm.getAscent());

		// µ•¿Ã≈Õ ªˆ±Ú¿ª ¡ˆ¡§«—¥Ÿ.
		g.setColor(dataColor);

		// µ•¿Ã≈Õ∏¶ «•Ω√«—¥Ÿ.
		bargraph(g);
	}

	// ∏∑¥Î±◊∑°«¡∏¶ ±◊∏∞¥Ÿ.
	private void bargraph(Graphics g) {
		int v;
		for (int i = 0; i < data.length; i++) {
			v = (int) (data[i] * scale);

			g.drawLine(i * hGap + left, baseline, i * hGap + left, baseline - v);
		}
	}
	
}
