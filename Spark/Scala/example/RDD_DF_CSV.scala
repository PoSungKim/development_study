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
    // val fileName  = "fhvhv_tripdata_2020-03.csv"
    val fileName  = "test.csv"
    
    // 1. RDD >> CSV 저장 
    val RDD = spark.sparkContext.textFile("file:///"+directory+"/"+fileName)
    RDD.saveAsTextFile("./data/outcome")

    // 2. RDD >> DataFrame >> Partition 1개로 통합 >> CSV 저장
    case class Raw(c1 : String, c2: String, c3: String)
    val splitRDD = RDD.map(e => Raw(e.split(",")(0), e.split(",")(1),e.split(",")(2)))
    splitRDD.toDF().coalesce(1).write.format("csv").save("./data/csv/")
    splitRDD.toDF().coalesce(1).write.format("parquet").save("./data/parquet/")

    // 3. DataFrame >> CSV 저장
    val df = spark.read.csv("file:///"+directory+"/"+fileName)
    df.show()
    df.write.format("csv").save("./data/csv/")
    df.write.format("parquet").save("./data/parquet/")
    }
}
