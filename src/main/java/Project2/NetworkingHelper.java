package Project2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkingHelper {
	private static NetworkingHelper instance;

	private APIInterface service;

	private NetworkingHelper() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl(
				"https://us-central1-farefirst-test.cloudfunctions.net/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		service = retrofit.create(APIInterface.class);
	}

	public static NetworkingHelper getInstance() {
		if (instance == null)
			instance = new NetworkingHelper(); //only once

		return instance;
	}

	public APIInterface getService() {
		return service;
	}

}
