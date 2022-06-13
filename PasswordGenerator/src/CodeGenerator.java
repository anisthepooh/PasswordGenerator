
import static java.lang.String.valueOf;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This class implements the JavaFX stage and the nodes using gridPane. 
 * It also invokes the Book objects, and the logic for constructing the password. 
 * @author casperanisimow
 */
public class CodeGenerator extends Application {

    // Attributes: 
    
    /** Initilize the password generated counter */
    private int count = 0; 
    
    //Methods: 
    
    /** Gets the count variable.
    * @return the count of passwords generated.
    */
    
    int getCount() {
        return count; 
    }
    
    /** Sets the and increases the value of the count variable.
    * @param newCount get passed thourgh every time the "Generate password button is clicked.
    */
    void setCount(int newCount){
        this.count += newCount; 
    }
    
    
    /** Implementing the JavaFX GUI interface for the appllication */
    @Override
    public void start(Stage stage) throws Exception {
        
        /** Making an object of a gridPane and setting its proberties */
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText("Please write 3 verbs");
        
        
        /** Making a object of TextField, setting its text proberty and make it not editable */
        TextField codeGenerated = new TextField();
        codeGenerated.setPromptText("Password is generated here!");
        codeGenerated.setEditable(false);
        
        /** Making a object of a label, setting its text proberty to the return value of getCount(). valueOf is used to convert int to string */
        Label passwordCount = new Label(valueOf(getCount()));
        
        /** Making a object of a label, setting its text proberty */
        Label countText = new Label("Passwords generated:"); 
        
        /** Making a object of a button, setting its text proberty */
        Button copy = new Button();
        copy.setText("Click to copy!");
        
        /** Making a object of a label, setting its text proberty */
        Label verbLabel = new Label("Enter 3 verbs:");
        
        /** Making a object of a label, setting its text proberty */
        TextField verb1 = new TextField();
        verb1.setPromptText("Verb 1");
        
        /** Making a object of a label, setting its text proberty */
        TextField verb2 = new TextField();
        verb2.setPromptText("Verb 2");
        
        /** Making a object of a label, setting its text proberty */
        TextField verb3 = new TextField();
        verb3.setPromptText("Verb 3");
        
        /** Making a object of a button, setting its text proberty */
        Button btn = new Button("Generate Password");
        
        /** Making a object of a ClipboardContent and clipboard. Clipboard gets the content of the systems clipbord*/
        
        /** Making a object of a label, setting its text proberty */
        Label label = new Label("Choose a Book:"); 
        
        /** Making a object of a RadioButton, setting its text proberty */
        RadioButton HarryPotter = new RadioButton("Harry Potter"); 
        RadioButton Hobitten = new RadioButton("Hobitten"); 
        RadioButton JamesBond = new RadioButton("James Bond");
        
        /** Making a object of a ToggleGroup.*/
        ToggleGroup radioGroup = new ToggleGroup(); 
        
        /** Using the setToggleGroup to group the radiobuttons togther */
        HarryPotter.setToggleGroup(radioGroup);
        Hobitten.setToggleGroup(radioGroup);
        JamesBond.setToggleGroup(radioGroup);
        
        /** Making a object of a VBox and placing a label and the radiobuttons in it.*/
        VBox vBox = new VBox(label, HarryPotter, Hobitten, JamesBond); 
        vBox.setSpacing(10);
        
        /** Adding all the components to the grid */
        grid.add(codeGenerated, 0,5,4,1); 
        grid.add(copy, 0, 6, 2, 1);
        grid.add(countText, 2, 6);
        grid.add(passwordCount, 3, 6);
        grid.add(verbLabel, 2,0);
        grid.add(verb1, 2,1,1,1); 
        grid.add(verb2, 2,2,1,1);
        grid.add(verb3, 2,3,1,1);
        grid.add(vBox, 1,1,1,3);
        grid.add(btn, 0,4,4,1); 
        
        
        
        /** Setting the title of the stage */
        stage.setTitle("Password Generator");
        
        /** Making a object of a scene, and adding the grid and the size.*/
        Scene scene =  new Scene(grid, 400, 400);
        /** Passing scene to the setScene method */
        stage.setScene(scene);
        stage.show(); 
        
       
        
        /** selectedToggleProperty() adds a listner method to the radioGroup, that can determind which radiobutton is clicked */
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            /** The  changed method executes when a radioButton is clicked. 
             *  There are three conditionals which are checking for which of the radioButtons gets clicked.  */ 
            @Override 
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                if (radioGroup.getSelectedToggle() == HarryPotter ){

                    /** An object of HarryPotter which extends Book is made, and constructed */ 
                    Book HP = new HarryPotter("Harry Potter", "R.K. Rowling", 1997);
                    /** The addNames method is used to populate the character array */
                    HP.addNames("sirius");
                    HP.addNames("bellatrix");
                    HP.addNames("Minerva");
                    HP.addNames("Rubeus");
                    HP.addNames("Draco");
                    HP.addNames("Hermione");
                    HP.addNames("Ron");

                    /** This eventhandler are handlig the event for thee btn button  */

                    EventHandler<ActionEvent> HPEvent = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e)
                        {
                            
                       /** Assigning the string of the three textFields to varibles */      
                        String word1 = verb1.getText();   
                        String word2 = verb2.getText();
                        String word3 = verb3.getText();

                        /** Max is the size of the HP character arrayList minus 1 to match the index */ 
                        int max = HP.characters.size() - 1;
                        /** Min is the minimal value of the array */
                        int min = 0; 
                        /** Range are the value for the range of the array */
                        int range = max - min + 1; 

                        /** Sets the text proberty of codeGenerated.
                        * First a String is palced in the sequence followed after the getYear method which gets the publish year of the book.
                        * Thereafter a random character from the character array is called. To get a random index number the Math.random() method is used.
                        * After this, the first verb is placed into the sequence. To make the first latter of every word large, substring and toUpperCase() method is used
                         */ 
                         try { codeGenerated.setText("In" + HP.getYear() + HP.characters.get((int) ((Math.random() * range) + min))
                                + word1.substring(0,1).toUpperCase() + word1.substring(1)
                                + HP.characters.get((int) ((Math.random() * range) + min)) + word2.substring(0,1).toUpperCase() + word2.substring(1)
                                + HP.characters.get((int) ((Math.random() * range) + min)) + word3.substring(0,1).toUpperCase() + word3.substring(1)); 
                         } catch (StringIndexOutOfBoundsException ex) {
                             System.out.println("Verbs are missing");
                             alert.showAndWait();
                         }

                        /** The count variable is set to + 1  */
                        setCount(1);
                        /** Updates the passwordCount label. */
                        passwordCount.setText(String.valueOf(getCount())); 
                    }
                };   
                /** calls the eventhandler when the button is clicked */    
                btn.setOnAction(HPEvent);

                } else if (radioGroup.getSelectedToggle() == Hobitten) {
                    Book H = new Hobitten("Hobitten", "J.R.R. Tolkien", 1937 );
                    H.addNames("Bilbo");
                    H.addNames("Sauron");
                    H.addNames("Saruman");
                    H.addNames("Arwen");
                    H.addNames("Elrond");
                    H.addNames("Gollum");
                    H.addNames("Gandalf");

                    EventHandler<ActionEvent> HEvent = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e)
                        {

                        String word1 = verb1.getText();
                        String word2 = verb2.getText();
                        String word3 = verb3.getText();

                        int max = H.characters.size() - 1;
                        int min = 1; 
                        int range = max - min + 1; 

                        try {codeGenerated.setText("In" + H.getYear() + H.characters.get((int) ((Math.random() * range) + min)) + word1.substring(0,1).toUpperCase() + word1.substring(1)
                                + H.characters.get((int) ((Math.random() * range) + min)) + word2.substring(0,1).toUpperCase() + word2.substring(1)
                                + H.characters.get((int) ((Math.random() * range) + min)) + word3.substring(0,1).toUpperCase() + word3.substring(1));
                        } catch (StringIndexOutOfBoundsException ex) {
                             System.out.println("Verbs are missing");
                             alert.showAndWait();

                         }

                        setCount(1);
                        passwordCount.setText(String.valueOf(getCount()));
                    }
                };

            btn.setOnAction(HEvent);
        } else if (radioGroup.getSelectedToggle() == JamesBond) {
                    Book JB = new JamesBond("Hobitten", "Ian Flemming", 1953 );
                    JB.addNames("007");
                    JB.addNames("FelixLeiter");
                    JB.addNames("M");
                    JB.addNames("MissMoneyPenny");
                    JB.addNames("Q");
                    JB.addNames("SylviaTrench");
                    JB.addNames("Blofeld");

                    EventHandler<ActionEvent> JBEvent = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e)
                        {

                        String word1 = verb1.getText();
                        String word2 = verb2.getText();
                        String word3 = verb3.getText();

                        int max = JB.characters.size() - 1;
                        int min = 1; 
                        int range = max - min + 1; 


                        try {codeGenerated.setText("In" + JB.getYear() + JB.characters.get((int) ((Math.random() * range) + min)) + word1.substring(0,1).toUpperCase() + word1.substring(1)
                                + JB.characters.get((int) ((Math.random() * range) + min)) + word2.substring(0,1).toUpperCase() + word2.substring(1)
                                + JB.characters.get((int) ((Math.random() * range) + min)) + word3.substring(0,1).toUpperCase() + word3.substring(1));
                        } catch (StringIndexOutOfBoundsException ex) {
                             System.out.println("Verbs are missing");
                             alert.showAndWait();

                         } 

                        setCount(1);
                        passwordCount.setText(String.valueOf(getCount()));

                    }
                };

            btn.setOnAction(JBEvent);
        } 

        } 
        });
        
        /** This setOnAction method is set on the copybutton.
         * A new object of Clipboard addn ClipboardContent are created.
         * The content is placed in the clipboard, from the textfield codeGenerated.
         */ 
        copy.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(codeGenerated.getText());
                clipboard.setContent(content);
            }
            
        });

    }
    
    /** The main method where the stage get lunched */
    public static void main(String[] args) {
              
        launch();
    }
}
