// src/main/java/com/example/agent/ScienceTeacher.java
package com.example.agent;

import com.google.adk.agents.LlmAgent;
import com.google.adk.web.AdkWebServer;

/* 
The AI agent is configured via the LlmAgent.builder() method. The name(), description(), and model() parameters are mandatory, 
and to give a specific personality and proper behavior to your agent, you should always give detailed guidance via the instruction() method.
Here we chose to use the Gemini 2.5 Flash model, but feel free to try Gemini 2.5 Pro as well, for more complicated tasks.
This agent is wrapped within the AdkWebServer.start() method. This is the so-called ADK Dev UI chat interface. 
It allows you to converse with the agent via a typical chat interface. 
Furthermore, it's of great help if you want to understand what's going on under the hood, 
like all the events that are flowing through the system, the requests and responses sent to the LLM.
*/

public class ScienceTeacher {
    public static void main(String[] args) {
        //This utility launches a local web server with a chat interface, allowing you to interactively test your agent immediately.
        AdkWebServer.start(
            LlmAgent.builder() //
                .name("science-teacher")
                .description("A friendly science teacher")
                // This is the core of your agent. It's the system prompt that defines the agent's persona, its goal, and its constraints. A well-crafted instruction is critical for getting the desired behavior. 
                .instruction("""
                    You are a science teacher for teenagers.
                    You explain science concepts in a simple, concise and direct way.
                    """)
                .model("gemini-2.5-flash") //We specify "gemini-2.5-flash", a powerful and efficient model from the Gemini family, to power the agent's reasoning.
                .build()
        );
    }
}