object Main {
	println("hello")
	def main(args: Array[String]){
		println("Worker process woke up")
  		val search = Array("tapingo","Tapingo")
  		SearchStreamer.run(search)
    }
}