package bayern.steinbrecher.jcommander.args;

import bayern.steinbrecher.jcommander.IParameterValidator;
import bayern.steinbrecher.jcommander.IValueValidator;
import bayern.steinbrecher.jcommander.Parameter;
import bayern.steinbrecher.jcommander.ParameterException;
import bayern.steinbrecher.jcommander.validators.PositiveInteger;

public class ArgsMultiValidate {

		public static class OddIntegerParameterValidator implements IParameterValidator {
				@Override
				public void validate(String name, String value) throws ParameterException {
					if(Integer.parseInt(value) %2 != 1) throw new ParameterException("param "+name+"="+value+" is not odd");
				}
		}

		public static class LowerThan100ValueValidator implements IValueValidator<Integer> {
				@Override
				public void validate(String name, Integer value) throws ParameterException {
					if(value >= 100) throw new ParameterException("param "+name+"="+value+" is greater than 100");
				}
		}

		public static class GreaterTha0ValueValidator implements IValueValidator<Integer> {
				@Override
				public void validate(String name, Integer value) throws ParameterException {
					if(value <= 0) throw new ParameterException("param "+name+"="+value+" is lower than 1");
				}
		}

		@Parameter(names = "-age",
				validateWith = {PositiveInteger.class,OddIntegerParameterValidator.class},
				validateValueWith={GreaterTha0ValueValidator.class,LowerThan100ValueValidator.class})
		public int age=29;
}
