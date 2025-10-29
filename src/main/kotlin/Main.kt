import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient
import ai.koog.prompt.executor.clients.bedrock.BedrockModels
import ai.koog.prompt.executor.llms.SingleLLMPromptExecutor
import ai.koog.utils.io.use
import aws.sdk.kotlin.services.bedrockruntime.BedrockRuntimeClient

suspend fun main() {
    // this supports AWS_BEARER_TOKEN_BEDROCK
    val result = BedrockRuntimeClient.fromEnvironment().use { bedrockRuntimeClient ->
        AIAgent(
            promptExecutor = SingleLLMPromptExecutor(BedrockLLMClient(bedrockRuntimeClient)),
            llmModel = BedrockModels.AmazonNovaLite
        ).use { agent ->
            agent.run("Tell me a joke")
        }
    }

    println(result)
}
