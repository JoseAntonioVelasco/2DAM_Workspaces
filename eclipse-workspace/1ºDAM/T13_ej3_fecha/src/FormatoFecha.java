import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.MaskFormatter;

public class FormatoFecha extends MaskFormatter{
	private SimpleDateFormat formato;
	
	public FormatoFecha() throws ParseException {
		super("##/##/## ##:##:##");
		formato = new SimpleDateFormat("dd/MM/yy kk:mm:ss");
	}
	
	public Object stringToValue(String text) throws ParseException{
		return formato.parseObject(text);
	}
	
	public String valueToString(Object value) throws ParseException{
		if(value instanceof Date) return formato.format((Date)value);
		return formato.format(new Date());
	}
}
