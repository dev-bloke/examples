package com.meridal.examples.recordcollection.domain.discogs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Price {

	private String currency;
	private BigDecimal value;

	public Price() {
		// Do nothing
	}

	protected Price(final String currency, final String value) {
		this.currency = currency;
		try {
			this.value = new BigDecimal(value);
		}
		catch (Exception e) {
			// Do nothing.
		}
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValueTwoDecimalPlaces() {
		return this.value != null ? this.value.setScale(2, RoundingMode.CEILING) : null;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		try {
			builder.append(Currency.getInstance(this.currency).getSymbol())
				.append(this.getValueTwoDecimalPlaces().toString());
		}
		catch (Exception e) {
			builder.append("-");
		}
		return builder.toString();
	}
}
