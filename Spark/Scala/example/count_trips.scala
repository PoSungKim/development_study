// 패키지
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

// Spark 설정
object ReadTextFile {
  def main(args : Array[String]) : Unit = {
    var conf = new SparkConf().setAppName("Read Text File in Spark").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // 우리가 가져올 데이터가 있는 파일
    val directory = "/Users/posungkim/Desktop/Portfolio/Big_Data_Platform/data-engineering/01-spark/data"
    val fileName  = "fhvhv_tripdata_2020-03.csv"
    
    // 1. 일자별 Count
    val RDD = spark.sparkContext.textFile("file:///"+directory+"/"+fileName)
    val Header = RDD.first()
    val filteredLines = RDD.filter(e=>e != Header)
    val dates = filteredLines.map(e=>e.split(",")(2).split(" ")(0))
    val result = dates.countByValue()
    val df = result.toSeq.toDF("key", "value")
    df.show()
    df.write.format("csv").save("./data/csv/")
    }
}
