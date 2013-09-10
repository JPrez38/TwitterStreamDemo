package models


object Main {
	def main = Action{
  		val search = Array("tapingo","Tapingo")
  		SearchStreamer.run(search)
    }
}