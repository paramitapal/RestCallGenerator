package in.paraman.restcallgenerator.restController;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class makes the Retrofit call and gets response through onResponse() and throws exception
 * on failed request through onFailure()
 * Created by Paramita Pal 11/08/2018
 */
public class CallGenerator {

    private static CallGenerator mCallGenerator;

    /**
     * Get instance of CallGenerator
     * @return singleton instance
     */
    public static CallGenerator getCall()
    {
        if (mCallGenerator == null) {
            mCallGenerator = new CallGenerator();
        }
        return mCallGenerator;
    }

    public <T> void createCall(Call<List<T>> T, final CallBackForRestResponse callBackForRestResponse) {
        T.enqueue(new Callback<List<T>>() {
            @Override
            public void onResponse(@NonNull Call<List<T>> call, @NonNull Response<List<T>> response) {

                callBackForRestResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<T>> call,@NonNull Throwable t) {

            }

        });

    }


}
