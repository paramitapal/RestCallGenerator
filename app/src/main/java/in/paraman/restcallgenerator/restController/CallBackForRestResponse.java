package in.paraman.restcallgenerator.restController;

import java.util.List;

/**
 * Callback on valid success response
 */
public interface CallBackForRestResponse {

    <T> List<T> onSuccess(List<T> T);
}
