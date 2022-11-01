package Scenes;
import Panes.RulesPane;
import Common.Const;
import javafx.scene.Scene;

public class RulesScreen extends Scene {
    public RulesScreen() {
        super(new RulesPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
