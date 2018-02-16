package br.eng.jerodac.tweetfeeling.language;

import com.google.api.services.language.v1beta2.model.AnnotateTextRequest;
import com.google.api.services.language.v1beta2.model.Document;
import com.google.api.services.language.v1beta2.model.Features;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class NaturalLanguageHelper {

    public static AnnotateTextRequest getRequest(String text) {
        Document document = new Document();
        document.setType("PLAIN_TEXT");
        document.setLanguage("en-US");
        document.setContent(text);

        Features features = new Features();
        features.setExtractEntities(true);
        features.setExtractDocumentSentiment(true);

        final AnnotateTextRequest request = new AnnotateTextRequest();
        request.setDocument(document);
        request.setFeatures(getFeatures());
        return request;
    }

    private static Features getFeatures() {
        return new Features()
                .setExtractEntities(true)
                .setExtractDocumentSentiment(true);
    }
}
