package io.github.morgaroth.sbt.commons

import sbt.ModuleID

/**
  * Created by mateusz on 06.01.16.
  */
trait LogbackLibraries extends JavaLibraryHelpers {

  object Logback {

    object Classic {
      val ver: (String) => ModuleID = javaLibrary("ch.qos.logback", "logback-classic", _)
      val `1.2.3` = ver("1.2.3")
      val `1.2.2` = ver("1.2.2")
      val `1.2.1` = ver("1.2.1")
      val `1.2.0` = ver("1.2.0")
      val `1.1.11` = ver("1.1.11")
      val `1.1.10` = ver("1.1.10")
      val `1.1.9` = ver("1.1.9")
      val `1.1.8` = ver("1.1.8")
      val `1.1.7` = ver("1.1.7")
      val `1.1.6` = ver("1.1.6")
      val `1.1.5` = ver("1.1.5")
      val `1.1.4` = ver("1.1.4")
      val `1.1.3` = ver("1.1.3")
      val `1.1.2` = ver("1.1.2")
      val `1.1.1` = ver("1.1.1")
      val `1.1.0` = ver("1.1.0")
      val `1.0.13` = ver("1.0.13")
      val last: ModuleID = `1.2.3`
    }

    object Extensions {
      val repository = Repositories.NetExacode.releases

      val ver: (String) => ModuleID = javaLibrary("net.exacode.logback", "logback-extensions", _)
      val `1.1.0` = ver("1.1.0")
      val last: ModuleID = `1.1.0`
    }

  }

}
