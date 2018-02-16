package br.eng.jerodac.tweetfeeling.controllers;

import android.util.Log;

import com.google.api.services.language.v1beta2.model.AnnotateTextResponse;

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

    public void analytzText() {
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
                        Log.v("TAG", "sucesso");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("TAG", "Erro:" + e.getMessage());
                        Log.v("TAG", "Erro:" + e.getCause());
                    }
                });

    }

}