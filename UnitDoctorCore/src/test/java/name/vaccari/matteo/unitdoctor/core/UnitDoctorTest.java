package name.vaccari.matteo.unitdoctor.core;

import org.jmock.Expectations;
import org.jmock.integration.junit4.*;
import org.junit.*;

import static org.junit.Assert.fail;

public class UnitDoctorTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  UnitDoctorView view = context.mock(UnitDoctorView.class);
  UnitDoctor unitDoctor = new UnitDoctor(view);

  @Test
  public void convertInchesToCm() throws Exception {
    context.checking(new Expectations() {{
      allowing(view).inputNumber(); will(returnValue(1.0));
      allowing(view).fromUnit(); will(returnValue("in"));
      allowing(view).toUnit(); will(returnValue("cm"));
      oneOf(view).showResult(2.54);
    }});

    unitDoctor.convert();
  }

  @Test
  public void showsConversionNotSupported() throws Exception {
    context.checking(new Expectations() {{
      allowing(view).inputNumber(); will(returnValue(anyDouble()));
      allowing(view).fromUnit(); will(returnValue("XYZ"));
      allowing(view).toUnit(); will(returnValue("ABC"));
      oneOf(view).showConversionNotSupported();
    }});

    unitDoctor.convert();
  }

  @Test
  public void convertFahrenheitToCelsius() throws Exception {
    context.checking(new Expectations() {{
      allowing(view).inputNumber(); will(returnValue(32.0));
      allowing(view).fromUnit(); will(returnValue("F"));
      allowing(view).toUnit(); will(returnValue("C"));
      oneOf(view).showResult(0.0);
    }});

    unitDoctor.convert();
  }

  private double anyDouble() {
    return Math.random();
  }
}
