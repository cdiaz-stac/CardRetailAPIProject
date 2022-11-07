package com.cognixia.jump.model;

import javax.validation.constraints.NotBlank;

import com.mongodb.lang.Nullable;

public class Statistics {
	
	@NotBlank
	private String manaCost;
	
	@NotBlank
	private String manaColor;
	
	@NotBlank
	private String expansionSymbol;
	
	@NotBlank
	private String typeLine;
	
	@Nullable
	private String textBox;
	
	@Nullable
	private String strength;
	
	@Nullable
	private String toughness;
	
	public Statistics() {
		
	}

	public Statistics(@NotBlank String manaCost, @NotBlank String manaColor, @NotBlank String expansionSymbol,
			@NotBlank String typeLine, String textBox, String strength, String toughness) {
		super();
		this.manaCost = manaCost;
		this.manaColor = manaColor;
		this.expansionSymbol = expansionSymbol;
		this.typeLine = typeLine;
		this.textBox = textBox;
		this.strength = strength;
		this.toughness = toughness;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public String getManaColor() {
		return manaColor;
	}

	public void setManaColor(String manaColor) {
		this.manaColor = manaColor;
	}

	public String getExpansionSymbol() {
		return expansionSymbol;
	}

	public void setExpansionSymbol(String expansionSymbol) {
		this.expansionSymbol = expansionSymbol;
	}

	public String getTypeLine() {
		return typeLine;
	}

	public void setTypeLine(String typeLine) {
		this.typeLine = typeLine;
	}

	public String getTextBox() {
		return textBox;
	}

	public void setTextBox(String textBox) {
		this.textBox = textBox;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	@Override
	public String toString() {
		return "Statistics [manaCost=" + manaCost + ", manaColor=" + manaColor + ", expansionSymbol=" + expansionSymbol
				+ ", typeLine=" + typeLine + ", textBox=" + textBox + ", strength=" + strength + ", toughness="
				+ toughness + "]";
	}
	
	
}
