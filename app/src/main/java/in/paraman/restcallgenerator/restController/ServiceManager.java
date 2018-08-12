package in.paraman.restcallgenerator.restController;

import in.paraman.restcallgenerator.constants.AppConstants;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is used to create services with a given HTTP Url. It accepts any type of service
 * and returns Retrofit Instance to the required class.
 * Created by Paramita Pal 11/08/2018
 */
public class ServiceManager {
    private static ServiceManager sServiceManager;

    /**
     * Gets the instance of the web services implementation.
     *
     * @return the singleton instance.
     */
    public static ServiceManager get() {
        if (sServiceManager == null) {
            sServiceManager = new ServiceManager();
        }
        return sServiceManager;
    }

    /**
     * Creates the services for a given HTTP Url, useful when testing
     * through multiple endpoints and unit testing
     *
     * @param clazz the service class.
     * @param <T>   type of the service.
     * @return the created services implementation.
     */
    public <T> T createService(Class<T> clazz) {
        return createService(clazz, HttpUrl.parse(AppConstants.STEP_URL));
    }

    /**
     * Creates the services for a given HTTP Url, useful when testing
     * through multiple endpoints and unit testing
     *
     * @param clazz   the service class.
     * @param httpUrl the endpoint
     * @param <T>     type of the service.
     * @return the created services implementation.
     */
    private  <T> T createService(Class<T> clazz, HttpUrl httpUrl) {
        Retrofit retrofit = getRetrofit(httpUrl);
        return retrofit.create(clazz);
    }

    public <T> T createService(Class<T> clazz, Retrofit retrofit) {
        return retrofit.create(clazz);
    }

    private Retrofit getRetrofit(HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(createClient())
                .addConverterFactory(getConverter())
                .build();
    }

    /**
     * Scope to get Plain Retrofit via HTTPClient
     * @param httpUrl the endpoint
     * @return the Retrofit instance
     */
    public Retrofit getPlainRetrofit(HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(getConverter())
                .build();
    }

    /**
     * Converter that maps the JSON data to Java object
     * @return GSon converter
     */
    private Converter.Factory getConverter() {
        return GsonConverterFactory.create();
    }


    private OkHttpClient createClient() {
        return new OkHttpClient.Builder().addInterceptor(new RestInterceptor()).build();
    }

}