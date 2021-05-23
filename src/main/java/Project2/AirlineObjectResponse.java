package Project2;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirlineObjectResponse {
	int version;
	String compiledBy;

	@SerializedName("dataArray")
	@Expose(serialize = true, deserialize = true)
	public ArrayList<Airline> dataArray;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCompiledBy() {
		return compiledBy;
	}

	public void setCompiledBy(String compiledBy) {
		this.compiledBy = compiledBy;
	}

	public ArrayList<Airline> getDataArray() {
		return dataArray;
	}

	public void setDataArray(ArrayList<Airline> dataArray) {
		this.dataArray = dataArray;
	}

	@Override
	public String toString() {
		return "Object [version=" + version + ", compiledBy=" + compiledBy + ", dataArray=" + dataArray + "]";
	}

}
