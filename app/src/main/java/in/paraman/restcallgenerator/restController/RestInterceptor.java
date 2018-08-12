package in.paraman.restcallgenerator.restController;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Paramita Pal 11/08/2018
 */

public class RestInterceptor implements Interceptor {

    /**
     * Interceptors add, remove, or transform headers on the request
     * or response.
     */

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request);
    }
}
