package utep.cs3331.lab5.players;

public class Players {

	private String name;
	private String expertise;
	private String color;
	
	public Players() {
	}
	
	public Players(String name, String expertise, String color) {
		this.name = name;
		this.expertise = expertise;
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	
	public String getExpertise() {
		return expertise;
	}
	
	public String getColor() {
		return color;
	}
}
