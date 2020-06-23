package com.example.logging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class LogMessage {

  @JsonProperty
  private final String level;
  @JsonProperty
  private final String message;

  @JsonCreator
  public LogMessage(@JsonProperty("level") String level,
                    @JsonProperty("message") String message) {
    this.level = level;
    this.message = message;
  }

  public String level() {
    return level;
  }

  public String message() {
    return message;
  }

}
