import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object RddTransformationsActions {
    def main(args : Array[String]) : Unit {
        conf = new SparkConf().setMaster("local[*]").setAppName("RddTransformationsActions")
        sc = new SparkContext(conf=conf)
        
        val foods = sc.parallelize(Seq("짜장면", "마라탕", "짬뽕", "떡볶이", "쌀국수", "짬뽕", "짜장면", "짜장면", "짜장면", "라면", "우동", "라면"))
        foods.collect()
        foods.countByValue()
        foods.take(5)
        foods.count()
        foods.distinct().collect()
        foods.distinct().count()
        foods.foreach(print)
        
        val movies = sc.parallelize(Array("그린 북", "매트릭스", "토이 스토리", "캐스트 어웨이", "포드 V 페라리", "보헤미안 랩소디", "백 투 더 퓨처", "반지의 제왕", "죽은 시인의 사회"))
        // 한 단계 Flat하게 만드는 함수 flatMap() (ex : ['a'], ['b'] >> 'a', 'b' )
        val splitedMoviesRdd = movies.flatMap(x=>x.split(" "))
        splitedMoviesRdd.collect()

        val nums1 = sc.parallelize(Array(1,2,3,4))
        val nums2 = sc.parallelize(Array(4,5,6,7))
        nums1.intersection(nums2).collect()           // (4)
        nums1.union(nums2).collect()                  // (1,2,3,4,4,5,6,7)
        nums1.subtract(nums2).collect()               // (1,2,3)

        val unionNums = nums1.union(nums2)
        unionNums.sample(true, 0.5).collect()         // 랜덤
        unionNums.sample(true, 0.5, seed=5).collect() // 고정

        for ((k,v) <- foods.groupBy(x=>x.charAt(0)).collect())
            printf("Key : %s, Value : %s\n", k, v)

        for ( (k, v) <- unionNums.groupBy(x=>x % 2).collect())
            printf("Key : %s, Value : %s\n", k, v)
    }
}
