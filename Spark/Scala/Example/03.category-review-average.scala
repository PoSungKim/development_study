import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object CategoryReviewAverage {
    def main(args : Array[String]) : Unit {
        var conf = new SparkConf().setAppName("Read Text File in Spark").setMaster("local[*]")
        val sc = new SparkContext(conf)
        
        val directory = "/Users/posungkim/Desktop/Portfolio/Big_Data_Platform/data-engineering/01-spark/data"
        val fileName  = "restaurant_reviews.csv"

        val lines = sc.textFile(s"file:///$directory/$fileName")
        lines.collect()

        val header = lines.first()
        val filteredLines = lines.filter(e=>e != header)
        filteredLines.collect()

        def parse(str : String): Tuple2[String, Int] = {
            val fields = str.split(",")
            val category = fields(2).trim()
            val reviews = fields(3).trim().toInt
            return (category, reviews)
        }

        val categoryReviews = filteredLines.map(parse)
        categoryReviews.collect()

        val categoryReviewCount = categoryReviews.mapValues(e => (e, 1))
        categoryReviewCount.collect()

        val reduced = categoryReviewCount.reduceByKey( (x,y) => (x.productElement(1).toString.toInt + y._1, x._2 + y._2))
        reduced.collect()

        val averages = reduced.mapValues( x => (x._1 / x._2))
        

        val df = averages.toDF()
        df.show()

        df.coalesce(1).write.format("csv").save(s"./data/${fileName.substring(0, 18)}")
    }
}
