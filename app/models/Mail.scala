package models

import play.api.Play.current
import com.typesafe.plugin._

case class Mail()

object Mail {
def sendEmail(message: String) = {
	val mail = use[MailerPlugin].email
      .setSubject("New tech@nyu tweet")
      .addRecipient(System.getenv("EMAIL1"),System.getenv("EMAIL2"))
      .addFrom("Tech@nyu Twitter Feed<techatnyutwitter@tapingo.com>")

    mail.send(message)
    	
    }   
} 
    
