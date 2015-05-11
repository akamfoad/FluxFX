package todoflux.views.item;

import eu.lestard.fluxfx.View;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import todoflux.actions.ChangeStateAction;
import todoflux.actions.DeleteItemAction;
import todoflux.data.TodoItem;

public class ItemView implements View{


    @FXML
    public Label contentLabel;

    @FXML
    public CheckBox completed;

    @FXML
    public TextField contentInput;

    private String id;

    public void update(TodoItem item) {
        id = item.getId();
        contentLabel.setText(item.getText());
        completed.setSelected(item.isCompleted());

        completed.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            publishAction(new ChangeStateAction(id, newValue));
        }));
    }

    public void delete() {
        publishAction(new DeleteItemAction(id));
    }
}
