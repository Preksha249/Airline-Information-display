package Project2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

	@GET("/airline")
	Call<Airline> singleAirline();

	@GET("/airlines")
	Call<List<Airline>> getAirlines();

	@GET("/airlines")
	Call<List<Airline>> limitAirlines(@Query("limit") String limit);

	@GET("/airlines")
	Call<List<Airline>> limitAirlinesShuffle(@Query("limit") String limit, @Query("shuffle") boolean b);

	@GET("/airline")
	Call<Airline> searchAirline(@Query("q") String search);

	@GET("/airlines")
	Call<AirlineObjectResponse> objectAirlines(@Query("responseType") String response);

	@GET("/airlines")
	Call<AirlineMapResponse> mapAirlines(@Query("responseType") String response);

}
