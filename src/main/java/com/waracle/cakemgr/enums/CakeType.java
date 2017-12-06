package com.waracle.cakemgr.enums;

public enum CakeType {

	LemonCake("Lemon Cake"),
	AngelCake("Angel Cake"),
	IcedCake("Iced Caked"),
	ChoclateCake("Chocklate Cake"),
	BananaCake("Banana Cake");

	private final String displayName;

	CakeType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
