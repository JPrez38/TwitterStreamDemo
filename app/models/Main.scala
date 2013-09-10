package models


object Main {
	println("hello")
	def main(){
		println("Worker process woke up")
  		val search = Array("tapingo","Tapingo")
  		SearchStreamer.run(search)
    }
}