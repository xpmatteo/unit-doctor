package name.vaccari.matteo.unitdoctor;

import android.widget.*;

import name.vaccari.matteo.unitdoctor.core.UnitDoctorView;

import static java.lang.String.format;

public class AndroidUnitDoctorView implements UnitDoctorView {
  private TextView inputNumberField;
  private TextView fromUnitField;
  private TextView toUnitField;
  private TextView resultField;

  public AndroidUnitDoctorView(TextView inputNumberField, TextView fromUnitField, TextView toUnitField, TextView resultField) {
    this.inputNumberField = inputNumberField;
    this.fromUnitField = fromUnitField;
    this.toUnitField = toUnitField;
    this.resultField = resultField;
  }

  @Override
  public double inputNumber() {
    String inputString = inputNumberField.getText().toString();
    if (inputString.isEmpty())
      return 0.0;
    return Double.valueOf(inputString);
  }

  @Override
  public String fromUnit() {
    return fromUnitField.getText().toString();
  }

  @Override
  public String toUnit() {
    return toUnitField.getText().toString();
  }

  @Override
  public void showResult(double result) {
    String message = format("%.2f %s = %.2f %s", inputNumber(), fromUnit(), result, toUnit());
    resultField.setText(message);
  }

  @Override
  public void showConversionNotSupported() {
    resultField.setText("I don't know how to convert this");
  }
}
