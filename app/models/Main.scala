import models.SearchStreamer

object Main {
	println("hello")
	def main(args: Array[String]){
		println("Worker process woke up")
  		val search = Array("tech@nyu","Tech@nyu","techatnyu","Techatnyu")
  		SearchStreamer.run(search)
    }
}