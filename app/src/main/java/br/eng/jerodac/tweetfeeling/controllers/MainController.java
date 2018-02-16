package br.eng.jerodac.tweetfeeling.controllers;

import br.eng.jerodac.tweetfeeling.models.Model;

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

    public Model getModel(){
        return mModel;
    }

    public void setTagTweet(String tag) {
        mModel.setTweetTag(tag);

    }

}
