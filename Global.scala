import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    println("hello")
  }  
  
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
    println("hello")
  }  
    
}