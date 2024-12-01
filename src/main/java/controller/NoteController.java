package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Note;
import model.Notebook;
import view.NoteApplication;

public class NoteController {
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;
    @FXML
    private VBox notesContainer;
    @FXML
    private Button addButton;

    private Notebook notebook;

    public NoteController() {
        this.notebook = new Notebook();
    }

    @FXML
    private void initialize() {
        addButton.setOnAction(event -> addNote());
    }

    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();
        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);
            displayNotes();
            titleField.clear();
            contentArea.clear();
        }
    }

    private void displayNotes() {
        notesContainer.getChildren().clear();
        for (Note note : notebook.getNotes()) {
            TextArea noteDisplay = new TextArea(note.getTitle() + "\n" + note.getContent());
            noteDisplay.setEditable(false);
            notesContainer.getChildren().add(noteDisplay);
        }
    }

    public static void main(String[] args) {
        NoteApplication.launch(NoteApplication.class);
    }
}
