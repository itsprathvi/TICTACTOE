package frontEnds;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Fonts.FontRender;

public class frontEndUtil {
    protected int SIZE = 700;
    protected int BOARD_SIZE = 500;
    protected int CELL_SIZE = BOARD_SIZE / 3;

    protected Color BACKGROUND_COLOR = new Color(0x1c1c1c);
    protected Color CELL_COLOR = new Color(0x2a2a2a);
    protected Color O_COLOR = new Color(0xeded63);
    protected Color X_COLOR = new Color(0x63ebed);
    protected Color TEXT_COLOR = new Color(0xefefef);
    protected Color TEXT_COLOR_LITE = new Color(0x3e3e3e);
    protected Color WINNING_PAIRS = new Color(0x63ed9c);

    protected Font fontHelsky = FontRender.getHelskyStyle();
    protected Font fontHelsky2 = FontRender.getHelskyStyle2();
    protected Font fontNewsPaper = FontRender.getNewsPaperStyle();
    protected Font fontNewsPaper3 = FontRender.getNewsPaperStyle3();
    protected Font fontNewsPaper2 = FontRender.getNiconne();
    protected Font fontReMachine = FontRender.getRemachineStyle();

    protected Border borderCell = BorderFactory.createLineBorder(BACKGROUND_COLOR, 3);
}
