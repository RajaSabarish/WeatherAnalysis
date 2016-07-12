import scala.collection.mutable.ArrayBuffer


object ParseData {
  def main( args: Array[String]) = {
    val bufferedSource = io.Source.fromFile("C:/Sabarish/Data/WeatherDataset_Training.csv")
      for (line <- bufferedSource.getLines) {
          val cols = line.split(",").map(_.trim)
          // do whatever you want with the columns here
          println(s"${cols(11)}|${cols(10)}|${cols(2)}|${cols(3)}")
      }
      bufferedSource.close
  }
}