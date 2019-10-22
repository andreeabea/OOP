
public class ConvModel {

	private static final float RON_TO_EUR = 0.22f;
    private static final float RON_TO_USD = 0.25f;
    private static final float USD_TO_RON = 4.07f;
    private static final float USD_TO_EUR = 0.88f;
    private static final float EUR_TO_RON = 4.66f;
    private static final float EUR_TO_USD = 1.14f;

    private float initialValue;
    private float convertedValue;

    public ConvModel() {
        reset();
    }

    public void setInitialValue(float initialValue) {
        this.initialValue = initialValue;
    }

    public float getConvertedValue() {
        return convertedValue;
    }

    public void reset() {
        initialValue = convertedValue = 0f;
    }

    public void convert(String from, String to)
    {
        switch (from) 
        {
            case "EUR":
                if (to.equals("RON")) {
                    convertedValue = initialValue * EUR_TO_RON;
                } else if (to.equals("USD")) {
                    convertedValue = initialValue * EUR_TO_USD;
                } else {
                    convertedValue = initialValue;
                }
                break;
                
            case "USD":
                if (to.equals("RON")) {
                    convertedValue = initialValue * USD_TO_RON;
                } else if (to.equals("EUR")) {
                    convertedValue = initialValue * USD_TO_EUR;
                } else {
                    convertedValue = initialValue;
                }
                break;
                
            case "RON":
                if (to.equals("EUR")) {
                    convertedValue = initialValue * RON_TO_EUR;
                } else if (to.equals("USD")) {
                    convertedValue = initialValue * RON_TO_USD;
                } else {
                    convertedValue = initialValue;
                }
        }
    }
}
