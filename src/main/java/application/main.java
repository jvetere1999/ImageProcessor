package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Drag a file here");
        Label dropped = new Label("");
        VBox dragTarget = new VBox();
        dragTarget.getChildren().addAll(label, dropped);

        dragTarget.setOnDragOver((dragEvent) -> {
            if(dragEvent.getGestureSource() != dragTarget
                    && dragEvent.getDragboard().hasFiles()) {
                dragEvent.acceptTransferModes(TransferMode.ANY);
            }
            dragEvent.consume();
        });

        dragTarget.setOnDragDropped(dragEvent -> {
            Dragboard board = dragEvent.getDragboard();
            boolean success = false;
            if (board.hasFiles()) {
                dropped.setText(board.getFiles().toString());
                System.out.println(board.getFiles().toString());
                success = true;
            }
            dragEvent.setDropCompleted(success);
            dragEvent.consume();
        });

        StackPane root = new StackPane();
        root.getChildren().add(dragTarget);

        Scene scene = new Scene(root, 500, 250);

        stage.setTitle("Drag image");
        stage.setScene(scene);
        stage.show();
    }
    public static void main (String[] args) {
        launch(args);
    }
}
