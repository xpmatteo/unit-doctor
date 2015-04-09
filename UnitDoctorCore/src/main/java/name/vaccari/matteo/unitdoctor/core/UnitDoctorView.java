package name.vaccari.matteo.unitdoctor.core;

public interface UnitDoctorView {
  double inputNumber();

  String fromUnit();

  String toUnit();

  void showResult(double result);

  void showConversionNotSupported();
}
