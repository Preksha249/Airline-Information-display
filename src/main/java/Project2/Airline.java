package Project2;

public class Airline {
	String name;
	String code;
	String imageUrl;
	Boolean isAvailabe;
	Integer dailyFlights;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getIsAvailabe() {
		return isAvailabe;
	}

	public void setIsAvailabe(Boolean isAvailabe) {
		this.isAvailabe = isAvailabe;
	}

	public Integer getDailyFlights() {
		return dailyFlights;
	}

	public void setDailyFlights(Integer dailyFlights) {
		this.dailyFlights = dailyFlights;
	}

	@Override
	public String toString() {
		return "airlines [name=" + name + ", code=" + code + ", imageUrl=" + imageUrl + ", isAvailabe=" + isAvailabe
				+ ", dailyFlights=" + dailyFlights + "]\n";
	}

}
