package name.vaccari.matteo.unitdoctor;

import android.test.AndroidTestCase;
import android.widget.*;

public class AndroidUnitDoctorViewTest extends AndroidTestCase {
  EditText inputNumberField;
  TextView fromUnitField;
  TextView toUnitField;
  TextView resultField;
  AndroidUnitDoctorView view;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    inputNumberField = new EditText(getContext());
    fromUnitField = new TextView(getContext());
    toUnitField = new TextView(getContext());
    resultField = new TextView(getContext());
    view = new AndroidUnitDoctorView(inputNumberField, fromUnitField, toUnitField, resultField);
  }

  public void testReturnInputValues() throws Exception {
    inputNumberField.setText("3.14159");
    fromUnitField.setText("FROM");
    toUnitField.setText("TO");

    assertEquals(3.14159, view.inputNumber());
    assertEquals("FROM", view.fromUnit());
    assertEquals("TO", view.toUnit());
  }

  public void testDoesNotBreakWhenInputFieldIsEmpty() throws Exception {
    inputNumberField.setText("");
    assertEquals(0.0, view.inputNumber());
  }

  public void testSetsResult() {
    inputNumberField.setText("3.14159");
    fromUnitField.setText("A");
    toUnitField.setText("B");

    view.showResult(1.123456789);

    assertEquals("3.14 A = 1.12 B", resultField.getText());
  }

  public void testShowsError() {
    view.showConversionNotSupported();
    assertEquals("I don't know how to convert this", resultField.getText());
  }
}
