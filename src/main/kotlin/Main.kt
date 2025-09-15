import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.utils.use
import ai.koog.prompt.executor.clients.bedrock.BedrockModels
import ai.koog.prompt.executor.llms.all.simpleBedrockExecutor

suspend fun main() {
    val awsAccessKeyId = System.getenv("AWS_ACCESS_KEY_ID")
    val awsSecretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY")

    val result = AIAgent(
        executor = simpleBedrockExecutor(awsAccessKeyId, awsSecretAccessKey),
        llmModel = BedrockModels.AmazonNovaLite
    ).use { agent ->
        agent.run("Tell me a joke")
    }

    println(result)
}
