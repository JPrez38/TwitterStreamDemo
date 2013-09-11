package models
 
import twitter4j._


object Util {
  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey(System.getenv("OAUTHCONSUMERKEY"))
    .setOAuthConsumerSecret(System.getenv("OAUTHCONSUMERSECRET"))
    .setOAuthAccessToken(System.getenv("OAUTHACCESSTOKEN"))
    .setOAuthAccessTokenSecret(System.getenv("OAUTHACCESSTOKENSECRET"))
    .build

  def simpleStatusListener = new StatusListener() {
	  def onStatus(status: Status) { 
      println(status.getText) 
      Mail.sendEmail(status.getText)
    }
	  def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
	  def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
	  def onException(ex: Exception) { ex.printStackTrace }
	  def onScrubGeo(arg0: Long, arg1: Long) {}
	  def onStallWarning(warning: StallWarning) {}
  }
}
object StatusStreamer {
  val twitterStream = new TwitterStreamFactory(Util.config).getInstance
  twitterStream.addListener(Util.simpleStatusListener)
  twitterStream.sample
  Thread.sleep(2000)
  twitterStream.cleanUp
  twitterStream.shutdown  
}

object SearchStreamer {
  def run(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    twitterStream.filter(new FilterQuery().track(args))

  }
}