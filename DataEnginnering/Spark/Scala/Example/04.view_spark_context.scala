import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}

object ViewSparkContext {
  def main(args : Array[String]) : Unit {
    var conf = new SparkConf().setAppName("Read Text File in Spark").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    sc.getConf.getAll
    sc.stop()
  }
} 
