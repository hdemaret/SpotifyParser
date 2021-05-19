package parser

import org.apache.spark.sql.DataFrame
import parser.Parser.mSpark
import mSpark.implicits._

import java.nio.file.{Files, Paths}

object ParserUtilities {

  def readFromCsv(iPath: String): DataFrame = {
    if (Files.exists(Paths.get(iPath))) {
      println(s"""Read csv from "$iPath"""")
      mSpark
        .read
        .option("delimiter", ";")
        .option("header", "true")
        .csv(iPath)
    }else{
      println(s"""File in "$iPath doesn't exist"""")
      mSpark.emptyDataFrame
    }
  }

  def readFromJson(iPath: String): DataFrame = {
    if (Files.exists(Paths.get(iPath))) {
      println(s"""Read csv from "$iPath"""")
      mSpark
        .read
        .json(iPath)
    }else{
      println(s"""File in "$iPath" doesn't exist"""")
      mSpark.emptyDataFrame
    }
  }

  def dataFrameToList(iDf: DataFrame, iCol: String): List[String] = {
      iDf
        .select(iCol)
        .map(lData => lData.getString(0))
        .collect()
        .toList
  }
}
