package br.eng.jerodac.tweetfeeling.units;

import com.google.api.services.language.v1beta2.model.AnnotateTextResponse;

import org.junit.Test;

import br.eng.jerodac.tweetfeeling.bussiness.Feeling;
import br.eng.jerodac.tweetfeeling.language.NaturalLanguageHelper;
import br.eng.jerodac.tweetfeeling.language.NaturalLanguageInitializer;
import br.eng.jerodac.tweetfeeling.models.Model;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 20/02/2018.
 */
public class NaturalLanguageUnitTest {

    @Test
    public void testNaturalLanguageLibVerifyAuth() {
        Single.create(
                (SingleOnSubscribe<AnnotateTextResponse>) emitter -> emitter.onSuccess(
                        NaturalLanguageInitializer.getNaturalLanguageService()
                                .documents()
                                .annotateText(NaturalLanguageHelper.getRequest("Test")).execute()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AnnotateTextResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(AnnotateTextResponse annotateTextResponse) {
                        assert (annotateTextResponse.getDocumentSentiment() != null);
                    }

                    @Override
                    public void onError(Throwable e) {
                        assert false;
                    }
                });
    }

    @Test
    public void testNaturalLanguageLibHappyScore() {
        Single.create(
                (SingleOnSubscribe<AnnotateTextResponse>) emitter -> emitter.onSuccess(
                        NaturalLanguageInitializer.getNaturalLanguageService()
                                .documents()
                                .annotateText(NaturalLanguageHelper.getRequest("I am very happy!!")).execute()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AnnotateTextResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(AnnotateTextResponse annotateTextResponse) {
                        Model mModel = new Model();
                        mModel.setScoreFeeling(annotateTextResponse.getDocumentSentiment().getScore());
                        assert (mModel.getFeeling() == Feeling.HAPPY);
                    }

                    @Override
                    public void onError(Throwable e) {
                        assert false;
                    }
                });
    }

    @Test
    public void testNaturalLanguageLibNeutralScore() {
        Single.create(
                (SingleOnSubscribe<AnnotateTextResponse>) emitter -> emitter.onSuccess(
                        NaturalLanguageInitializer.getNaturalLanguageService()
                                .documents()
                                .annotateText(NaturalLanguageHelper.getRequest("only neutral")).execute()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AnnotateTextResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(AnnotateTextResponse annotateTextResponse) {
                        Model mModel = new Model();
                        mModel.setScoreFeeling(annotateTextResponse.getDocumentSentiment().getScore());
                        assert (mModel.getFeeling() == Feeling.NEUTRAL);
                    }

                    @Override
                    public void onError(Throwable e) {
                        assert false;
                    }
                });
    }

    @Test
    public void testNaturalLanguageLibSadScore() {
        Single.create(
                (SingleOnSubscribe<AnnotateTextResponse>) emitter -> emitter.onSuccess(
                        NaturalLanguageInitializer.getNaturalLanguageService()
                                .documents()
                                .annotateText(NaturalLanguageHelper.getRequest("sad and upset")).execute()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AnnotateTextResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(AnnotateTextResponse annotateTextResponse) {
                        Model mModel = new Model();
                        mModel.setScoreFeeling(annotateTextResponse.getDocumentSentiment().getScore());
                        assert (mModel.getFeeling() == Feeling.SAD);
                    }

                    @Override
                    public void onError(Throwable e) {
                        assert false;
                    }
                });
    }
}
