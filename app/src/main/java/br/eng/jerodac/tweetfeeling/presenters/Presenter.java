package br.eng.jerodac.tweetfeeling.presenters;

import br.eng.jerodac.tweetfeeling.models.Model;

/**
 * Created by Jean Rodrigo on 16/02/2018.
 */
public interface Presenter {

    void onSuccess(Model model);

    void onError();
}
