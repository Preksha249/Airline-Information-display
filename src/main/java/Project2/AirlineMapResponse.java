package Project2;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class AirlineMapResponse {
	@SerializedName("version")
	int ver;
	String compiledBy;
	HashMap<String, Airline> dataMap;

	@Override
	public String toString() {
		return "AirlineMapResponse [ver=" + ver + ", compiledBy=" + compiledBy + ", dataMap=" + dataMap + "]";
	}

}
