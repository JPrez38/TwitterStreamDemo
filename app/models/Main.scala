import models.SearchStreamer

object Main {
	println("hello")
	def main(args: Array[String]){
		println("Worker process woke up")
  		val search = Array("tapingo -RT","Tapingo -RT")
  		SearchStreamer.run(search)
    }
}