package br.eng.jerodac.tweetfeeling.controllers;

import com.google.api.services.language.v1beta2.model.AnnotateTextResponse;

import br.eng.jerodac.tweetfeeling.language.NaturalLanguageHelper;
import br.eng.jerodac.tweetfeeling.language.NaturalLanguageInitializer;
import br.eng.jerodac.tweetfeeling.models.Model;
import br.eng.jerodac.tweetfeeling.presenters.Presenter;
import br.eng.jerodac.tweetfeeling.utils.AppLog;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class MainController {

    private Model mModel;

    private static MainController INSTANCE;

    public static MainController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainController();
        }
        return INSTANCE;
    }

    private MainController() {
        mModel = new Model();
    }

    public Model getModel() {
        return mModel;
    }

    public void setTagTweet(String tag) {
        mModel.setTweetTag(tag);
    }

    public void setTweetText(String tweetText) {
        mModel.setTweetText(tweetText);
    }

    public void analytzText(Presenter presenter) {
        Single.create(
                (SingleOnSubscribe<AnnotateTextResponse>) emitter -> emitter.onSuccess(
                        NaturalLanguageInitializer.getNaturalLanguageService()
                                .documents()
                                .annotateText(NaturalLanguageHelper.getRequest(getModel().getTweetText())).execute()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AnnotateTextResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(AnnotateTextResponse annotateTextResponse) {
                        AppLog.v(AppLog.TAG, "Success");
                        presenter.onSuccess(getModel());

                    }

                    @Override
                    public void onError(Throwable e) {
                        AppLog.e(AppLog.TAG, "Error", e);
                        presenter.onError();
                    }
                });

    }

}