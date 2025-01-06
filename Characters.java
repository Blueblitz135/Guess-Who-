package guessWho;

/**
 * This Class will create characters with their corresponding attributes
 */

public class Characters {

	/**
	 * Character Attributes
	 */
	
	
	private String skinColor;
	private String age;
	private String hairColor;
	private String gender;
	private String eyeColor;
	private String name;

	private boolean hasGlasses;
	private boolean hasHat;
	private boolean hasFacialHair;
	private boolean isValidChoice;

	
	/**
	 * Constructor sets up characters
	 * @param skinColor
	 * @param age
	 * @param hairColor
	 * @param eyeColor
	 * @param name
	 * @param hasGlasses
	 * @param hasHat
	 * @param hasFacialHair
	 * @param isValidChoice
	 */
	
	public Characters(String skinColor, String age, String hairColor, String gender, String eyeColor, String name, boolean hasGlasses,
			boolean hasHat, boolean hasFacialHair) {

		setSkinColor(skinColor);
		setAge(age);
		setHairColor(hairColor);
		setGender(gender);
		setEyeColor(eyeColor);
		setName(name);
		setHasGlasses(hasGlasses);
		setHasHat(hasHat);
		setHasFacialHair(hasFacialHair);
		setIsValidChoice(true);

	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getSkinColor() {
		return skinColor;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAge() {
		return age;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setHasGlasses(boolean hasGlasses) {
		this.hasGlasses = hasGlasses;
	}

	public boolean getHasGlasses() {
		return hasGlasses;
	}

	public void setHasHat(boolean hasHat) {
		this.hasHat = hasHat;
	}

	public boolean getHasHat() {
		return hasHat;
	}

	public void setHasFacialHair(boolean hasFacialHair) {
		this.hasFacialHair = hasFacialHair;
	}

	public boolean getHasFacialHair() {
		return hasFacialHair;
	}

	public void setIsValidChoice(boolean isValidChoice) {
		this.isValidChoice = isValidChoice;
	}

	public boolean getIsValidChoice() {
		return isValidChoice;
	}

}