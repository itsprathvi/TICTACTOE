package frontEnds;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Fonts.FontRender;

public class frontEndUtil {
    int SIZE = 700;
    int BOARD_SIZE = 500;
    int CELL_SIZE = BOARD_SIZE / 3;

    Color BACKGROUND_COLOR = new Color(0x1c1c1c);
    Color CELL_COLOR = new Color(0x2a2a2a);
    Color O_COLOR = new Color(0xeded63);
    Color X_COLOR = new Color(0x63ebed);
    Color TEXT_COLOR = new Color(0xefefef);
    Color TEXT_COLOR_LITE = new Color(0x3e3e3e);
    Color WINNING_PAIRS = new Color(0x63ed9c);

    Font fontHelsky = FontRender.getHelskyStyle();
    Font fontHelsky2 = FontRender.getHelskyStyle2();
    Font fontNewsPaper = FontRender.getNewsPaperStyle();
    Font fontNewsPaper3 = FontRender.getNewsPaperStyle3();
    Font fontNewsPaper2 = FontRender.getNiconne();
    Font fontReMachine = FontRender.getRemachineStyle();

    Border borderCell = BorderFactory.createLineBorder(BACKGROUND_COLOR, 3);
}
