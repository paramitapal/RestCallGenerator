package in.paraman.restcallgenerator.restController;

import java.util.List;

import in.paraman.restcallgenerator.model.RequestObject;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This interface gives the URL link to get the required JSON data
 * Created by Paramita Pal 11/08/2018
 */
public interface RestInterface {

    @GET("/stepsToFollow/")
    Call<List<RequestObject>> getJSON();
}


