package io.github.morgaroth.sbt.commons

import sbt.ModuleID

/**
 * Created by mateusz on 15.10.15.
 */
trait JavaLibraries extends JavaLibraryHelpers {

  object Joda {

    object Time {
      val ver: (String) => ModuleID = javaLibrary("joda-time", "joda-time", _)
      val `2.8.2` = ver("2.8.2")
    }

    object Convert {
      val ver: (String) => ModuleID = javaLibrary("org.joda", "joda-convert", _)
      val `1.7` = ver("1.7")
    }

  }

  object Typesafe {
    val typesaveLibrary: (String, String) => ModuleID = javaLibrary("com.typesafe", _, _)

    object Config {
      val ver: (String) => ModuleID = typesaveLibrary("config", _)
      val `1.3.0` = ver("1.3.0")
      val `1.2.1` = ver("1.2.1")
    }

  }

  object Tumblr {

    object Jumblr {
      val ver: (String) => ModuleID = javaLibrary("com.tumblr", "jumblr", _)
      val `0.0.11` = ver("0.0.11")
    }

  }

}
