package br.eng.jerodac.tweetfeeling.controllers;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class MainController {

    private static MainController INSTANCE;

    public static MainController getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MainController();
        }
        return INSTANCE;
    }

    private MainController(){

    }

    public void getTweetList(){

    }

}
