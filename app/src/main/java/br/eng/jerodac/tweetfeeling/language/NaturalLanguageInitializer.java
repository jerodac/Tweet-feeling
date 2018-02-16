package br.eng.jerodac.tweetfeeling.language;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.services.language.v1beta2.CloudNaturalLanguage;
import com.google.api.services.language.v1beta2.CloudNaturalLanguageRequestInitializer;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class NaturalLanguageInitializer {

    private static final String CLOUD_API_KEY = "AIzaSyBo6TfvBXn2aO6sZftBW8mZvKHmnQYHST8";
    private static CloudNaturalLanguage naturalLanguageService;

    public static void init() {
        naturalLanguageService =
                new CloudNaturalLanguage.Builder(
                        AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(),
                        null
                ).setCloudNaturalLanguageRequestInitializer(
                        new CloudNaturalLanguageRequestInitializer(CLOUD_API_KEY)
                ).build();
    }

    public static CloudNaturalLanguage getNaturalLanguageService() {
        return naturalLanguageService;
    }
}
