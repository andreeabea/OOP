import java.awt.event.*;

public class ConvController {

	private ConvView view;
    private ConvModel model;

    public ConvController(ConvModel model, ConvView view) 
    {
        this.view = view;
        this.model = model;
        view.addButtonListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener 
    {   
        public void actionPerformed(ActionEvent e) 
        {
            String userInput = "";
            try {
                userInput = view.getInput();
                model.setInitialValue(Float.parseFloat(userInput));
                model.convert(view.getFromCurrency(), view.getToCurrency());
                view.setLabelValue(view.getFromCurrency(), view.getToCurrency());

                String result = String.valueOf(model.getConvertedValue());
                view.setResult(result);
                
            } catch (NumberFormatException e1) {
                view.showError("Bad input: '" + userInput + "'");
            }
        }
    }
}
