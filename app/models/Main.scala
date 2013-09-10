package models


object Main {
	def main(){
		Mail.sendEmail("hello")
  		val search = Array("tapingo","Tapingo")
  		SearchStreamer.run(search)
    }
}