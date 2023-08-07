package com.meridal.examples.recordcollection.domain.discogs;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PriceSuggestion {

	@JsonProperty("Fair (F)")
	private Price fair;
	@JsonProperty("Good (G)")
	private Price good;
	@JsonProperty("Good Plus (G+)")
	private Price goodPlus;
	@JsonProperty("Mint (M)")
	private Price mint;
	@JsonProperty("Near Mint (NM or M-)")
	private Price nearMint;
	@JsonProperty("Poor (P)")
	private Price poor;
	@JsonProperty("Very Good Plus (VG+)")
	private Price veryGoodPlus;
	@JsonProperty("Very Good (VG)")
	private Price veryGood;

	public Price getFair() {
		return fair;
	}

	public void setFair(Price fair) {
		this.fair = fair;
	}

	public Price getGood() {
		return good;
	}

	public void setGood(Price good) {
		this.good = good;
	}

	public Price getGoodPlus() {
		return goodPlus;
	}

	public void setGoodPlus(Price goodPlus) {
		this.goodPlus = goodPlus;
	}

	public Price getMint() {
		return mint;
	}

	public void setMint(Price mint) {
		this.mint = mint;
	}

	public Price getNearMint() {
		return nearMint;
	}

	public void setNearMint(Price nearMint) {
		this.nearMint = nearMint;
	}

	public Price getPoor() {
		return poor;
	}

	public void setPoor(Price poor) {
		this.poor = poor;
	}

	public Price getVeryGoodPlus() {
		return veryGoodPlus;
	}

	public void setVeryGoodPlus(Price veryGoodPlus) {
		this.veryGoodPlus = veryGoodPlus;
	}

	public Price getVeryGood() {
		return veryGood;
	}

	public void setVeryGood(Price veryGood) {
		this.veryGood = veryGood;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
