package models

import play.api.Play.current
import com.typesafe.plugin._

case class Mail()

object Mail {
def sendEmail(message: String) = {
	val mail = use[MailerPlugin].email
      .setSubject("New Tapingo Tweet")
      .addRecipient(System.getenv("EMAIL1"),System.getenv("EMAIL2"))
      .addFrom("Tapingo Twitter Feed<tapingotwitter@tapingo.com>")

    mail.send(message)
    	
    }   
} 
    