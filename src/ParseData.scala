import scala.collection.mutable.ListBuffer

object ParseData {
  var col = 0.0
  def main(args: Array[String]) = {
    emitData() // To Emit Data from Excel and calculating the mean value for Temperature column
    expSmootheningTemp() // Exponential Smoothening based on Time Analysis-Formulation F t+1 = Ft + alpha*(Temperature - Ft)
  }

  def mean(xs: Iterable[Float]) = xs.sum / xs.size

  def emitData() = {
    var temp = new ListBuffer[Float]()
    val bufferedSource = io.Source.fromFile("src/WeatherDataset_Final.csv")     // Locate file location for your DataSet
    println("WeatherStation Year-Month Temp  Pressure")
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      println(cols { (11) } + "|" + cols { (10) } + "|" + cols { (1) } + "|" + cols { (4) } + "|" + cols { (5) })
      col = cols { (2) }.toDouble
      temp += col.toFloat
    }
    println("---------------------------")
    println("  Mean Temp = " + mean(temp))
    println("---------------------------")
  }

  def expSmootheningTemp() = {
    val alpha = 0.5
    var Fi = 0.0
    val bufferedSource = io.Source.fromFile("src/WeatherDataset_Final.csv") //Locate file location for your DataSet
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      col = cols { (2) }.toDouble
      Fi = (Fi + alpha * (col - Fi))
      println(Fi)
    }
    println("-------------")
  }

}