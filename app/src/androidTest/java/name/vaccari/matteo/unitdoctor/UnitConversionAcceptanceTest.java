package name.vaccari.matteo.unitdoctor;

import android.test.*;
import android.widget.TextView;

public class UnitConversionAcceptanceTest extends ActivityInstrumentationTestCase2<MainActivity> {

  public UnitConversionAcceptanceTest() {
    super(MainActivity.class);
  }

  public void testInchesToCentimeters() throws Throwable {
    givenTheUserSelectedConversion("in", "cm");
    whenTheUserEnters("2");
    thenTheResultIs("2.00 in = 5.08 cm");
  }

  public void testFahrenheitToCelsius() throws Throwable {
    givenTheUserSelectedConversion("F", "C");
    whenTheUserEnters("50");
    thenTheResultIs("50.00 F = 10.00 C");
  }

  public void testUnknownUnits() throws Throwable {
    givenTheUserSelectedConversion("ABC", "XYZ");
    thenTheResultIs("I don't know how to convert this");
  }

  private void givenTheUserSelectedConversion(String fromUnit, String toUnit) throws Throwable {
    setText(R.id.fromUnit, fromUnit);
    setText(R.id.toUnit, toUnit);
  }

  private void whenTheUserEnters(String inputNumber) throws Throwable {
    setText(R.id.inputNumber, inputNumber);
  }

  private void setText(final int id, final String text) throws Throwable {
    final TextView field = getField(id);
    runTestOnUiThread(new Runnable() {
      @Override
      public void run() {
        field.setText(text);
      }
    });
  }

  private void thenTheResultIs(String expectedResult) {
    assertEquals(expectedResult, getField(R.id.result).getText());
  }

  private TextView getField(int id) {
    return (TextView) getActivity().findViewById(id);
  }
}