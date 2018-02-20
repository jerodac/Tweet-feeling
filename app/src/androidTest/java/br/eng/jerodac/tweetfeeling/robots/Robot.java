package br.eng.jerodac.tweetfeeling.robots;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 19/02/2018.
 */
public class Robot {
    public static SearchTweetTagRobot getSearchTweetTagRobot() {
        return new SearchTweetTagRobot();
    }

    public static ListTweetsRobot getListTweetRobot(){
        return new ListTweetsRobot();
    }
}
