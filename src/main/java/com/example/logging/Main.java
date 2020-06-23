package com.example.logging;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "logging")
public class Main {

  public static void main(String[] args) {
    Quarkus.run();
    Quarkus.waitForExit();
  }

}
