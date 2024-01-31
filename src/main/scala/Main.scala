import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("mongo spark debug")
      .config("spark.master", "local")
      .getOrCreate()

    val df = spark.read.format("mongodb")
      .option("connection.uri", "mongodb://phong:phongbui@127.0.0.1:27017/?authSource=admin")
      .option("database", "local")
      .option("collection", "startup_log")
      .option("aggregation.pipeline", """{"$project": {"json": "$$ROOT"}}""")
      .schema(StructType(Seq(
        StructField("json", StringType, nullable = true)
      )))
      .load()


    df.show(truncate = false)
  }
}