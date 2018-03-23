package com.github.corney.image

import java.io.File

import com.github.corney.image.converter.Converter

object Main extends App {
//  val file = new File(args(0))

  val file = new File("source.png")


  if (file.exists()) {
    val converter = Converter(file)

    val array = converter.convert()


  }

}
