import scala.collection.mutable.ListBuffer

object ParseData {
  var col = 0.0
  val alpha = 0.5
  def main(args: Array[String]) = {
    var temp = new ListBuffer[Float]()
    // Locate file location for your DataSet
    val bufferedSource = io.Source.fromFile("C:/Users/RSABA/workspace/WeatherAnalysis/src/WeatherDataset_Final.csv")
    println("WeatherStation Year-Month Temp  Pressure")
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      println(cols { (11) } + "|" + cols { (10) } + "|" + cols { (1) } + "|" + cols { (4) } + "|" + cols { (5) })
      col = cols { (2) }.toDouble
      temp += col.toFloat
    }
    println("____________________________________________________________________")
    println(mean(temp))
    bufferedSource.close
  }

  def mean(xs: Iterable[Float]) = xs.sum / xs.size

  def medianFilteredCities() = {
    //Exponential Smoothening
  }

}