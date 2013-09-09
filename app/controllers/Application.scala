package controllers

import play.api._
import play.api.mvc._
import models.Mail
import models.SearchStreamer

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready. " + System.getProperty("javax.net.ssl.trustStore")))
  }

  def startstream = Action{
  	val search = Array("tapingo","Tapingo")
  	SearchStreamer.run(search)
  	Ok(views.html.index("Your new application is ready. " + System.getProperty("javax.net.ssl.trustStore")))
  }
  
}
