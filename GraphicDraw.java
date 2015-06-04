package leaf;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class GraphicsDraw extends JPanel {

	int x;
	int y;
	int width;
	int height;
	String date;
	Result result = new Result();


	public void paint(Graphics g) {
		LinkedList<Integer> IntList = new LinkedList<Integer>();
		LinkedList<String> StringList = new LinkedList<String>();
		IntList.addAll(result.getDataInt());
		StringList.addAll(result.getDataString());
		IntList.size();

		for (int i = 0; i < IntList.size(); i++) {
			height = IntList.pop();
			date = StringList.pop();
			g.drawRect(10 + i * 10, 10, 10, height); // ªÁ∞¢«¸¿ª ±◊∏∞¥Ÿ.
			g.drawString(date, i * 30, 0);
		}// πÆ¿⁄ø≠¿ª ±◊∏∞¥Ÿ.

	}

	public void imagestore() {
		BufferedImage image = new BufferedImage(200, 200,
				BufferedImage.TYPE_INT_RGB); // ±◊∏≤¿ª ±◊∏Æ±‚ ¿ß«ÿ Graphics2D∏¶ æÚæÓø¬¥Ÿ.
		// πˆ∆€µÂ ¿ÃπÃ¡ˆ∏¶ ∆ƒ¿œ∑Œ ¿˙¿Â.
		Graphics2D graphics = image.createGraphics(); // ≥Î∂ıªˆ¿∏∑Œ º≥¡§«—¥Ÿ.
		graphics.setColor(Color.YELLOW); // 0,0 ∫Œ≈Õ 200 x 200 ªÁ¿Ã¡Ó¿Œ ªÁ∞¢«¸¿∏∑Œ √§øÓ¥Ÿ.
		graphics.fillRect(0, 0, 200, 200); // C:\test.jpeg ∆ƒ¿œ∑Œ ¿˙¿Â«—¥Ÿ.

		try {
			File file = new File("test.jpeg");
			ImageIO.write(image, "jpeg", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
