package name.vaccari.matteo.unitdoctor.core;

public class UnitDoctor {
  private UnitDoctorView view;

  public UnitDoctor(UnitDoctorView view) {
    this.view = view;
  }

  public void convert() {
    double inputNumber = view.inputNumber();
    if (view.fromUnit().equals("in") && view.toUnit().equals("cm"))
      view.showResult(inputNumber * 2.54);
    else if (view.fromUnit().equals("F") && view.toUnit().equals("C"))
      view.showResult((inputNumber - 32) * 5.0/9.0);
    else
      view.showConversionNotSupported();
  }
}
