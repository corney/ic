package com.github.corney.image.converter

import java.io.{File, OutputStream, PrintWriter}

import com.sksamuel.scrimage.Image

import scala.collection.BitSet


class Converter(file: File) {

  def convert(): Array[Byte] = {
    val image = Image.fromFile(file)

    val width = 128 // image.width
    val height = 64 // image.height
    val threshold = -1000000

    println(s"Image: $width x $height")

    {
      for {
        y <- 0 until height by 8
        x <- 0 until width
      } yield {
        (0 until 8).fold(0) {
          case (acc: Int, i: Int) =>
            val pixel = image.pixel(x, y + i)

            if (pixel.toInt < threshold)
              acc | 1 << i
            else
              acc
        }.toByte
      }
    }.toArray

//    Array.empty
  }
}

object Converter {
  def apply(file: File): Converter = new Converter(file)


}
