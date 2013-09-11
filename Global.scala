import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    import play.api.libs.concurrent.Akka
    import akka.util.duration._
    Akka.system(app).scheduler.schedule(10 seconds, 30 minutes){
    	import models.SearchStreamer
    	println("Worker process woke up")
  		val search = Array("tapingo","Tapingo")
  		SearchStreamer.run(search)
    }
  }  
  
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }  
    
}