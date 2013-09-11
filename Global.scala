import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    import play.api.libs.concurrent.Akka
    import scala.concurrent.duration._
    import play.api.libs.concurrent.Execution.Implicits._
    import ExecutionContext.Implicits.global
    Akka.system(app).scheduler.schedule(10 seconds, 40000 minutes){
    	import models.SearchStreamer
    	println("Worker process woke up")
  		val search = Array("tapingo","Tapingo")
  		SearchStreamer.run(search)
    }
  }  
  
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
    import models.Mail
    Mail.sendEmail("APPLICATION SHUTDOWN")
  }  
    
}