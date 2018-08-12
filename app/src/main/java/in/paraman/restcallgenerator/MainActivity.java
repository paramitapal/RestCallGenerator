package in.paraman.restcallgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import in.paraman.restcallgenerator.model.RequestObject;
import in.paraman.restcallgenerator.restController.CallBackForRestResponse;
import in.paraman.restcallgenerator.restController.CallGenerator;
import in.paraman.restcallgenerator.restController.RestInterface;
import in.paraman.restcallgenerator.restController.ServiceManager;
import retrofit2.Call;

/**
 * This class is responsible for making custom Rest call and retrieve JSON data. It uses the
 * {@link RestInterface} as a contract between this class and {@link ServiceManager} class.
 * Created by Paramita Pal 11/08/2018
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * onCreate() gets executed only once.
     * @param savedInstanceState Saves the state of the state during configuration change
     * Created by 11/08/2018
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Call to load JSON data from Rest API
        loadJson();
    }


    /**
     * Responsible to get the JSON data through Retrofit
     */
    private void loadJson()
    {
        Call<List<RequestObject>> mGetInfoAPICall;
        RestInterface apiService= ServiceManager.get().createService(RestInterface.class);
        mGetInfoAPICall = apiService.getJSON();
        CallGenerator.getCall().createCall(mGetInfoAPICall, new CallBackForRestResponse() {
            @Override
            public <T> List<T> onSuccess(List<T> T) {
              // Do your stuff with the response received
                return null;
            }
        });

    }
}
