package application;

import java.net.URL;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;

import java.util.ResourceBundle;














import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.Bindings;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
 
class Bill {
 
    // Define the property
    private StringProperty amountDue = new SimpleStringProperty();
 
    // Define a getter for the property's value
    public final String getAmountDue(){return amountDue.get();}
 
    // Define a setter for the property's value
    public final void setAmountDue(String value){amountDue.set(value);}
 
     // Define a getter for the property itself
    public StringProperty amountDueProperty() {return amountDue;}
 
}


	
public class MyController implements Initializable {

	int pos;
	Bill bill1 = new Bill();
	Bill electricBill = new Bill();

	public  volatile static String data = "data is";
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("trut wkepw wpedok "
				+ "wrpfoke rpfoek fp"
				+ "eworkf peofkrf efef "
				);
	
		hideHTMLEditorToolbars(html1);
		
		
		 
	       electricBill.amountDueProperty().addListener(new ChangeListener(){
	        @Override public void changed(ObservableValue o,Object oldVal, 
	                 Object newVal){
	             //System.out.println("Electric bill has changed!");
	             data +=" " + newVal;
	        }
	      });
	     
	      electricBill.setAmountDue("100.00");
	    
		
	}

	
	
	@FXML
	public HTMLEditor html1;

	@FXML
	public AnchorPane pane;
	
	
	@FXML
	public TextArea text1;
	
	@FXML
	public Text txt1;
	
	@FXML
	public Button btn1;

	@FXML
	public Button btn2;

	public void btn2action(ActionEvent event) {
		
		System.out.println("----222");
		
	}
	
	
	public void enableButton(ActionEvent event) {
		System.out.println("Click!");

		
		btn1.setId("button");
		 Task<Integer> task = new Task<Integer>() {
	         @Override protected Integer call() throws Exception {
	             int iterations;
	             for (iterations = 0; iterations < 100; iterations++) {
	            	 
	                 if (isCancelled()) {
	                     updateMessage(data);
	                     break;
	                 }
	                 updateMessage(data);

	                 Thread.sleep(100);
	                
	                 
	             }
	             
	             return iterations;
	         }
	     };

	     
		 Task<Integer> dataChange = new Task<Integer>() {
	         @Override protected Integer call() throws Exception {
	             int iterations;
	             for (iterations = 0; iterations < 100; iterations++) {
	            	 
	                 if (isCancelled()) {
	                     break;
	                 }
	                 Thread.sleep(99);
	                 data +=" " + iterations;
	     	        //bill1.setAmountDue();
	          
	     	       //System.out.println(bill1.getAmountDue());
	                 ObservableList<Node> list = pane.getChildren();
	                 Node list1 = pane.lookup("button");
	                 
	                 Button btn = (Button) list1;
	             //btn.setText("SSSSSSedd");
	                 
	                 updateMessage("new message dfce rpfoke pfo");
	             }
	             
	             return iterations;
	         }

	     
	     };
	     
	     
	     //html1.addEventHandler(eventType, eventHandler);
	     html1.addEventHandler(DragEvent.DRAG_ENTERED, 
                 new EventHandler<DragEvent>() {
                     
					@Override
					public void handle(DragEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("in the handler");
						
					}});

	     html1.setId("main");
	     html1.setHtmlText(data);
	     
	     btn1.textProperty().bind(dataChange.messageProperty());
	     
	     
	     new Thread(task).start();
	     new Thread(dataChange).start();
	     
	     
	     
	     
	     

	}

			public static void updateView() {
				// TODO Auto-generated method stub
				//html1.setHtmlText(data);
				
			}

	
	
	public static void hideHTMLEditorToolbars(final HTMLEditor editor)
	{
	    editor.setVisible(false);
	    Platform.runLater(new Runnable()
	    {
	        @Override
	        public void run()
	        {
	            Node[] nodes = editor.lookupAll(".tool-bar").toArray(new Node[0]);
	            for(Node node : nodes)
	            {
	                node.setVisible(false);
	                node.setManaged(false);
	            }
	            editor.setVisible(true);
	        }
	    });
	}
}
