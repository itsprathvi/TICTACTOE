package Fonts;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FontRender {

    public static Font getProgressStyle() {
        try {
            InputStream myStream = new BufferedInputStream(
                    new FileInputStream("./Fonts/Progress.ttf"));
            Font fontHelsky = Font.createFont(Font.TRUETYPE_FONT, myStream);
            return fontHelsky.deriveFont(Font.PLAIN, 80);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 50);
        }
    }

    public static Font getNewsPaperStyle() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/NewsPaper.ttf"));
            return font.deriveFont(Font.PLAIN, 80);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getNewsPaperStyle3() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/NewsPaper.ttf"));
            return font.deriveFont(Font.PLAIN, 20);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getNewsPaperStyle2() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/NewsPaper.ttf"));
            return font.deriveFont(Font.PLAIN, 30);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getRemachineStyle() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/Remachine.ttf"));
            return font.deriveFont(Font.PLAIN, 30);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getHelskyStyle() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/Helsky.ttf"));
            return font.deriveFont(Font.PLAIN, 80);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getHelskyStyle2() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/Helsky.ttf"));
            return font.deriveFont(Font.PLAIN, 45);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getDancingScript() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./DancingScript.ttf"));
            return font.deriveFont(Font.PLAIN, 45);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getNiconne() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("./Fonts/niconne.ttf"));
            return font.deriveFont(Font.PLAIN, 35);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }
}
