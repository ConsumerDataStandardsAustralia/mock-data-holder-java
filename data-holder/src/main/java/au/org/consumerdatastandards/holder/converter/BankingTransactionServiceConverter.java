package au.org.consumerdatastandards.holder.converter;

import au.org.consumerdatastandards.holder.model.BankingTransactionDetailExtendedData;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BankingTransactionServiceConverter implements AttributeConverter<BankingTransactionDetailExtendedData.Service, String> {
	@Override
	public String convertToDatabaseColumn(BankingTransactionDetailExtendedData.Service attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public BankingTransactionDetailExtendedData.Service convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(BankingTransactionDetailExtendedData.Service.values())
				.filter(c -> c.toString().equals(code))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
